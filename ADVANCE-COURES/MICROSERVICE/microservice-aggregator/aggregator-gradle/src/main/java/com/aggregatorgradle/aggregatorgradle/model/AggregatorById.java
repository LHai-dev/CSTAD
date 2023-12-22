package com.aggregatorgradle.aggregatorgradle.model;

import com.aggregatorgradle.aggregatorgradle.response.OrderResponse;
import com.aggregatorgradle.aggregatorgradle.response.PaymentResponse;
import com.aggregatorgradle.aggregatorgradle.response.UserResponse;
import lombok.Builder;

import java.time.LocalDate;
@Builder
public record AggregatorById(
        Long id,
        OrderResponse orderClients,
        UserResponse userClients,
        PaymentResponse paymentClients,
        LocalDate localDate
) {
}
