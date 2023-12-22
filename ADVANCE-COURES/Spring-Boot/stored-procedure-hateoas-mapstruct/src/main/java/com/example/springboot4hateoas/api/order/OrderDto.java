package com.example.springboot4hateoas.api.order;

import com.example.springboot4hateoas.api.product.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.time.LocalDateTime;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "order")
@Relation(collectionRelation = "Order_Dto")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDto extends RepresentationModel<OrderDto> {

    private Long id;

    private LocalDateTime dataReceived;

    private LocalDateTime dataDelivered;

    private Product products;
}
