package com.webclient.demo.api.post;

import org.springframework.http.codec.ServerSentEvent;
import reactor.core.publisher.Flux;

import java.util.List;

public interface PostService {
    Flux<ServerSentEvent<List<Post>>> streamDataSse();
}
