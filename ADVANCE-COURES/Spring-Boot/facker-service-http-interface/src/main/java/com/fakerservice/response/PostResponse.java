package com.fakerservice.response;

import lombok.Builder;

@Builder
public record PostResponse(
        Integer id,
        String title,
        Integer userId,
        String description
) {
}
