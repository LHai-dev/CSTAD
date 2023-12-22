package co.istad.mbanking.api.user;

import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UerDto CreateNewUser(CeateUserDto ceateUserDto);
    UerDto findUserById(Integer id);
    Integer deleteUserById(Integer id);
    Integer updateISDeletedStatusById(Integer id , boolean status);

    PageInfo<UerDto> findAllUser(int page , int limit);


    //
    UerDto updateUserById(int id , UpdateUserDto updateUserDto);

    Integer updateIsDeletedStatus(Integer id,boolean status);

    UerDto findUserByStudentCardId(String studentCardId);


}
