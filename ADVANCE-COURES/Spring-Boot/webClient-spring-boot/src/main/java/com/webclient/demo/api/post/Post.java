package com.webclient.demo.api.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {
    private String id;
    private String content;
    private LocalDateTime created;
    private String postImageUrl;
}
