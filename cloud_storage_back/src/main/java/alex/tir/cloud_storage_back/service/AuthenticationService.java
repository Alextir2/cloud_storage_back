package alex.tir.cloud_storage_back.service;

import alex.tir.cloud_storage_back.dto.*;
import alex.tir.cloud_storage_back.entity.User;

public interface AuthenticationService {
    UserInfo signUp(UserForm userForm);

    JwtAuthenticationResponse singIn(LoginForm loginForm);

    JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
