package co.istad.mbanking.api.accounttype;


import co.istad.mbanking.api.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
@RequiredArgsConstructor
public class AccountTypeSeviceImpl implements AccountTypeSevice{
    private final AccountTypeMapper accountTypeMapper;
    private final AccountTypeMapStuct accountTypeMapStuct;

    @Override
    public List<AccountTypeDto> findAll() {
        List<AccountType> accountTypes = accountTypeMapper.select();
//        System.out.println(accountTypes.get(0).getName());
        return accountTypeMapStuct.toDto(accountTypes);
    }

    @Override
    public AccountTypeDto createNewAccount(CreateAccountTypeDto createAccountTypeDto) {

          AccountType accountType = accountTypeMapStuct.createUserDtoToUser(createAccountTypeDto);
            System.out.println(accountType);

            accountTypeMapper.insert(accountType);
            log.info("User = {}",accountType.getId());
            return this.findAccountTypeById(accountType.getId());
        }

    @Override
    public AccountTypeDto findAccountTypeById(Integer id) {
       AccountType accountType = accountTypeMapper.selectById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Account Type With %d is not found",id)));
        return accountTypeMapStuct.accountTypeToAccountTypeDto(accountType);
    }

    @Override
    public Integer deleteById(Integer id) {
        if (accountTypeMapper.existUserById(id)){
            accountTypeMapper.deleteById(id);
            return id;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("account Type with id=%d is not found.",id));
    }

    @Override
    public AccountTypeDto updateById(Integer id, AccountTypeDto accountTypeDto) {
        return null;
    }


}



