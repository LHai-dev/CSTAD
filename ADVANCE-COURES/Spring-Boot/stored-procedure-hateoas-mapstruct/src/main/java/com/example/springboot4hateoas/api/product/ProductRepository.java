package com.example.springboot4hateoas.api.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query("select ps.color ,ps.name  from Product AS ps")
   Optional<Product> findAllProduct();
}
