package com.microservice.serverinstanceAjpa.api.user;

import com.microservice.serverinstanceAjpa.APIClient;
import com.microservice.serverinstanceAjpa.api.user.web.*;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserModelAssembler userModelAssembler;
    private final APIClient client;
    @Override
    public User CreateUser(CreateUserDto createUserDto) {
        User user =  UserMapper.INSTANCE.toEntity(createUserDto);
        user.setUuid(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public CollectionModel<?> findAllUser() {
        List<User> users = userRepository.findByIsDeleteFalse();
        return userModelAssembler.toCollectionModel(users);
    }

    @Override
    public EntityModel<?> findUserByUuid(String uuid) {
        User user = userRepository.findByUuid(uuid).orElseThrow();
        return userModelAssembler.toModel(user);
    }

    @Override
    public User disableUser(String uuid) {
        User existingUser = userRepository.findByUuid(uuid)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        existingUser.setIsDelete(true); // Disable the user
        BeanUtils.copyProperties(existingUser,uuid);
        return userRepository.save(existingUser);
    }

    @Override
    public ResponseDto getUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);

        if (user != null) {
            // Use the UserMapper to map User entity to UserDto
            UserDto userDto = UserMapper.INSTANCE.mapUserToUserDto(user);

            // Assuming that the client.getDepartmentById(user.getId()) method returns a DepartmentDto
            DepartmentDto departmentDto = client.getDepartmentById(user.getId());

            // Create a ResponseDto and set the UserDto and DepartmentDto
            ResponseDto responseDto = new ResponseDto();
            responseDto.setUser(userDto);
            responseDto.setDepartment(departmentDto);

            return responseDto;
        } else {
            return null;
        }
    }



    @Override
    public User updateUserByUuid(String uuid, UpdateUserDto updatedUser) {
     User user =   userRepository.findByUuid(uuid).orElseThrow(() -> new EntityNotFoundException("User not found"));
        BeanUtils.copyProperties(updatedUser,user,uuid);

        return userRepository.save(user);
    }

    @Override
    public void deleteUserByUuid(String uuid) {
     User user =  userRepository.findByUuid(uuid).orElseThrow(() -> new EntityNotFoundException("User not found"));

     userRepository.delete(user);
    }


    // In UserServiceImpl.java
    @Override
    public User findUsersByUuid(String uuid) {
        Optional<User> userOptional = userRepository.findByUuid(uuid);
        return userOptional.orElseThrow(() -> new NoSuchElementException("User not found"));
    }

}
