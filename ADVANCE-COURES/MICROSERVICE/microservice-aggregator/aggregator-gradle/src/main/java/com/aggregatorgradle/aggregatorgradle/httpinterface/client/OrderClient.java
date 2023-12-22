package com.aggregatorgradle.aggregatorgradle.httpinterface.client;

import com.aggregatorgradle.aggregatorgradle.response.OrderResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange(url = "http://localhost:8082/orders")
public interface OrderClient {
    @GetExchange
    Iterable<OrderResponse> getAllOrders();
    @GetExchange("{id}")
    OrderResponse getOrderById(@PathVariable Long id);
}
