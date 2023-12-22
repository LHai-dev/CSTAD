package com.microservice.serverinstanceAjpa.api.user.web;

import java.time.LocalDateTime;

public record PostDto(
         String id,
         String content,
         LocalDateTime created,
         String postImageUrl
) {
}
