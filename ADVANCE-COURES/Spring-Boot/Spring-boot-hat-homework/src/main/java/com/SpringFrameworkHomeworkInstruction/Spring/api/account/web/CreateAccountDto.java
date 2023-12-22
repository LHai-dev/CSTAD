package com.SpringFrameworkHomeworkInstruction.Spring.api.account.web;

import com.SpringFrameworkHomeworkInstruction.Spring.api.accountType.AccountType;
import com.SpringFrameworkHomeworkInstruction.Spring.api.userAccount.UserAccount;

import java.util.List;

public record CreateAccountDto(
        Long id,
        String actName,
        String actNo,
        Double transferLimit,
        String pin,
        String uuid,
        List<UserAccount> userAccounts,
        AccountType accountTypes
) {
}
