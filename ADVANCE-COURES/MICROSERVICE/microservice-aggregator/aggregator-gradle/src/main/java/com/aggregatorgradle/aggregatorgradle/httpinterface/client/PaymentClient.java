package com.aggregatorgradle.aggregatorgradle.httpinterface.client;

import com.aggregatorgradle.aggregatorgradle.response.PaymentResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange(url = "http://localhost:8081/payments")
public interface PaymentClient {
    @GetExchange()
     Iterable<PaymentResponse> getAllPayments();
    @GetExchange("/{id}")
     PaymentResponse getPaymentById(@PathVariable Long id);
}
