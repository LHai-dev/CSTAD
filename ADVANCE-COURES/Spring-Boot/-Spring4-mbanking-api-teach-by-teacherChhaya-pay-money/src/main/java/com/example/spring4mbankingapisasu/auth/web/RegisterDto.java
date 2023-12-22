package com.example.spring4mbankingapisasu.auth.web;

import com.example.spring4mbankingapisasu.vaidator.email.EmailUnique;
import com.example.spring4mbankingapisasu.vaidator.email.RoleIdConstraint;
import com.example.spring4mbankingapisasu.vaidator.password.Password;
import com.example.spring4mbankingapisasu.vaidator.password.PasswordMatch;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.List;



@Builder
@PasswordMatch(password = "password" ,confirmedPassword = "confirmedPassword")
public record RegisterDto(
                            @NotBlank(message = "Email is required")
                            @EmailUnique
                            @Email
                            String email,
                            @NotBlank(message = "password is required")
                            @Password
                            String password,
                            @NotBlank(message = "Confirmed password is required")
                            @Password
                            String confirmedPassword,
                            @NotNull(message = "Roles are required.")
                            @RoleIdConstraint
                            List<Integer> roleIds
                            ) {
}
