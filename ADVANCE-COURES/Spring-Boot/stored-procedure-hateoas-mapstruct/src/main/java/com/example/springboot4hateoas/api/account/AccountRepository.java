package com.example.springboot4hateoas.api.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Procedure
    void transfer(
            @Param("sender") Integer sender,
            @Param("receiver") Integer receiver,
            @Param("amount") Long amount);



}
