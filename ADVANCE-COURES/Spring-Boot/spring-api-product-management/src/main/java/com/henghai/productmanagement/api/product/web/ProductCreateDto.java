package com.henghai.productmanagement.api.product.web;

import com.henghai.productmanagement.api.category.Categories;
import com.henghai.productmanagement.api.productVariant.ProductVariant;
import lombok.Builder;

import java.util.List;
@Builder
public record ProductCreateDto(
        Integer id,
        String name,
        Integer categoryId
) {
}
