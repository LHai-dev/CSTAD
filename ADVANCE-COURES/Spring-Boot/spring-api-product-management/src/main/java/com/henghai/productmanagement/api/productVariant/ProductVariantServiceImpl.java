package com.henghai.productmanagement.api.productVariant;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.henghai.productmanagement.api.product.Product;
import com.henghai.productmanagement.api.productVariant.web.ProductVariantCreateDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductVariantServiceImpl implements ProductVariantService {
    private final ProductVariantMapper productVariantMapper;
    private final ProductVariantMapStruct productVariantMapStruct;


    @Override
    public PageInfo<ProductVariantCreateDto> findAll(int page, int limit,String color) {
        PageInfo<ProductVariant> productVarPageInfo= PageHelper.startPage(page,limit).doSelectPageInfo(()->productVariantMapper.selectProductVariant(color));
        return productVariantMapStruct.userPageInfoToProductVarDtoPageInfo(productVarPageInfo);
    }

    @Override
    public ProductVariantCreateDto CreateProduct(ProductVariantCreateDto productVariantCreateDto) {

        ProductVariant productVariant = productVariantMapStruct.dtoToProduct(productVariantCreateDto);
       productVariantMapper.createProductVariant(productVariant);
       log.info(productVariant.toString());
        return productVariantCreateDto;
    }

    @Override
    public ProductVariant getId(Integer id) {
       ProductVariant productVariant = productVariantMapper.selectById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Your id Not Found",id)));
        log.info(productVariant.getId().toString());
        return productVariant;
    }

    @Override
    public ProductVariant UpdateById(Integer id, ProductVariantCreateDto productVariantCreateDto) {
        log.info(productVariantCreateDto.toString());
        if (productVariantMapper.existsById(id)){
            ProductVariant productVariant = productVariantMapStruct.dtoToProduct(productVariantCreateDto);
            productVariant.setId(id);
            productVariantMapper.update(productVariant);
            return getId(id);
        }
        // Throw your business exception
        throw new ResponseStatusException(HttpStatus.NOT_FOUND , String.format("ProductVariant with Id = %d is not found in DB",id));
    }

    @Override
    public void deleteProductById(Integer id) {
        log.info("in service {}",id.toString());
        if (productVariantMapper.existsById(id)){
            getId(id);
            productVariantMapper.deleteById(id);

        }else {
            // Throw your business exception
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("User with ID = %d is not found in DB", id));
        }

    }
}
