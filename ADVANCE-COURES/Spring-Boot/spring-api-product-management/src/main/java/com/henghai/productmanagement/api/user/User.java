package com.henghai.productmanagement.api.user;

import com.henghai.productmanagement.api.order.Order;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private Timestamp dob;
    private String gender;
    private Integer phoneNumber;
    private String password;
    private String email;
    private String address;
    private Boolean isVerified;
    private Boolean status;
    private List<Order> order;
}
