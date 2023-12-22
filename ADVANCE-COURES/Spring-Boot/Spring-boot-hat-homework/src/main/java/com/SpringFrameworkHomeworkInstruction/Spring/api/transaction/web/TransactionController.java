package com.SpringFrameworkHomeworkInstruction.Spring.api.transaction.web;

import com.SpringFrameworkHomeworkInstruction.Spring.api.transaction.TransactionRepository;
import com.SpringFrameworkHomeworkInstruction.Spring.api.transaction.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/Transaction")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;
    @PostMapping("/transfers")
    public ResponseEntity<?> transferFunds(
            @RequestParam( "sender") Integer sender,
            @RequestParam("receiver") Integer receiver,
            @RequestParam("amount") Long amount,
            @RequestParam("remark")  String remark
            ) {

        transactionService.transactionTransfers(sender, receiver, amount,remark);
        Map<String,String> msg = new HashMap<>();
        msg.put("have have been transfers money",amount+"$");
        msg.put("remark",remark);
        msg.put("Transfer ", "successful");
        msg.put("status",HttpStatus.OK.toString());

        return ResponseEntity.ok(msg);
    }
}
