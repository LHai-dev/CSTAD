package com.SpringFrameworkHomeworkInstruction.Spring.api.user;

import com.SpringFrameworkHomeworkInstruction.Spring.api.account.Account;
import com.SpringFrameworkHomeworkInstruction.Spring.api.user.web.CreateUserDto;
import com.SpringFrameworkHomeworkInstruction.Spring.api.user.web.UpdateUserDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

import java.util.List;

public interface UserService {
    User CreateUser(CreateUserDto createUserDto);

    CollectionModel<?> findAllUser();

    EntityModel<?> findUserByUuid(String uuid);

    User disableUser(String uuid);


    User updateUserByUuid(String uuid, UpdateUserDto updatedUser);

    void deleteUserByUuid(String uuid);


    Account getFindByUser_UuidAndAccount_Uuid(String userUuid,String accountUuid);

    CollectionModel<?>  getUserAccountsByUuid(String uuid);

}
