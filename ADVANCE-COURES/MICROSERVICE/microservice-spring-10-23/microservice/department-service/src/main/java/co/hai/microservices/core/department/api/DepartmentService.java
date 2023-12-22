package co.hai.microservices.core.department.api;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    Department getDepartmentById(Long departmentId);

    List<Department> getAll();
}
