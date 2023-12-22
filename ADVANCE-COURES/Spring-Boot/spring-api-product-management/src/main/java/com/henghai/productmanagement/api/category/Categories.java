package com.henghai.productmanagement.api.category;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.henghai.productmanagement.api.product.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Categories {
    private Integer id;
    private String name;
    private List<Product> product;

}
