package com.example.springboot4hateoas.api.product;

import com.example.springboot4hateoas.api.order.Order;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "product")
@Relation(collectionRelation = "products")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto extends RepresentationModel<ProductDto> {
    private Long id;

    private String name;
    private Long price;
    private String color;
    private String size;

  private   List<Order> orders ;
}
