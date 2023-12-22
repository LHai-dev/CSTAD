package com.henghai.productmanagement.api.order;

import com.henghai.productmanagement.api.order.web.CreateOrderDto;
import com.henghai.productmanagement.api.product.Product;

import java.util.List;

public interface OrderService {
    List<Order> findAll();
    CreateOrderDto insert(CreateOrderDto createOrderDto);

}
