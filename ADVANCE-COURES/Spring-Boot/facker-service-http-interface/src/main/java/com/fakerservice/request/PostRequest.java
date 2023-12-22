package com.fakerservice.request;

import lombok.Builder;

@Builder
public record PostRequest(
        Integer userId,
        String name,
        String title,
        String description
) {
}
