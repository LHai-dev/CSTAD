package com.example.spring4mbankingapisasu.user.web;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record SaveUserDto(@NotBlank String name ,
                          String one_signal ,
                          @NotBlank String gender ,
                          String studentCard ,
                          @NotNull Boolean isStudent) {}

