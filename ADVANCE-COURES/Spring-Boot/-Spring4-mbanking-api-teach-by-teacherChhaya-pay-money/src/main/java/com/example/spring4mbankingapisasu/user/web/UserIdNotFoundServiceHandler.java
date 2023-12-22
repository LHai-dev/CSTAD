package com.example.spring4mbankingapisasu.user.web;

import com.example.spring4mbankingapisasu.user.User;
import com.example.spring4mbankingapisasu.user.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
@Service
@RequiredArgsConstructor
public class UserIdNotFoundServiceHandler {
    private final UserMapper userMapper;
    public void HandlerId(Integer id){
        User user = userMapper.selectById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("User with %d is not found",id)));
    }
}
