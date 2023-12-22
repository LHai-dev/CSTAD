package com.SpringFrameworkHomeworkInstruction.Spring.api.user;

import com.SpringFrameworkHomeworkInstruction.Spring.api.user.web.CreateUserDto;
import com.SpringFrameworkHomeworkInstruction.Spring.api.user.web.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDto toUserCreateDto(CreateUserDto createUserDto);
    CreateUserDto toUserDto(UserDto userDto);

    User toEntity(CreateUserDto createUserDto);


    UserDto mapUserToUserDto(User user);

    List<UserDto> mapProductsToProductDtoList(List<User> user);
}
