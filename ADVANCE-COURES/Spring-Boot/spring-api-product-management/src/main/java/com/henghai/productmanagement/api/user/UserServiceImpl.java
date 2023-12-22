package com.henghai.productmanagement.api.user;

import com.henghai.productmanagement.api.product.Product;
import com.henghai.productmanagement.api.user.web.CreateUserDto;
import com.henghai.productmanagement.api.user.web.SaveUserDto;
import com.henghai.productmanagement.api.user.web.UpdateUserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{
    private final UserMapper userMapper;
    private final UserMapStruct userMapStruct;
    @Override
    public List<SaveUserDto> findAll() {
        List<User> users = userMapper.selectAll();
        return userMapStruct.toDto(users);
    }

    @Override
    public SaveUserDto createUser(CreateUserDto createUser) {
        User user = userMapStruct.toEntityCreate(createUser);
        userMapper.insert(user);
        return this.getUserById(user.getId());
    }

    @Override
    public Integer deleteUserById(Integer id) {
        if (userMapper.existsUser(id)){
            userMapper.deleteById(id);
            return id;
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("User with %d is not found", id));
        }

    }

    @Override
    public SaveUserDto getUserById(Integer id) {
        User user =  userMapper.getUserById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Not your id:",id)));
        return userMapStruct.toDtoSaveUserDto(user);
    }

    @Override
    public SaveUserDto updateUserById(Integer id, UpdateUserDto updateUserDto) {
        if (userMapper.existsUser(id)){
            User user = userMapStruct.toEntityUpdate(updateUserDto);
            user.getId();
            userMapper.updateUserBuId(user);
            return this.getUserById(id);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("not found this Id:",id));
        }

    }

}
