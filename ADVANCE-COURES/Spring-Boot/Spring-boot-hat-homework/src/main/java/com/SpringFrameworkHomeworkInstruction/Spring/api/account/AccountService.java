package com.SpringFrameworkHomeworkInstruction.Spring.api.account;

import com.SpringFrameworkHomeworkInstruction.Spring.api.account.web.CreateAccountDto;
import com.SpringFrameworkHomeworkInstruction.Spring.api.account.web.LimitTransferAccountDto;
import com.SpringFrameworkHomeworkInstruction.Spring.api.account.web.RenameAccountDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

public interface AccountService {
    EntityModel<?> findByUuidAccount(String uuid);
    CollectionModel<?> findAllAccount();
    EntityModel<?> disableAccount(String uuid);
    Account CreateAccount(CreateAccountDto createAccountDto);

    Account renameAccount(String uuid,RenameAccountDto renameAccountDto);
    Account limitTransfer(String uuid, LimitTransferAccountDto limitTransferAccountDto);

}
