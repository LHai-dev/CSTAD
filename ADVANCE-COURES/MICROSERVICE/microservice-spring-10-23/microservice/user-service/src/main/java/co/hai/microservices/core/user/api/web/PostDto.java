package co.hai.microservices.core.user.api.web;

import java.time.LocalDateTime;

public record PostDto(
         String id,
         String content,
         LocalDateTime created,
         String postImageUrl
) {
}
