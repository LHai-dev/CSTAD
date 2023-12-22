package com.henghai.productmanagement.api.orderDetail;

import com.henghai.productmanagement.api.order.Order;
import com.henghai.productmanagement.api.product.Product;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDetail {
    private Integer id;
    private Timestamp date;
    private Integer qty;
    private List<Product> product;
    private List<Order> order;

}
