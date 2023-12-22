package com.SpringFrameworkHomeworkInstruction.Spring.api.user;

import com.SpringFrameworkHomeworkInstruction.Spring.api.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    List<User> findByIsDeleteFalse();
    Optional<User> findByUuid(String uuid);
}
