package co.istad.mbanking.api.accounttype;

import co.istad.mbanking.api.user.UerDto;
import co.istad.mbanking.api.user.User;
import org.mapstruct.Mapper;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;
@Mapper(componentModel = "spring")
public interface AccountTypeMapStuct {
//    List<AccountTypeDto> toDtoList(List<AccountType> model);
//    AccountTypeDto toDto(AccountType model);

    List<AccountTypeDto> toDto(List<AccountType> model);

    AccountType createUserDtoToUser(CreateAccountTypeDto createAccountTypeDto);

    AccountTypeDto accountTypeToAccountTypeDto(AccountType accountType);


    AccountTypeDto accountToAccountDto(User user);

}
