package com.fakerservice.dto;

import com.fakerservice.response.PostResponse;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;
@Builder
public record NewsFeedDto(Long id,
                          List<PostResponse> posts,
                          LocalDateTime timestamp) {
}
