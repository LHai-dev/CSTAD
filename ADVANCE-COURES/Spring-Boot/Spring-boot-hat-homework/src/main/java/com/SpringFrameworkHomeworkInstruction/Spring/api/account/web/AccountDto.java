package com.SpringFrameworkHomeworkInstruction.Spring.api.account.web;

import com.SpringFrameworkHomeworkInstruction.Spring.api.accountType.AccountType;
import com.SpringFrameworkHomeworkInstruction.Spring.api.userAccount.UserAccount;
import jakarta.persistence.ManyToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.Builder;
import lombok.Value;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Builder
public record AccountDto (


        String actName,
        String actNo,
        @Min(value = 0, message = "not")
        Double transferLimit,
        String pin,
        String uuid,
        List<UserAccount> userAccounts,
        AccountType accountTypes
) {
}
