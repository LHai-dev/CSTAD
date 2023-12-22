package com.henghai.productmanagement.api.category.web;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.henghai.productmanagement.api.category.Categories;
import com.henghai.productmanagement.api.category.CategoryService;
import com.henghai.productmanagement.base.BaseApi;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryController {
    private final CategoryService categoryService;
    @GetMapping()
    public BaseApi<?> getAll(){
       List<Categories> categories = categoryService.findAll();
        return BaseApi.builder()
                .code(HttpStatus.OK.value())
                .data(categories)
                .timeStamp(LocalDateTime.now())
                .status(true)
                .message("successfully")
                .build();

    }
}
