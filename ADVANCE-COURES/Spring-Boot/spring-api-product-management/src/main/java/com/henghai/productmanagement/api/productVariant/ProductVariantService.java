package com.henghai.productmanagement.api.productVariant;

import com.github.pagehelper.PageInfo;
import com.henghai.productmanagement.api.productVariant.web.ProductVariantCreateDto;

import java.util.List;

public interface ProductVariantService {
    PageInfo<ProductVariantCreateDto> findAll(int page,int limit,String color);

    ProductVariantCreateDto CreateProduct(ProductVariantCreateDto productVariantCreateDto);

    ProductVariant getId(Integer id);

    ProductVariant UpdateById(Integer id, ProductVariantCreateDto productVariantCreateDto);

    void deleteProductById(Integer id);
}
