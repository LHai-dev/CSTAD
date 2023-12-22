package com.henghai.productmanagement.api.productVariant;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.henghai.productmanagement.api.product.Product;
import lombok.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductVariant {

   private Integer id;
//   private String productName;
   private String description;
   private Integer price;
   private Size size;
   private String color;
   private Integer stock;
   private Integer productId;
   private Product product;
}

