package com.testSSE.SSE.api.user;

import com.testSSE.SSE.api.user.web.UserDto;
import org.springframework.beans.BeanUtils;
import reactor.core.publisher.Mono;

public class UserMapper {
    static public User dtoToUser(UserDto userDto){
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        return user;
    }
    public static UserDto entityToDto(User userEntity) {
        UserDto userDto = new UserDto();
//        userDto.setId(userEntity.getId());
        userDto.setName(userEntity.getName());
        userDto.setAddress(userEntity.getAddress());
        userDto.setEmail(userEntity.getEmail());
        // Set other properties based on the user entity
        return userDto;
    }
    static public UserDto userToDto(User user){
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        return userDto;
    }

}
