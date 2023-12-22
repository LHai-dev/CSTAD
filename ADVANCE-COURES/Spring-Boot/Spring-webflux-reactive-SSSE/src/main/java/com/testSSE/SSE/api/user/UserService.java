package com.testSSE.SSE.api.user;

import com.testSSE.SSE.api.user.web.UserDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<UserDto> saveUser(UserDto userDTO);
    Flux<User> getAll();
    Mono<UserDto> getById(String id);
    Mono<UserDto> updateById(String id,UserDto userDto);
    Mono<Void> deleteById(String id);
}
