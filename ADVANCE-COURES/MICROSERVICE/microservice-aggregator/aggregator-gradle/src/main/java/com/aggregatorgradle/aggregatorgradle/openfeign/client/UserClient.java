package com.aggregatorgradle.aggregatorgradle.openfeign.client;

import com.aggregatorgradle.aggregatorgradle.response.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@FeignClient(name = "user-service",url ="http://localhost:8083/users")
public interface UserClient {
    @GetMapping
    Iterable<UserResponse> getAllUsers();
    @GetMapping("/{id}")
    UserResponse getUserById(@PathVariable Long id);
}
