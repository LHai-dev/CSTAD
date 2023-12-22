package com.henghai.productmanagement.api.orderDetail;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
@Service
@RequiredArgsConstructor
public class OrderDetailServiceImpl implements OrderDetailService{
    private final OrderDetailMapper orderDetailMapper;
    @Override
    public List<OrderDetail> getAll() {
        List<OrderDetail> orderDetail = orderDetailMapper.selectAll();
        return orderDetail;
    }
}
