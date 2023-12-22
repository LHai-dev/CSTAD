package com.example.spring4mbankingapisasu.user.web;

import com.example.spring4mbankingapisasu.base.BaseApi;
import com.example.spring4mbankingapisasu.user.UserService;
import com.github.pagehelper.PageInfo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;
    @PostMapping("/creates")
    public BaseApi<?> create(@Valid  @RequestBody SaveUserDto saveUserDto){
        UserDto userDto = userService.create(saveUserDto);
//        System.out.println(saveUserDto);
        return BaseApi.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("User has been saved")
                .timestamp(LocalDateTime.now())
                .data(userDto)
                .build();
    }
    @GetMapping
    public BaseApi<?> findAllUser(){
var userDtoList =userService.findAllUser();
return BaseApi.builder()
        .status(true)
        .code(HttpStatus.OK.value())
        .message("All User have been Found")
        .timestamp(LocalDateTime.now())
        .data(userDtoList)
        .build();
}

    @GetMapping("/{id}")
    public BaseApi<?> findById(@PathVariable Integer id) {
        UserDto userDto = userService.findById(id);
        return BaseApi.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("User has been found")
                .timestamp(LocalDateTime.now())
                .data(userDto)
                .build();
    }

    @PutMapping("/{id}")
    public BaseApi<?> updateById(@PathVariable int id,
                                 @Valid @RequestBody SaveUserDto saveUserDto) {

        UserDto userDto = userService.updateById(id, saveUserDto);

        return BaseApi.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("User has been saved")
                .timestamp(LocalDateTime.now())
                .data(userDto)
                .build();
    }


    @PutMapping
    public BaseApi<?> pageInOf(@RequestParam(required = false , defaultValue = "1") int pageNum,
                               @RequestParam(required = false , defaultValue = "25") int pageSize){
        PageInfo<UserDto> userDtoPageInfo = userService.userDtoPageInfo(pageNum , pageSize);
        return BaseApi.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("Users have been found")
                .timestamp(LocalDateTime.now())
                .data(userDtoPageInfo)
                .build();
    }

    @DeleteMapping("/deletes/{id}")
    public BaseApi<?> handleDeleteRequest(@PathVariable Integer id){
        UserDto userDto = userService.deleteById(id);

        log.info(id.toString());
        return BaseApi.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("Users have been found")
                .timestamp(LocalDateTime.now())
                .data(userDto)
                .build();
    }



    @DeleteMapping("/{id}")
    public BaseApi<?> deleteUserById(@PathVariable Integer id){
        return BaseApi
                .builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("User has been deleted successfully")
                .timestamp(LocalDateTime.now())
                .data(userService.deleteById(id))
                .build();
    }








}
