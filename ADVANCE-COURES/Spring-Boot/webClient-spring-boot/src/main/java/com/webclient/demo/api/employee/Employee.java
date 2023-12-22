package com.webclient.demo.api.employee;

import lombok.*;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee {
    private String name;
    private Long salary;
}


