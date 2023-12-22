package com.example.spring4mbankingapisasu.auth.web;

import com.example.spring4mbankingapisasu.vaidator.password.Password;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginDto(
        @Email
        @NotBlank String email,
        @NotBlank
        @Password String password

                       ) {
}
