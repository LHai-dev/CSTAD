package com.henghai.productmanagement.api.order;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Integer id;

    private LocalDateTime orderDate;
    private Integer userId;
}
