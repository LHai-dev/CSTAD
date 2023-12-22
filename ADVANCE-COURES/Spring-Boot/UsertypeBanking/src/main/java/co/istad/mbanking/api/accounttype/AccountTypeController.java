package co.istad.mbanking.api.accounttype;

import co.istad.mbanking.api.base.BaseRest;
import co.istad.mbanking.api.user.isDeletedDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/account-types")
@RequiredArgsConstructor
public class AccountTypeController {
    private final AccountTypeSevice accountTypeSevice;

    @GetMapping()
    public BaseRest<?> findAll(){
        var accountTypeDtoList = accountTypeSevice.findAll();
        return BaseRest.builder()
                .status(true).code(HttpStatus.OK.value())
                .message("Account type have been found")
                .timeStap(LocalDateTime.now())
                .data(accountTypeDtoList)
                .build();
    }

    @PostMapping("/added-account")
    public BaseRest<?> createAccountType(@RequestBody CreateAccountTypeDto createAccountTypeDto){


        return BaseRest
                .builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("Account types has been found")
                .timeStap(LocalDateTime.now())
                .data(accountTypeSevice.createNewAccount(createAccountTypeDto))
                .build();
    }

    @GetMapping("/{id}")
    public BaseRest<?> selectById(@PathVariable int id){
        AccountTypeDto accountTypeDto = accountTypeSevice.findAccountTypeById(id);
        return BaseRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("Account type have been found successfully.")
                .timeStap(LocalDateTime.now())
                .data(accountTypeDto)
                .build();
    }

    @DeleteMapping("/{id}")
    public BaseRest<?> deleteById(@PathVariable int id){
        Integer actId = accountTypeSevice.deleteById(id);
        return BaseRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("Account Type have been deleted successfully.")
                .timeStap(LocalDateTime.now())
                .data(actId)
                .build();
    }



    @PutMapping("/{id}")
    public BaseRest<?> updateUser(@PathVariable Integer id,@RequestBody AccountTypeDto accountTypeDto){
        AccountTypeDto account = accountTypeSevice.updateById(id,accountTypeDto);
        return BaseRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("Account type have been update successfully.")
                .timeStap(LocalDateTime.now())
                .data(account)
                .build();
    }
}
