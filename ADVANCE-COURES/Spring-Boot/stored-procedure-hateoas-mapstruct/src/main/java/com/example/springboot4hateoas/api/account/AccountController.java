package com.example.springboot4hateoas.api.account;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AccountController {
private final AccountService accountService;


    @PostMapping("/transfers")
    public ResponseEntity<?> transferFunds(
            @RequestParam(name = "senderId") Integer senderId,
            @RequestParam(name = "receiverId") Integer receiverId,
            @RequestParam("amount") Long amount) {

        accountService.AccountGetTransfer(senderId, receiverId, amount);

        return ResponseEntity.ok("have have been transfers money : "+amount+"$\nTransfer successful.");
    }

}
