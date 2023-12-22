package co.hai.microservices.core.user.api;


import co.hai.microservices.core.user.api.web.CreateUserDto;
import co.hai.microservices.core.user.api.web.ResponseDto;
import co.hai.microservices.core.user.api.web.UpdateUserDto;
import co.hai.microservices.core.user.api.web.UserDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeoutException;

public interface UserService {
    User CreateUser(CreateUserDto createUserDto);

    CollectionModel<?> findAllUser();

    EntityModel<?> findUserByUuid(String uuid);

    User disableUser(String uuid);

    ResponseDto getUserById(Long id) throws TimeoutException;
    User updateUserByUuid(String uuid, UpdateUserDto updatedUser);

    void deleteUserByUuid(String uuid);
    User findUsersByUuid(String uuid);
    UserDto findUserById(Long id);
}
