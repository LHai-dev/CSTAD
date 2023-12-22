package com.SpringFrameworkHomeworkInstruction.Spring.api.account;

import com.SpringFrameworkHomeworkInstruction.Spring.api.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
    Optional<Account> findByUuid(String uuid);


}
