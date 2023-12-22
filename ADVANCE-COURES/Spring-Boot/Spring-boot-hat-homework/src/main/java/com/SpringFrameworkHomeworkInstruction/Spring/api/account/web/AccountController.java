package com.SpringFrameworkHomeworkInstruction.Spring.api.account.web;

import com.SpringFrameworkHomeworkInstruction.Spring.api.account.Account;
import com.SpringFrameworkHomeworkInstruction.Spring.api.account.AccountService;
import com.SpringFrameworkHomeworkInstruction.Spring.api.user.User;
import com.SpringFrameworkHomeworkInstruction.Spring.api.user.web.CreateUserDto;
import com.SpringFrameworkHomeworkInstruction.Spring.base.BaseApi;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/accounts")
public class AccountController {
    private final AccountService accountService;

    @GetMapping
    public CollectionModel<?> findAccount() {
        return accountService.findAllAccount();
    }

    @GetMapping("/{uuid}")
    public EntityModel<?> findAccountById(@PathVariable("uuid") String uuid) {
        return accountService.findByUuidAccount(uuid);
    }

    @PutMapping("/{uuid}/close")
    public EntityModel<?> disableAccountByUuid(@PathVariable String uuid) {
        EntityModel account = accountService.disableAccount(uuid);
        Link link = linkTo(methodOn(AccountController.class).disableAccountByUuid(uuid)).withSelfRel();
        return EntityModel.of(account,link);
    }

    @PostMapping("")
    public BaseApi<?> createUser(@RequestBody CreateAccountDto createAccountDto) {

        Account account = accountService.CreateAccount(createAccountDto);

        return BaseApi.builder()
                .code(HttpStatus.OK.value())
                .data(account)
                .message("Nice")
                .timeStamp(LocalDateTime.now())
                .build();
    }


    @PostMapping("{uuid}/rename")
    public BaseApi<?> renameAccount(@RequestBody RenameAccountDto renameAccountDto, @PathVariable("uuid") String uuid) {

        Account account = accountService.renameAccount(uuid, renameAccountDto);

        return BaseApi.builder()
                .code(HttpStatus.OK.value())
                .data(account)
                .message("Nice")
                .timeStamp(LocalDateTime.now())
                .build();
    }

    @PostMapping("{uuid}/limit-transfer")
    public BaseApi<?> limitTransferAccount(@RequestBody LimitTransferAccountDto limitTransferAccountDto, @PathVariable("uuid") String uuid) {
        Account account = accountService.limitTransfer(uuid, limitTransferAccountDto);
        return BaseApi.builder()
                .code(HttpStatus.OK.value())
                .data(account)
                .message("Nice")
                .timeStamp(LocalDateTime.now())
                .build();
    }

}
