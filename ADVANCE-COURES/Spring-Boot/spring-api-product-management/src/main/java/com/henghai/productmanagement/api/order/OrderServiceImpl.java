package com.henghai.productmanagement.api.order;

import com.henghai.productmanagement.api.order.web.CreateOrderDto;
import com.henghai.productmanagement.api.product.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{
    private final OrderMapper orderMapper;

    @Override
    public List<Order> findAll() {
        List<Order> order = orderMapper.selectAll();

        return order;
    }

    @Override
    public CreateOrderDto insert(CreateOrderDto product) {
        //product.orderDate();
        product.setOrderDate(LocalDateTime.now());
        orderMapper.insertOrder(product);
        return product;
    }
}
