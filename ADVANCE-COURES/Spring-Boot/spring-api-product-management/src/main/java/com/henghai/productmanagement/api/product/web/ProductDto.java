package com.henghai.productmanagement.api.product.web;

import com.henghai.productmanagement.api.category.Categories;
import com.henghai.productmanagement.api.image.Images;
import com.henghai.productmanagement.api.productVariant.ProductVariant;
import lombok.Builder;

import java.util.List;

@Builder
public record ProductDto(
        Integer id,
        String name,
        Integer categoryId,
        List<ProductVariant> productVariants,
        List<Categories> categories,
         List<Images> image

) {
}
