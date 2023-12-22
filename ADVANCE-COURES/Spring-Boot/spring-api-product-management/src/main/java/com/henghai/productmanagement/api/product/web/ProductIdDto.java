package com.henghai.productmanagement.api.product.web;

import com.henghai.productmanagement.api.productVariant.ProductVariant;
import lombok.Builder;

import java.util.List;
@Builder
public record ProductIdDto (

        String name,

        Integer categoryId
){
}
