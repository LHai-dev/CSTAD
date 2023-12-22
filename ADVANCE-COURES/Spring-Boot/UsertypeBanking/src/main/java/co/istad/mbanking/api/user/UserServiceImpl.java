package co.istad.mbanking.api.user;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService
{
    private final UserMapper userMapper;
    private final UserMapStruct userMapStruct;




    @Override
    public UerDto CreateNewUser(CeateUserDto ceateUserDto) {
        User user = userMapStruct.createUserDtoToUser(ceateUserDto);
        System.out.println(user);

        userMapper.insert(user);
        log.info("User = {}",user.getId());
        return this.findUserById(user.getId());
    }

    @Override
    public UerDto findUserById(Integer id) {
        User user = userMapper.selectById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("User With %d is not found",id)));
        return userMapStruct.userToUserDto(user);
    }

    @Override
    public Integer deleteUserById(Integer id) {
        Boolean isFound = userMapper.existById(id);
//        System.out.println(isFound);
        if(isFound){
            //delete
            userMapper.deleteById(id);
            return id;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("User With %d is not found"));

    }

    @Override
    public Integer updateISDeletedStatusById(Integer id ,boolean status) {
        Boolean isExisted = userMapper.existById(id);
        if(isExisted){
            userMapper.updateIsDeletedById(id , status);
            return id;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("User With %d is not found"));


    }

    @Override
    public PageInfo<UerDto> findAllUser(int page, int limit) {
        //call repo
        PageInfo<User> userPageInfo = PageHelper.startPage(page , limit).doSelectPageInfo(userMapper::select);

        return userMapStruct.userPageInfoToUserDtoPageInfo(userPageInfo);
    }

    @Override
    public UerDto updateUserById(int id, UpdateUserDto updateUserDto) {
//
//        User user = userMapper.selectById(id).orElseThrow(()->
//                new ResponseStatusException(HttpStatus.NOT_FOUND,
//                        String.format("User With %d is not found",id)));
        if (userMapper.existById(id)){
           User user = userMapStruct.updataUserDtoUse(updateUserDto);
           userMapper.updateById(user);
           user.setId(id);
           return this.findUserById(id);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User With %d is not found",id));
    }

    @Override
    public Integer updateIsDeletedStatus(Integer id, boolean status) {
        boolean isFound = userMapper.existById(id);
        if (isFound){
            userMapper.updateIsDeletedById(id, status);
            return id;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("User with id=%d is not found.",id));
    }

    @Override
    public UerDto findUserByStudentCardId(String studentCardId) {
         User user  = userMapper.selectById(Integer.valueOf(studentCardId)).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        String.format("User with %s is not found.",studentCardId)
                )
        );

        return userMapStruct.userToUserDto(user);
    }


}
