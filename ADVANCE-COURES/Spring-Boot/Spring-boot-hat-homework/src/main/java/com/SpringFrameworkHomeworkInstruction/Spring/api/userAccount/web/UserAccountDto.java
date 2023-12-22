package com.SpringFrameworkHomeworkInstruction.Spring.api.userAccount.web;

import com.SpringFrameworkHomeworkInstruction.Spring.api.account.Account;
import com.SpringFrameworkHomeworkInstruction.Spring.api.user.User;

public record UserAccountDto(
        Long id,
        Boolean isDisabled,
        User user,
        Account account
) {

}
