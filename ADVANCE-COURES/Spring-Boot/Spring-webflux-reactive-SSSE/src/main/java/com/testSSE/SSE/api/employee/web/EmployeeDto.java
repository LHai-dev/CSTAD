package com.testSSE.SSE.api.employee.web;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeDto {
   private String name;
   private Long salary;
}
