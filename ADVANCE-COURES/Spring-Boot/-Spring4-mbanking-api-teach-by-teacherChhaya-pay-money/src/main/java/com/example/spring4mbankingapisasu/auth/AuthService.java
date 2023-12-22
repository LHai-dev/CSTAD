package com.example.spring4mbankingapisasu.auth;

import com.example.spring4mbankingapisasu.auth.web.AuthDto;
import com.example.spring4mbankingapisasu.auth.web.LoginDto;
import com.example.spring4mbankingapisasu.auth.web.RegisterDto;

public interface AuthService {
    void register(RegisterDto registerDto);
    void verify(String email);
    void checkVerifiedCode(String email, String verifiedCode);
    AuthDto login(LoginDto loginDto);
}
