package com.aggregatorgradle.aggregatorgradle.response;

import lombok.Builder;

import java.util.Date;

@Builder
public record OrderResponse(
        Long id,
        Integer orderNumber,
        Date orderDate,
        double totalPrice
) {
}
