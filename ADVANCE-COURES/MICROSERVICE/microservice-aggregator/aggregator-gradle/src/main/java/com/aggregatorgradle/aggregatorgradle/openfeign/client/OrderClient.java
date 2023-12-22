package com.aggregatorgradle.aggregatorgradle.openfeign.client;

import com.aggregatorgradle.aggregatorgradle.response.OrderResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@FeignClient(name = "order-service",url = "http://localhost:8082/orders")
public interface OrderClient {
    @GetMapping
    Iterable<OrderResponse> getAllOrders();

    @GetMapping("/{id}")
    OrderResponse getOrderById(@PathVariable Long id);
}
