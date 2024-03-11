package alex.tir.cloud_storage_back.service.impl;

import alex.tir.cloud_storage_back.dto.*;
import alex.tir.cloud_storage_back.entity.Folder;
import alex.tir.cloud_storage_back.entity.User;
import alex.tir.cloud_storage_back.mapper.UserMapper;
import alex.tir.cloud_storage_back.repo.RoleRepository;
import alex.tir.cloud_storage_back.repo.UserRepository;
import alex.tir.cloud_storage_back.service.AuthenticationService;
import alex.tir.cloud_storage_back.service.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;

    @Override
    public UserInfo signUp(UserForm userForm){
        User user = new User();
        user.setEmail(userForm.getEmail());
        user.setFirstName(userForm.getFirstName());
        user.setLastName(userForm.getLastName());
        user.getRoles().add(roleRepository.getUserRole());
        user.setPassword(passwordEncoder.encode(userForm.getPassword()));

        Folder root = new Folder();
        root.setName(UUID.randomUUID().toString());
        root.setRoot(true);
        root.setOwner(user);
        user.getFolders().add(root);
        user = userRepository.save(user);
        return userMapper.mapUser(user);
    }

    @Override
    public JwtAuthenticationResponse singIn(LoginForm loginForm){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginForm.getEmail(),
                loginForm.getPassword()));
        var user = userRepository.findByEmail(loginForm.getEmail()).orElseThrow(()-> new IllegalArgumentException("Invalid email or password"));
        var jwt = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(new HashMap<>(),user);

        JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();
        jwtAuthenticationResponse.setToken(jwt);
        jwtAuthenticationResponse.setRefreshToken(refreshToken);
        return jwtAuthenticationResponse;
    }

    @Override
    public JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest){
        String email = jwtService.extractUserName(refreshTokenRequest.getToken());
        User user = userRepository.findByEmail(email).orElseThrow();
        if (jwtService.isTokenValid(refreshTokenRequest.getToken(),user)){
            var jwt = jwtService.generateToken(user);
            JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();
            jwtAuthenticationResponse.setToken(jwt);
            jwtAuthenticationResponse.setRefreshToken(refreshTokenRequest.getToken());
            return jwtAuthenticationResponse;
        }
        return null;
    }
}
