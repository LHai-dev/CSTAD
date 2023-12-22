package com.henghai.productmanagement.api.order.web;

import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
public class CreateOrderDto{
        Integer id;
        LocalDateTime orderDate;
        Integer userId;

}
