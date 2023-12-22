package com.SpringFrameworkHomeworkInstruction.Spring.api.transaction;

import org.aspectj.weaver.ast.Var;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    @Procedure
    void transfer(
            @Param("sender") Integer sender,
            @Param("receiver") Integer receiver,
            @Param("amount") Long amount,
            @Param("remark") String remark
    );
}
