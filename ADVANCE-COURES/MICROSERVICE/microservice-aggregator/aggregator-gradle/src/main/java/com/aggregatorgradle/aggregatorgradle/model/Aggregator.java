package com.aggregatorgradle.aggregatorgradle.model;

import com.aggregatorgradle.aggregatorgradle.httpinterface.client.OrderClient;
import com.aggregatorgradle.aggregatorgradle.httpinterface.client.PaymentClient;
import com.aggregatorgradle.aggregatorgradle.httpinterface.client.UserClient;
import com.aggregatorgradle.aggregatorgradle.request.UserRequest;
import com.aggregatorgradle.aggregatorgradle.response.OrderResponse;
import com.aggregatorgradle.aggregatorgradle.response.PaymentResponse;
import com.aggregatorgradle.aggregatorgradle.response.UserResponse;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;
@Builder
public record Aggregator(
        Long id,
        Iterable<OrderResponse> orderClients,
        Iterable<UserResponse> userClients,
        Iterable<PaymentResponse> paymentClients,
        LocalDate localDate
) {
}
