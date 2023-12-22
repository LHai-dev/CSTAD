package com.example.springboot4hateoas.api.category;

import com.example.springboot4hateoas.api.product.Product;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "categories")
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    @OneToMany(mappedBy = "category")
    private List <Product> product;
}
