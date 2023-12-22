package com.testSSE.SSE.api.user.web;

import com.testSSE.SSE.api.user.User;
import com.testSSE.SSE.api.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
        @PostMapping("create")
        public Mono<ResponseEntity<UserDto>> userCreate(@RequestBody UserDto userDto){
            return userService.saveUser(userDto)
                    .map(savedUser -> ResponseEntity.status(HttpStatus.CREATED).body(savedUser));
        }

    @GetMapping("find")
    public Flux<ResponseEntity<User>> findAll(){
        return userService.getAll().map(userDto -> ResponseEntity.status(HttpStatus.OK).body(userDto)) ;
    }
    @GetMapping(value = "{id}/users")
    public Mono<ResponseEntity<UserDto>> getAllById(@PathVariable("id") String id){
//            Mono<UserDto> userDto = userService.getById(id);
            return userService.getById(id).map(userId ->ResponseEntity.status(HttpStatus.OK).body(userId));
    }


    @PutMapping(value = "{id}/users")
    public Mono<ResponseEntity<UserDto>> updateById(@PathVariable("id") String id,@RequestBody UserDto userDto){
//            Mono<UserDto> userDto = userService.getById(id);

        return userService.updateById(id,userDto).map(userId ->ResponseEntity.status(HttpStatus.OK).body(userId));
    }
    @DeleteMapping(value = "{id}/deletes")
    public Mono<ResponseEntity<Object>> deleteById(@PathVariable("id") String id) {
        return userService.deleteById(id)
                .map(user -> ResponseEntity.status(HttpStatus.NO_CONTENT).build())
              ;
    }



}
