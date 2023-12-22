package com.microservice.serverinstanceBreactiveWeb.api.post;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;


    @GetMapping("/stream")
    public Flux<ServerSentEvent<List<Post>>> streamPosts() {
        return postService.streamPosts();
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.ok(postService.getAll());
    }

    @GetMapping(value = "/{postID}")
    public ResponseEntity<Post> getPostById(@PathVariable String postID) {
        return ResponseEntity.ok(postService.getPostByID(postID));
    }

    @PostMapping
    public ResponseEntity<Mono<Post>> createPost(@RequestBody Post post) {
        return ResponseEntity.ok(postService.create(post));
    }







    @DeleteMapping("/{postID}")
    public ResponseEntity<?> deletePostByID(@PathVariable String postID) {
        postService.deletePostByID(postID);
        return ResponseEntity.ok().build();
    }

}
