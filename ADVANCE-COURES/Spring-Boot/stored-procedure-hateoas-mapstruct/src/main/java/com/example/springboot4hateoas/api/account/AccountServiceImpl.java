package com.example.springboot4hateoas.api.account;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;
    @Override
    @Transactional
    public Long AccountGetTransfer(Integer sender, Integer receiver, Long amount) {
        accountRepository.transfer(sender,receiver,amount);
        return amount;
    }
}
