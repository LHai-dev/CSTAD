package com.fakerservice.controller;

import com.fakerservice.client.JsonPlaceholderClient;
import com.fakerservice.config.HttpClientGenerator;
import com.fakerservice.dto.NewsFeedDto;
import com.fakerservice.response.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
@RestController
@RequiredArgsConstructor
public class NewsFeedController {
    private final JsonPlaceholderClient jsonPlaceholderClient;

    public NewsFeedController() {
        jsonPlaceholderClient = HttpClientGenerator
                .createService(JsonPlaceholderClient.class);
    }

    @ResponseStatus(HttpStatus.OK)
        @GetMapping("/news-feed")
    public NewsFeedDto loadNewsFeed() {

        List<PostResponse> posts = jsonPlaceholderClient.allPosts();

        NewsFeedDto newsFeedDto = NewsFeedDto.builder()
                .id(1L)
                .posts(posts)
                .timestamp(LocalDateTime.now())
                .build();

        return newsFeedDto;
    }
}
