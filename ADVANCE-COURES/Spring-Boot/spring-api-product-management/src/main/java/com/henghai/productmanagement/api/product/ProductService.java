package com.henghai.productmanagement.api.product;

import com.github.pagehelper.PageInfo;
import com.henghai.productmanagement.api.product.web.ProductCreateDto;
import com.henghai.productmanagement.api.product.web.ProductDto;
import com.henghai.productmanagement.api.product.web.ProductIdDto;
import com.henghai.productmanagement.api.product.web.UpdateProductById;


public interface ProductService {
    PageInfo<ProductDto> findAll(int page,int limit,String name);
    PageInfo<ProductDto> findAllByColorAndName(int page,int limit,String name,Integer categoryId);

    ProductDto insertProduct(ProductCreateDto productDto);

    ProductDto findProductById(Integer id);
    Boolean deleteProductAndProductVariantById(Integer id);
    void deleteProductById(Integer id);

    ProductDto updateProductById(Integer id,UpdateProductById updateProductById);
}
