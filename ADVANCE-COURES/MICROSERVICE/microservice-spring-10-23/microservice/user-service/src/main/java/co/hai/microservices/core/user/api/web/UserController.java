package co.hai.microservices.core.user.api.web;


import co.hai.microservices.core.user.api.User;
import co.hai.microservices.core.user.api.UserService;
import co.hai.microservices.core.user.base.BaseApi;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeoutException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
@Log4j2
public class UserController {

    private final UserService userService;

    @PostMapping("")
    public BaseApi<?> createUser(@RequestBody CreateUserDto createUserDto) {

        User user = userService.CreateUser(createUserDto);

        return BaseApi.builder()
                .code(HttpStatus.OK.value())
                .data(user)
                .message("Nice")
                .timeStamp(LocalDateTime.now())
                .build();
    }

    @PutMapping("/update/{uuid}")
    public BaseApi<?> updateUser(@RequestBody UpdateUserDto createUserDto,@PathVariable("uuid") String uuid) {

        User user = userService.updateUserByUuid(uuid,createUserDto);

        return BaseApi.builder()
                .code(HttpStatus.OK.value())
                .data(user)
                .message("Nice")
                .status(true)
                .timeStamp(LocalDateTime.now())
                .build();
    }



    @DeleteMapping("/delete/{uuid}")
    public BaseApi<?> deleteUser(@PathVariable("uuid") String uuid) {
        userService.deleteUserByUuid(uuid);


        return BaseApi.builder()
                .code(HttpStatus.OK.value())
                .data("your uuid delete : "+uuid)
                .message("Nice")
                .status(true)
                .timeStamp(LocalDateTime.now())
                .build();
    }

    @GetMapping
    public CollectionModel<?> findUsers() {
        return userService.findAllUser();
    }

    @GetMapping("/{uuid}")
    public EntityModel<?> findUsersByUuid(@PathVariable String uuid) {
        return userService.findUserByUuid(uuid);
    }
    @GetMapping("/users/{uuid}")
    public ResponseEntity<User> findUserByUuid(@PathVariable String uuid) {
        try {
            User user = userService.findUsersByUuid(uuid);
            return ResponseEntity.ok(user);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{uuid}/disable")

    public ResponseEntity<User> disableUserByUuid(@PathVariable String uuid) {
        User user = userService.disableUser(uuid);
        return ResponseEntity.ok(user);
    }



    @GetMapping("/{id}/user/department")
    public ResponseEntity<?> findUsersById(@PathVariable("id")Long id) throws TimeoutException {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping("/{id}/UserId")
    public ResponseEntity<?> findUsersByIdS(@PathVariable("id")Long id) {
        return ResponseEntity.ok(userService.findUserById(id));
    }
}
