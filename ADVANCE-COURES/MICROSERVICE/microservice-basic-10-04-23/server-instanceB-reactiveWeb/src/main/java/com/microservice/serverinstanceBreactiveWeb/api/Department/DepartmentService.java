package com.microservice.serverinstanceBreactiveWeb.api.Department;

public interface DepartmentService {
    Department saveDepartment(Department department);

    Department getDepartmentById(Long departmentId);
}
