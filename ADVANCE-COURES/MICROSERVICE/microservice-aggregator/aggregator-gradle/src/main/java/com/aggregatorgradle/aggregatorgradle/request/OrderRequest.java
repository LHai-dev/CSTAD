package com.aggregatorgradle.aggregatorgradle.request;

import lombok.Builder;

import java.util.Date;

@Builder
public record OrderRequest(
         Long id,
         Integer orderNumber,
         Date orderDate,
         double totalPrice
) {
}
