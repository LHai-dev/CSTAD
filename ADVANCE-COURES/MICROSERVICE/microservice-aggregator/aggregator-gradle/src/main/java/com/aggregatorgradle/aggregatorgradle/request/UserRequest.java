package com.aggregatorgradle.aggregatorgradle.request;

import lombok.Builder;

@Builder
public record UserRequest(
        Long id,
        String username,
        String email
) {
}
