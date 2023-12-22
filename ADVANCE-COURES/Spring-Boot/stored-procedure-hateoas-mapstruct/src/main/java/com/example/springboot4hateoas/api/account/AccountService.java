package com.example.springboot4hateoas.api.account;

import org.springframework.data.repository.query.Param;

public interface AccountService {
    Long AccountGetTransfer(  Integer sender,
                             Integer receiver,
                               Long amount);
}
