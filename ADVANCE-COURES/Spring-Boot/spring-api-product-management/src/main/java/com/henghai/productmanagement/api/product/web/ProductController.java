package com.henghai.productmanagement.api.product.web;

import com.github.pagehelper.PageInfo;
import com.henghai.productmanagement.api.product.Product;
import com.henghai.productmanagement.api.product.ProductService;
import com.henghai.productmanagement.base.BaseApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping()
    public BaseApi<?> FindAll(@RequestParam(name = "page", required = false, defaultValue = "1") int page,
                              @RequestParam(name = "limit", required = false, defaultValue = "15") int limit,
                              @RequestParam(name = "name", required = false, defaultValue = "") String name) {
        PageInfo<ProductDto> products = productService.findAll(page, limit, name);
        return BaseApi.builder()
                .code(HttpStatus.OK.value())
                .data(products)
                .status(true)
                .message("successfully")
                .timeStamp(LocalDateTime.now())
                .build();
    }

    @GetMapping("/color-and-name")
    public BaseApi<?> FindAllByColorAndName(@RequestParam(name = "page", required = false, defaultValue = "1") int page,
                                            @RequestParam(name = "limit", required = false, defaultValue = "15") int limit,
                                            @RequestParam(name = "name", required = false, defaultValue = "") String name,
                                            @RequestParam(name = "cId", required = false, defaultValue = "") Integer categoryId) {
        PageInfo<ProductDto> products = productService.findAllByColorAndName(page, limit, name, categoryId);
        return BaseApi.builder()
                .code(HttpStatus.OK.value())
                .data(products)
                .status(true)
                .message("successfully")
                .timeStamp(LocalDateTime.now())
                .build();
    }

    @PostMapping()
    public BaseApi<?> insertProduct(@RequestBody ProductCreateDto productDto) {
        ProductDto productDto1 = productService.insertProduct(productDto);
        return BaseApi.builder()
                .code(HttpStatus.OK.value())
                .data(productDto1)
                .status(true)
                .message("successfully")
                .timeStamp(LocalDateTime.now())
                .build();
    }

    @GetMapping("/{id}")
    public BaseApi<?> findProductById(@PathVariable("id") Integer id) {
        ProductDto productDto1 = productService.findProductById(id);
        return BaseApi.builder()
                .code(HttpStatus.OK.value())
                .data(productDto1)
                .status(true)
                .message("successfully")
                .timeStamp(LocalDateTime.now())
                .build();
    }

    @DeleteMapping("/pv/{id}")
    public BaseApi<?> deleteProductAndProductVariantById(@PathVariable("id") Integer id) {
        productService.deleteProductAndProductVariantById(id);
        return BaseApi.builder()
                .code(HttpStatus.OK.value())
                .data(id)
                .status(true)
                .message("successfully")
                .timeStamp(LocalDateTime.now())
                .build();
    }

    @DeleteMapping("/{id}")
    public BaseApi<?> deleteOnlyProductProductById(@PathVariable("id") Integer id) {
        return BaseApi.builder()
                .code(HttpStatus.OK.value())
                .data(id)
                .status(true)
                .message("successfully")
                .timeStamp(LocalDateTime.now())
                .build();
    }

    @PutMapping("/{id}")
    public BaseApi<?> updateUserById(@PathVariable("id") Integer id, @RequestBody UpdateProductById productIdDto) {
        ProductDto ProductIdDto = productService.updateProductById(id, productIdDto);
        return BaseApi.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("product has been updated successfully.")
                .timeStamp(LocalDateTime.now())
                .data(ProductIdDto)
                .build();
    }
}
