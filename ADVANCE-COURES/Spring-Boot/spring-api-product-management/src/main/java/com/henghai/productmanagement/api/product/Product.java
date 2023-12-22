package com.henghai.productmanagement.api.product;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.henghai.productmanagement.api.category.Categories;

import com.henghai.productmanagement.api.image.Images;
import com.henghai.productmanagement.api.productVariant.ProductVariant;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product {
    private Integer id;
    private String name;
    private Integer categoryId;
    private List<ProductVariant> productVariants;
    private List<Categories> categories;
    private List<Images> image;



}
