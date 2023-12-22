package com.henghai.productmanagement.api.productVariant;

import com.github.pagehelper.PageInfo;
import com.henghai.productmanagement.api.product.Product;
import com.henghai.productmanagement.api.product.web.ProductDto;
import com.henghai.productmanagement.api.productVariant.web.ProductVariantCreateDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductVariantMapStruct {
    ProductVariant dtoToProduct(ProductVariantCreateDto productVariantCreateDto);
    ProductVariantCreateDto productToDto(ProductVariant productVariant);

    PageInfo<ProductVariantCreateDto> userPageInfoToProductVarDtoPageInfo(PageInfo<ProductVariant> userPageInfo);


}
