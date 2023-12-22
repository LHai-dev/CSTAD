package com.henghai.productmanagement.api.productVariant.web;

import com.github.pagehelper.PageInfo;
import com.henghai.productmanagement.api.product.web.ProductDto;
import com.henghai.productmanagement.api.productVariant.ProductVariant;
import com.henghai.productmanagement.api.productVariant.ProductVariantService;
import com.henghai.productmanagement.base.BaseApi;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/ProductsVariants")
@Slf4j
public class ProductVariantController {
    private final ProductVariantService productVariantService;

    @GetMapping()
    public BaseApi<?> FindAll(@RequestParam(name = "page", required = false, defaultValue = "1") int page,
                              @RequestParam(name = "limit", required = false, defaultValue = "20") int limit,
                              @RequestParam(name = "color",required = false,defaultValue = "") String color) {
        PageInfo<ProductVariantCreateDto> products = productVariantService.findAll(page,limit,color);
        return BaseApi.builder()
                .code(HttpStatus.OK.value())
                .data(products)
                .status(true)
                .message("successfully")
                .timeStamp(LocalDateTime.now())
                .build();
    }

    @PostMapping()
    public BaseApi<?> createProduct(@RequestBody @Valid ProductVariantCreateDto productVariantCreateDto) {
            log.info(productVariantCreateDto.toString());
        ProductVariantCreateDto productVariantCreateDto1 = productVariantService.CreateProduct(productVariantCreateDto);
        return BaseApi.builder()
                .code(HttpStatus.OK.value())
                .data(productVariantCreateDto1)
                .status(true)
                .message("successfully")
                .timeStamp(LocalDateTime.now())
                .build();
    }

    @GetMapping("{id}")
    public BaseApi<?> getProductById(@PathVariable("id") Integer id) {

        return BaseApi.builder()
                .code(HttpStatus.OK.value())
                .data(productVariantService.getId(id))
                .status(true)
                .message("successfully")
                .timeStamp(LocalDateTime.now())
                .build();
    }

    @PutMapping("/{id}")
    public BaseApi<?> updateProductById(@PathVariable("id") Integer id ,@RequestBody ProductVariantCreateDto product){
        ProductVariant productVariant1 = productVariantService.UpdateById(id,product);
        return BaseApi.builder()
                .code(HttpStatus.OK.value())
                .data(productVariant1)
                .status(true)
                .message("successfully")
                .timeStamp(LocalDateTime.now())
                .build();
    }
    @DeleteMapping("/{id}")
    public BaseApi<?> deleteProductById(@PathVariable("id") Integer id){
        log.info(id.toString());
        productVariantService.deleteProductById(id);
        return BaseApi.builder()
                .code(HttpStatus.OK.value())
                .data("delete ID :"+id)
                .status(true)
                .message("successfully")
                .timeStamp(LocalDateTime.now())
                .build();
    }
}
