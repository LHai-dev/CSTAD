package com.httpInterface.HttpInterface.api.web;

import com.httpInterface.HttpInterface.api.User;
import com.httpInterface.HttpInterface.api.UserClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/users")
public class UserRestController {
    private final UserClientService userClientService;

    public UserRestController(UserClientService userClientService) {
        this.userClientService = userClientService;
    }


    @PostMapping("/create")
    public Mono<ResponseEntity<User>> userCreate(@RequestBody User userDto) {
        Mono<User> userMono = userClientService.userCreate(userDto);
        return userMono.map(user -> ResponseEntity.ok(user))
                .defaultIfEmpty(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping(value = "/find", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Flux<User> findAll() {
        return userClientService.getAll();
    }

    @GetMapping(value = "/{id}")
    public Mono<ResponseEntity<User>> getById(@PathVariable String id) {
        Mono<User> userFlux = userClientService.getAllById(id);
        return userFlux.map(user -> ResponseEntity.ok(user))
                .defaultIfEmpty(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping(value = "/{id}")
    public Mono<ResponseEntity<User>> updateById(@PathVariable("id") String id,@RequestBody User user){
        Mono<User> userMono = userClientService.updateById(id,user);
        return userMono.map(user1 -> ResponseEntity.ok(user1))
                .defaultIfEmpty(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping(value = "/{id}")
    public Mono<Void> deleteById(@PathVariable("id") String id){
        Mono<Void> userMono = userClientService.deleteById(id);
        return userMono;
    }

}
