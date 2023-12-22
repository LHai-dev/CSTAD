package com.henghai.productmanagement.api.user;

import com.henghai.productmanagement.api.user.web.CreateUserDto;
import com.henghai.productmanagement.api.user.web.SaveUserDto;
import com.henghai.productmanagement.api.user.web.UpdateUserDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapStruct {
    User toEntity(SaveUserDto userDto);
    List<SaveUserDto> toDto(List<User> user);
    User toEntityCreate(CreateUserDto createUserDto);
    SaveUserDto toDtoSaveUserDto(User user);
    User toEntityUpdate(UpdateUserDto updateUserDto);
}
