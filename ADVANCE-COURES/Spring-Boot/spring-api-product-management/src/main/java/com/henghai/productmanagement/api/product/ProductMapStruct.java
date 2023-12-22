package com.henghai.productmanagement.api.product;

import com.github.pagehelper.PageInfo;
import com.henghai.productmanagement.api.product.web.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapStruct {
    Product toEntity(ProductDto productDto);
    ProductDto toDto(Product product);
    ProductIdDto toIdDto(Product product);
    Product updateProductDtotoProduct(UpdateProductById updateProductById);
    PageInfo<ProductDto> userPageInfoToUserDtoPageInfo(PageInfo<Product> userPageInfo);
    ProductDto toEntityCreateDto(ProductCreateDto productCreateDto);
    ProductCreateDto toDtoCreateDto(ProductDto productDto);
}
