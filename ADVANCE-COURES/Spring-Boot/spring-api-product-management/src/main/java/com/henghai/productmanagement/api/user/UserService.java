package com.henghai.productmanagement.api.user;

import com.henghai.productmanagement.api.user.web.CreateUserDto;
import com.henghai.productmanagement.api.user.web.SaveUserDto;
import com.henghai.productmanagement.api.user.web.UpdateUserDto;

import java.util.List;

public interface UserService {
    List<SaveUserDto> findAll();
    SaveUserDto createUser(CreateUserDto createUser);
    Integer deleteUserById(Integer id);
    SaveUserDto getUserById(Integer id) ;
    SaveUserDto updateUserById(Integer id, UpdateUserDto updateUserDto);
}
