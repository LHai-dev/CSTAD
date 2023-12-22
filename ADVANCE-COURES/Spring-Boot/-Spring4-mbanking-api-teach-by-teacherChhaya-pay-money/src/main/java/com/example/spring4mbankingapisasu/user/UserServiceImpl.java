package com.example.spring4mbankingapisasu.user;

import com.example.spring4mbankingapisasu.user.web.SaveUserDto;
import com.example.spring4mbankingapisasu.user.web.UserDto;
import com.example.spring4mbankingapisasu.user.web.UserIdNotFoundServiceHandler;
import com.example.spring4mbankingapisasu.util.FileUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.function.ToDoubleBiFunction;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapStruct userMapStruct;
    private final UserMapper userMapper;
    private final UserIdNotFoundServiceHandler userIdNotFoundServiceHandler;


    @Override
    public List<UserDto> findAllUser() {
        List<User> user = userMapper.findAllUser();
        return userMapStruct.toDto(user);
    }

    @Override
    public UserDto create(SaveUserDto saveUserDto) {
        User user = userMapStruct.saveUserDtoToUser(saveUserDto);
        userMapper.insert(user);
        System.out.println(user);

        return userMapStruct.userToUserDto(user);
    }

    @Override
    public UserDto updateById(Integer id, SaveUserDto saveUserDto) {
        if (userMapper.existsById(id)) {
            //TODO : update user
            User user = userMapStruct.saveUserDtoToUser(saveUserDto);
            user.setId(id);
            System.out.println(id);
            userMapper.update(user);
            return findById(id);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND
                , String.format("User with ID = %d is not found in DB", id));
    }

    @Override
    public UserDto findById(Integer id) {
        User user = userMapper.selectById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("User with ID = %d is not found in DB", id)));
        return userMapStruct.userToUserDto(user);
    }

    @Override
    public PageInfo<UserDto> userDtoPageInfo(int pageSize, int pageNum) {
        System.out.println(userMapper.select());
        //TODO call method select in mybatis mapper
        PageInfo<User> userPageInfo = PageHelper.startPage(pageSize, pageNum)
                .doSelectPageInfo(userMapper::select);
        return userMapStruct.userPageInfoToUserDtoPageInfo(userPageInfo);
    }

    @Override
    public UserDto deleteById(Integer id) {
        System.out.println(id);
        if (userMapper.existsById(id)) {
            UserDto userDto = findById(id);
            userMapper.updateDeletedById(id, true);
            return userDto;
        }
// throw exception
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("User with id %d is not found", id));
    }


    @Override
    public Integer updateIsDeletedStatusById(Integer id, boolean status) {
        if (userMapper.existsById(id)) {
            userMapper.updateDeletedById(id, status);
        } else {
            userIdNotFoundServiceHandler.HandlerId(id);
        }
        return id;
    }
}
