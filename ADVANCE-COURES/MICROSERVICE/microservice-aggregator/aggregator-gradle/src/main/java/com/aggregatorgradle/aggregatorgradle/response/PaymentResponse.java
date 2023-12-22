package com.aggregatorgradle.aggregatorgradle.response;

import lombok.Builder;

import java.util.Date;

@Builder
public record PaymentResponse(
         Long id,
         Double amount,
         Date paymentDate,
         String paymentMethod
) {
}
