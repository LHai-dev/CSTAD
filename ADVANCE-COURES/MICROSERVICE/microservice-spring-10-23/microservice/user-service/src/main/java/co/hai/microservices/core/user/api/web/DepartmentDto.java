package co.hai.microservices.core.user.api.web;

public record DepartmentDto(
         Long id,
         String departmentName,
         String departmentAddress,
         String departmentCode
) {
}
