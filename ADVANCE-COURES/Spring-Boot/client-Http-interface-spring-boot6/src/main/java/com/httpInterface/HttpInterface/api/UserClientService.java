package com.httpInterface.HttpInterface.api;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.annotation.PutExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
public interface UserClientService {
    @PostExchange("/create")
    Mono<User> userCreate(@RequestBody User userDto);

    @GetExchange("/find")
    Flux<User> getAll();

    @GetExchange("/{id}/users")
    Mono<User> getAllById(@PathVariable String id);

    @PutExchange("{id}/users")
    Mono<User> updateById(@PathVariable("id") String id,@RequestBody User userDto);

    @DeleteExchange("{id}/deletes")
    Mono<Void> deleteById(@PathVariable("id") String id);

}
