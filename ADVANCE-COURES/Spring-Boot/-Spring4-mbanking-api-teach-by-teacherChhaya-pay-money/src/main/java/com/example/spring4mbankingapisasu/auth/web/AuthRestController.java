package com.example.spring4mbankingapisasu.auth.web;

import com.example.spring4mbankingapisasu.auth.AuthService;
import com.example.spring4mbankingapisasu.base.BaseApi;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthRestController {
    private final AuthService authService;



    @PostMapping("/login")
    public  BaseApi<?> login(@Valid @RequestBody LoginDto loginDto){
        //call service
        AuthDto authDto = authService.login(loginDto);
        authService.login(loginDto);
//        authService.register();
        return  BaseApi.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("You have been login  successfully")
                .timestamp(LocalDateTime.now())
                .data(authDto)
                .build();
    }

    @PostMapping("/register")
    public BaseApi<?> register(@Valid @RequestBody RegisterDto registerDto) {

        //call service
        authService.register(registerDto);

        return BaseApi.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("You have been registered successfully")
                .timestamp(LocalDateTime.now())
                .data(registerDto.email())
                .build();
    }

    @PostMapping("/verify")
    public BaseApi<?> verify(@RequestParam String email) {
        System.out.println(email);
        authService.verify(email);
        return BaseApi.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("Please check email and verify")
                .timestamp(LocalDateTime.now())
                .data(email)
                .build();
    }

    @GetMapping("/check-verify")
    public BaseApi<?> checkVerified(@RequestParam String email, @RequestParam String verifiedCode) {
        System.out.println("Email : "+email);
        System.out.println("verifiedCode : "+verifiedCode);

        authService.checkVerifiedCode(email, verifiedCode);
        System.out.println("email : " + email);
        return BaseApi.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("success")
                .timestamp(LocalDateTime.now())
                .data(email)
                .build();
    }
}
