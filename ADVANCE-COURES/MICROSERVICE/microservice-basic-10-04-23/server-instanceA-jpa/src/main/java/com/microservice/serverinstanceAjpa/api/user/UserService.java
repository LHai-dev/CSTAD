package com.microservice.serverinstanceAjpa.api.user;


import com.microservice.serverinstanceAjpa.api.user.web.CreateUserDto;
import com.microservice.serverinstanceAjpa.api.user.web.ResponseDto;
import com.microservice.serverinstanceAjpa.api.user.web.UpdateUserDto;
import com.microservice.serverinstanceAjpa.api.user.web.UserDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

public interface UserService {
    User CreateUser(CreateUserDto createUserDto);

    CollectionModel<?> findAllUser();

    EntityModel<?> findUserByUuid(String uuid);

    User disableUser(String uuid);

    ResponseDto  getUserById(Long id);
    User updateUserByUuid(String uuid, UpdateUserDto updatedUser);

    void deleteUserByUuid(String uuid);
    User findUsersByUuid(String uuid);
}
