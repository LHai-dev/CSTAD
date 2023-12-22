package com.aggregatorgradle.aggregatorgradle.httpinterface.client;

import com.aggregatorgradle.aggregatorgradle.response.UserResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

@HttpExchange(url = "http://localhost:8083/users")
public interface UserClient {
    @GetExchange
    Iterable<UserResponse> getAllUsers();
    @GetExchange("/{id}")
    UserResponse getUserById(@PathVariable Long id);
}
