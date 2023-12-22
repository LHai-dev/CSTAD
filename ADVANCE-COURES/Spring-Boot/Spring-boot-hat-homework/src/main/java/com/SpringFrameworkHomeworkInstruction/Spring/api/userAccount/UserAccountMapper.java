package com.SpringFrameworkHomeworkInstruction.Spring.api.userAccount;

import com.SpringFrameworkHomeworkInstruction.Spring.api.user.UserMapper;
import com.SpringFrameworkHomeworkInstruction.Spring.api.userAccount.web.UserAccountDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserAccountMapper {
    UserAccountMapper INSTANCE = Mappers.getMapper(UserAccountMapper.class);
    UserAccountDto mapUserAccountToUserAccountDto(UserAccount userAccount);

    List<UserAccountDto> mapListUserAccountToListUserAccount(List<UserAccount> userAccounts);
}
