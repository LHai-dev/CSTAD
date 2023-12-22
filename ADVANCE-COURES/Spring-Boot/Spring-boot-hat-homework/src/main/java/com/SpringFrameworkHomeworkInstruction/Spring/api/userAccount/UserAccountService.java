package com.SpringFrameworkHomeworkInstruction.Spring.api.userAccount;

import com.SpringFrameworkHomeworkInstruction.Spring.api.user.User;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

public interface UserAccountService {
    EntityModel<?> findByIdUserAccount(Long id);
    CollectionModel<?> findAllUserAccount();
}
