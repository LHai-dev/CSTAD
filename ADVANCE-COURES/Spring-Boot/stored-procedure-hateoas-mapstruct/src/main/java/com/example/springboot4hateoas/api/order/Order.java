package com.example.springboot4hateoas.api.order;

import com.example.springboot4hateoas.api.orderDetail.OrderDetail;
import com.example.springboot4hateoas.api.product.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@ToString(callSuper = false)
@Entity
@Table(name="orders")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "data_received")
    private LocalDateTime dataReceived;
    @Column(name = "data_delivered")
    private LocalDateTime dataDelivered;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Product products;



    @OneToMany(mappedBy = "order")
   private List<OrderDetail> orderDetail;

}
