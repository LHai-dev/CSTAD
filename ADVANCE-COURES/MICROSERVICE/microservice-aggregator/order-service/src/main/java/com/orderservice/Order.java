package com.orderservice;

import jakarta.persistence.*;
import lombok.*;


import java.util.Date;
@Entity(name = "orders")
@Table
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer orderNumber;
    private Date orderDate;
    private double totalPrice;

    // Constructors, getters, setters, and other methods
}

