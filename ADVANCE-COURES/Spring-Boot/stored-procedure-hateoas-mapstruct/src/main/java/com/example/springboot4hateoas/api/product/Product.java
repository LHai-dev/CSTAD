package com.example.springboot4hateoas.api.product;

import com.example.springboot4hateoas.api.category.Category;
import com.example.springboot4hateoas.api.order.Order;
import com.example.springboot4hateoas.api.orderDetail.OrderDetail;
import com.example.springboot4hateoas.api.price.Price;
import jakarta.persistence.*;
import lombok.*;
import lombok.ToString;
import org.springframework.hateoas.RepresentationModel;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "products")
public class Product {
    @OneToMany(mappedBy = "products")
    List<Order> orders;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long price;
    private String color;
    private String size;
    @ManyToOne
    @JoinColumn(name = "cat_id")
    private Category category;


    @ManyToMany
    @JoinTable(name = "product_price")
    private List<Price> prices;

    @OneToMany(mappedBy = "product")
    List<OrderDetail> orderDetails;

}
