package com.henghai.productmanagement.api.user.web;

import com.henghai.productmanagement.api.order.Order;
import lombok.Builder;

import java.sql.Timestamp;
import java.util.List;

@Builder
public record SaveUserDto(
        Integer id,
        String name,
        Timestamp dob,
        String gender,
        Integer phoneNumber,
        String password,
        String email,
        String address,
        Boolean isVerified,
        Boolean status,
        List<Order> order

) {
}
