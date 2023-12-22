package com.henghai.productmanagement.api.orderDetail.web;

import com.henghai.productmanagement.api.orderDetail.OrderDetail;
import com.henghai.productmanagement.api.orderDetail.OrderDetailService;
import com.henghai.productmanagement.base.BaseApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/OrderDetail")
public class OrderDetailController {
    private final OrderDetailService orderDetailService;
    @GetMapping
    public BaseApi<?> orderDetailGetAll(){
        List<OrderDetail> orderDetail = orderDetailService.getAll();
        return BaseApi.builder()
                .message("successfully")
                .data(orderDetail)
                .status(true)
                .timeStamp(LocalDateTime.now())
                .code(HttpStatus.OK.value())
                .build();
    }
}
