package com.SpringFrameworkHomeworkInstruction.Spring.api.userAccount.web;

import com.SpringFrameworkHomeworkInstruction.Spring.api.userAccount.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user-accounts")
public class UserAccountController {
    private final UserAccountService userAccountService;
    @GetMapping
    public CollectionModel<?> findUserAccount() {
        return userAccountService.findAllUserAccount();
    }

    @GetMapping("/{id}")
    public EntityModel<?> findUserAccountById(@PathVariable("id") Long id) {
        return userAccountService.findByIdUserAccount(id);
    }


}
