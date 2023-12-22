package com.henghai.productmanagement.api.order.web;

import com.henghai.productmanagement.api.order.Order;
import com.henghai.productmanagement.api.order.OrderService;
import com.henghai.productmanagement.api.orderDetail.OrderDetail;
import com.henghai.productmanagement.api.product.web.ProductDto;
import com.henghai.productmanagement.base.BaseApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderController {
    private final OrderService orderService;
    @GetMapping
    public BaseApi<?> orderGetAll(){
        List<Order> order = orderService.findAll();
        return BaseApi.builder()
                .message("successfully")
                .data(order)
                .status(true)
                .timeStamp(LocalDateTime.now())
                .code(HttpStatus.OK.value())
                .build();
    }

    @PostMapping()
    public BaseApi<?> insertOrder(@RequestBody CreateOrderDto createOrderDto) {
      CreateOrderDto createOrderDto1=  orderService.insert(createOrderDto);
        return BaseApi.builder()
                .code(HttpStatus.OK.value())
                .data(createOrderDto1)
                .status(true)
                .message("successfully")
                .timeStamp(LocalDateTime.now())
                .build();
    }
}
