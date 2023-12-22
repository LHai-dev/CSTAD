package com.example.spring4mbankingapisasu.user;

import com.example.spring4mbankingapisasu.user.web.SaveUserDto;
import com.example.spring4mbankingapisasu.user.web.UserDto;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserService {

    List<UserDto> findAllUser();

    UserDto create (SaveUserDto saveUserDto);

    UserDto updateById(Integer id , SaveUserDto saveUserDto);

    UserDto findById(Integer id);

    PageInfo<UserDto> userDtoPageInfo(int pageSize , int pageNum);

    UserDto deleteById(Integer id);







    Integer updateIsDeletedStatusById(Integer id,boolean status);




}
