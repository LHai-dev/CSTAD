package com.aggregatorgradle.aggregatorgradle.openfeign.client;

import com.aggregatorgradle.aggregatorgradle.response.PaymentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@FeignClient(name = "payment-service",url = "http://localhost:8081/payments")
public interface PaymentClient {
    @GetMapping()
     Iterable<PaymentResponse> getAllPayments();
    @GetMapping("/{id}")
     PaymentResponse getPaymentById(@PathVariable Long id);
}
