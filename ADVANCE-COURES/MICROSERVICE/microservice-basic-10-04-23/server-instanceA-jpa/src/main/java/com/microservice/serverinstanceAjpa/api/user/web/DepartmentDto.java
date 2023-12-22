package com.microservice.serverinstanceAjpa.api.user.web;

public record DepartmentDto(
         Long id,
         String departmentName,
         String departmentAddress,
         String departmentCode
) {
}
