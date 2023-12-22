package com.fakerservice.client;

import com.fakerservice.request.PostRequest;
import com.fakerservice.response.PostResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.*;

import java.util.List;

@HttpExchange(url = "https://fakestoreapi.com")

public interface FakerPublicClient {
    @GetExchange("/products")
    List<PostResponse> allProducts();
    @GetExchange("/products/{id}")
    PostResponse getProductById(@PathVariable("id") Integer id);

    @PostExchange("/products")
    PostResponse createProduct(@RequestBody PostRequest postRequest);

    @PutExchange("/products/{id}")
    PostResponse updateProduct(@PathVariable Integer id,@RequestBody PostRequest postRequest);

    @DeleteExchange("/products/{id}")
    PostResponse deleteById(@PathVariable Integer id);

}
