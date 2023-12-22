package com.henghai.productmanagement.api.productVariant.web;

import com.henghai.productmanagement.api.productVariant.Size;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductVariantCreateDto {

    private Integer id;
    private String description;

    @NotNull
    private Integer price;
    @NotNull
    private Size size;
    @NotNull
    private String color;
    @NotNull
    private Integer stock;
    private Integer productId;
}
