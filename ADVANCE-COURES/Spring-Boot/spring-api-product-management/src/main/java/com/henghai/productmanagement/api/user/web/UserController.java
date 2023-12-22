package com.henghai.productmanagement.api.user.web;

import com.henghai.productmanagement.api.user.UserService;
import com.henghai.productmanagement.base.BaseApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;
    @GetMapping()
    public BaseApi<?> FindAll() {
        List<SaveUserDto> users = userService.findAll();
        return BaseApi.builder()
                .code(HttpStatus.OK.value())
                .data(users)
                .status(true)
                .message("successfully")
                .timeStamp(LocalDateTime.now())
                .build();
    }

    @GetMapping("{id}")
    public BaseApi<?> getById(@PathVariable("id")Integer id) {
        SaveUserDto userDto = userService.getUserById(id);
        return BaseApi.builder()
                .code(HttpStatus.OK.value())
                .data(userDto)
                .status(true)
                .message("successfully")
                .timeStamp(LocalDateTime.now())
                .build();
    }
    @PostMapping()
    public BaseApi<?> insertUser(@RequestBody CreateUserDto createUserDto) {
      SaveUserDto userDto = userService.createUser(createUserDto);
        return BaseApi.builder()
                .code(HttpStatus.OK.value())
                .data(userDto)
                .status(true)
                .message("successfully")
                .timeStamp(LocalDateTime.now())
                .build();
    }
    @DeleteMapping("/{id}")
    public BaseApi<?> deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUserById(id);
        return BaseApi.builder()
                .code(HttpStatus.OK.value())
                .data(id)
                .status(true)
                .message("successfully")
                .timeStamp(LocalDateTime.now())
                .build();
    }

    @PutMapping("/{id}")
    public BaseApi<?> updateUserById(@PathVariable("id") Integer id,@RequestBody UpdateUserDto updateUserDto) {
   userService.updateUserById(id,updateUserDto);
        return BaseApi.builder()
                .code(HttpStatus.OK.value())
                .data(updateUserDto)
                .status(true)
                .message("successfully")
                .timeStamp(LocalDateTime.now())
                .build();
    }

}
