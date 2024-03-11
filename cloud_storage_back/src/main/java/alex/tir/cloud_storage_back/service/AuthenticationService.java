package alex.tir.cloud_storage_back.service;

import alex.tir.cloud_storage_back.dto.*;

public interface AuthenticationService {
    UserInfo signUp(UserForm userForm);

    JwtAuthenticationResponse singIn(LoginForm loginForm);

    JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
