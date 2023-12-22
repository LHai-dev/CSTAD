package com.SpringFrameworkHomeworkInstruction.Spring.api.accountType;

import com.SpringFrameworkHomeworkInstruction.Spring.api.userAccount.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountTypeRepository extends JpaRepository<AccountType,Long> {
}
