package com.henghai.productmanagement.api.product;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.henghai.productmanagement.api.product.web.ProductCreateDto;
import com.henghai.productmanagement.api.product.web.ProductDto;
import com.henghai.productmanagement.api.product.web.ProductIdDto;
import com.henghai.productmanagement.api.product.web.UpdateProductById;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class productServiceImpl implements ProductService {
    private final ProductMapper productMapper;
    private final ProductMapStruct productMapStruct;


    @Override
    public PageInfo<ProductDto> findAll(int page, int limit, String name) {
        PageInfo<Product> productPageInfo = PageHelper.startPage(page, limit).doSelectPageInfo(() -> productMapper.findAll(name));
        return productMapStruct.userPageInfoToUserDtoPageInfo(productPageInfo);
    }

    @Override
    public PageInfo<ProductDto> findAllByColorAndName(int page, int limit, String name, Integer categoryId) {
        PageInfo<Product> productPageInfo = PageHelper.startPage(page, limit).doSelectPageInfo(() -> productMapper.findAllByColor(name,categoryId));
        return productMapStruct.userPageInfoToUserDtoPageInfo(productPageInfo);
    }

    @Override
    public ProductDto insertProduct(ProductCreateDto productDto) {
        ProductDto product = productMapStruct.toEntityCreateDto(productDto);
        Product product1 = productMapStruct.toEntity(product);
        productMapper.insertProductForAdminDto(product1);
        return product;
    }

    @Override
    public ProductDto findProductById(Integer id) {
        log.info("this id {}", id);
        Product product = productMapper.getProductById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("User with ID = %d is not found in DB", id)));
        return productMapStruct.toDto(product);
    }

    @Override
    public Boolean deleteProductAndProductVariantById(Integer id) {
        int referenceCount = productMapper.countReferencesInProductVariant(id);
        int referenceCount1 = productMapper.countReferencesInOrderDetail(id);


        if (referenceCount > 0 || referenceCount1 > 0) {
            // Handle the case where references exist, such as updating the references or returning an error message.
            productMapper.deleteProductVariantsByProductId(id);
            productMapper.deleteProductIdOrderDetailById(id);
            productMapper.deleteProductById(id);
            return true;

        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("product with ID = %d is not found in DB", id));
        }
    }

    @Override
    public void deleteProductById(Integer id) {
        boolean haha = productMapper.existsProductById(id);
        log.info("this boolean {}", haha);
//        if (findProductById(id).equals(productMapper.existsProductById(id))){
//            deleteProductById(id);
//        }
    }

    @Override
    public ProductDto updateProductById(Integer id, UpdateProductById updateProductById) {

        if (productMapper.existsProductById(id)) {
            Product product = productMapStruct.updateProductDtotoProduct(updateProductById);
            product.setId(id);
            productMapper.updateProductById(product);
            return findProductById(id);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("User with %d is not found", id));
    }


}
