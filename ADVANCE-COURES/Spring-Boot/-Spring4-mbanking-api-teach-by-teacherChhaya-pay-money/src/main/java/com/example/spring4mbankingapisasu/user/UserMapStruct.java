package com.example.spring4mbankingapisasu.user;

import com.example.spring4mbankingapisasu.auth.web.RegisterDto;
import com.example.spring4mbankingapisasu.user.web.SaveUserDto;
import com.example.spring4mbankingapisasu.user.web.UserDto;
import com.github.pagehelper.PageInfo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapStruct {
    User saveUserDtoToUser(SaveUserDto saveUserDto);
    UserDto userToUserDto(User user);

    List<UserDto> toDto (List<User> model);

    PageInfo<UserDto> userPageInfoToUserDtoPageInfo(PageInfo<User> modal );

    User fromRegoisterDtoToUser(RegisterDto registerDto);
}
