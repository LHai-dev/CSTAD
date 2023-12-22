package com.testSSE.SSE.api.user;

import com.testSSE.SSE.api.employee.AppUtils;
import com.testSSE.SSE.api.user.web.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    @Override
    public Mono<UserDto> saveUser(UserDto userDTO) {
        User user = UserMapper.dtoToUser(userDTO);
        return userRepository.save(user)
                .map(savedUser -> UserMapper.userToDto(savedUser));
    }

    @Override
    public Flux<User> getAll() {
//        User user = UserMapper.
        return userRepository.findAll();
    }

    @Override
    public Mono<UserDto> getById(String id) {
        return userRepository.findById(id).map(UserMapper::entityToDto);
    }

    @Override
    public Mono<UserDto> updateById(String id, UserDto userDto) {

        return userRepository.findById(id)
                .flatMap(user -> {
                    // Update the user's fields
                    user.setName(userDto.getName());
                    user.setAddress(userDto.getAddress());
                    user.setEmail(userDto.getEmail());

                    // Save the updated user
                    return userRepository.save(user);
                })
                .map(UserMapper::entityToDto); // Map the updated user to a DTO
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return userRepository.findById(id).flatMap(unused -> userRepository.deleteById(id))
                .switchIfEmpty(Mono.empty()); // Handle the case when the record doesn't exis;
    }

}
