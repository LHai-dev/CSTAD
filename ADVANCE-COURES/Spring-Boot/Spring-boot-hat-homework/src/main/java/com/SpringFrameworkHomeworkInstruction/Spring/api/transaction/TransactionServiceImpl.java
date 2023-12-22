package com.SpringFrameworkHomeworkInstruction.Spring.api.transaction;

import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Var;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService{
    private final TransactionRepository transactionRepository;

    @Override
    @Transactional
    public Long transactionTransfers(Integer sender, Integer receiver, Long amount,String remark){
     transactionRepository.transfer(sender,receiver,amount,remark);
    return amount;
    }
}
