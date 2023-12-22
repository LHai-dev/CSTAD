package com.henghai.productmanagement.api.product.web;

import lombok.Builder;

@Builder
public record ProductGetAllDto(
        String type
) {
}
