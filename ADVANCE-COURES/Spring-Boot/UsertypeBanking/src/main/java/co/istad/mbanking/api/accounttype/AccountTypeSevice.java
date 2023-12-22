package co.istad.mbanking.api.accounttype;

import co.istad.mbanking.api.user.UpdateUserDto;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AccountTypeSevice{
    List<AccountTypeDto> findAll();


    AccountTypeDto createNewAccount(CreateAccountTypeDto createAccountTypeDto);


    AccountTypeDto findAccountTypeById(Integer id);

    Integer deleteById(Integer id);


    AccountTypeDto updateById(Integer id, AccountTypeDto accountTypeDto);





}
