package co.hai.microservices.core.user.api;

import co.hai.microservices.core.user.APIClient;
import co.hai.microservices.core.user.api.web.*;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.TimeoutException;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserModelAssembler userModelAssembler;
    private final APIClient client;
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
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

//    private void randomlyRunLong(){
//        Random rand = new Random();
//        int randomNum = rand.nextInt(3) + 1;
//        if (randomNum==3) sleep();
//    }
//
//    private void sleep(){
//        try {
//            Thread.sleep(5000);
//            throw new java.util.concurrent.TimeoutException();
//        } catch (InterruptedException | TimeoutException e) {
//            logger.error(e.getMessage());
//        }
//    }
int count  = 1;
    //@FeignClient
    // Specify the CircuitBreaker name and the fallback method
    @Override
    @CircuitBreaker(name = "userService", fallbackMethod = "buildFallbackUserList")
//    @Bulkhead(name = "bulkheadUserService" ,fallbackMethod = "buildFallbackUserList")
    @Retry(name = "retryUserService")
//    @RateLimiter(name = "UserService", fallbackMethod = "buildFallbackUserList")
    public ResponseDto getUserById(Long id){
        // Your existing code
//        randomlyRunLong();
        System.out.println("retry method called " + count++ +"time at"+ new Locale.Builder());
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            UserFallbackDto userDto = UserMapper.INSTANCE.toDto(user);
            DepartmentFallbackDto departmentDto = client.getDepartmentById(user.getId());
            ResponseDto responseDto = new ResponseDto();
            responseDto.setUser(userDto);
            responseDto.setDepartment(departmentDto);
            return responseDto;
        } else {
            return null;
        }
    }

    // Fallback method
    private ResponseDto buildFallbackUserList(Long id, Throwable t) {
        // Create a response with a fallback user and department
        User user = userRepository.findById(id).orElse(null);

        UserFallbackDto fallbackUserDto = new UserFallbackDto();

        fallbackUserDto.setId(id);
        if (user != null) {
           fallbackUserDto= UserMapper.INSTANCE.toDto(user);
        }

        DepartmentFallbackDto fallbackDepartmentDto = new DepartmentFallbackDto();
        fallbackDepartmentDto.setId(id);
        fallbackDepartmentDto.setDepartmentCode(t.getMessage());
        fallbackDepartmentDto.setDepartmentAddress(t.fillInStackTrace().toString());
        fallbackDepartmentDto.setDepartmentName("Fallback Department");

        ResponseDto responseDto = new ResponseDto();
        responseDto.setUser(fallbackUserDto);
        responseDto.setDepartment(fallbackDepartmentDto);
        return responseDto;
    }

    // userService
    private void randomlyRunLong(){
        Random rand = new Random();
        int randomNum = rand.nextInt((3 - 1) + 1) + 1;
        if (randomNum==3) sleep();
    }
    private void sleep(){
        try {
            Thread.sleep(11000);
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
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

    @Override
    public UserDto findUserById(Long id) {
        User userss = userRepository.findById(id).orElseThrow();
       UserDto users = UserMapper.INSTANCE.mapUserToUserDto(userss);
        return users;
    }

}
