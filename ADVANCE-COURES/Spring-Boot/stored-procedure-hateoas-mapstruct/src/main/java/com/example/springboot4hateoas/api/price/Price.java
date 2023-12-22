package com.example.springboot4hateoas.api.price;

import com.example.springboot4hateoas.api.orderDetail.OrderDetail;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "prices")
@Data
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
