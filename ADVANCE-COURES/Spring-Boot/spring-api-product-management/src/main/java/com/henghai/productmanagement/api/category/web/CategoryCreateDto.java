package com.henghai.productmanagement.api.category.web;

import com.henghai.productmanagement.api.product.Product;
import lombok.Builder;

import java.util.List;

@Builder
public record CategoryCreateDto(
        Integer id,
        String name,
         List<Product> product
) {
}
