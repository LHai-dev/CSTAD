package com.aggregatorgradle.aggregatorgradle.request;

import lombok.Builder;

import java.util.Date;

@Builder
public record PaymentRequest(
         Long id,
         Double amount,
         Date paymentDate,
         String paymentMethod
) {
}
