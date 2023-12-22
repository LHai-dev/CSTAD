package co.hai.microservices.core.user.api.web;

import lombok.Data;

@Data
public class DepartmentFallbackDto {
   private Long id;
   private  String departmentName;
   private String departmentAddress;
   private String departmentCode;
}
