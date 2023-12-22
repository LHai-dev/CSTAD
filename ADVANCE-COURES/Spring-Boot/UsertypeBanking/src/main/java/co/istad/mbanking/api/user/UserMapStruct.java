package co.istad.mbanking.api.user;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapStruct {
    User createUserDtoToUser(CeateUserDto ceateUserDto);
    User updataUserDtoUse(UpdateUserDto updateUserDto);
    UerDto userToUserDto(User user);
    User userDtoToDto(UerDto user);
    PageInfo<UerDto> userPageInfoToUserDtoPageInfo(PageInfo<User> userPageInfo);

}
