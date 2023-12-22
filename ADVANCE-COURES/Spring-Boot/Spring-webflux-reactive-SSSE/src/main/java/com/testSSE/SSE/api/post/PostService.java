package com.testSSE.SSE.api.post;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
@ComponentScan
@Slf4j
@RequiredArgsConstructor
@Transactional
public class PostService {

    private final PostRepository postRepository;

    public Mono<Post> create(Post post) {

        post.setCreated(LocalDateTime.now());
        return postRepository.save(post);
    }



    public List<Post> getAll() {
        return postRepository.findAll().collectList().block(); // Blocking operation
    }

    public Post getPostByID(String postID) {
        return postRepository.findPostById(postID).orElseThrow(() -> new RuntimeException("post not found!"));
    }

    public void deletePostByID(String postID) {
        var post = postRepository.findPostById(postID).orElseThrow(() -> new RuntimeException("post not found!"));
        postRepository.delete(post);
    }



    public Flux<ServerSentEvent<List<Post>>> streamPosts() {
        return Flux.interval(Duration.ofSeconds(2))
                .publishOn(Schedulers.boundedElastic())
                .map(sequence -> ServerSentEvent.<List<Post>>builder().id(String.valueOf(sequence))
                        .event("post-list-event").data(getAll())
                        .comment("it work 100%")
                        .build());
    }
}
