package com.fakerservice.client;

import com.fakerservice.request.PostRequest;
import com.fakerservice.response.PostResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.*;

import java.util.List;

@HttpExchange(url = "https://jsonplaceholder.typicode.com")
public interface JsonPlaceholderClient {
    @GetExchange("/posts")
    List<PostResponse> allPosts();
    @GetExchange("/posts/{id}")
    PostResponse onePost(@PathVariable Integer id);
    @PostExchange("/posts")
    PostResponse savePost(@RequestBody PostRequest postRequest);
    @PutExchange("/posts/{id}")
    PostResponse updatePost(@PathVariable Integer id,
                            @RequestBody PostRequest postRequest);
    @DeleteExchange("/posts/{id}")
    void deletePost(@PathVariable Integer id);
}
