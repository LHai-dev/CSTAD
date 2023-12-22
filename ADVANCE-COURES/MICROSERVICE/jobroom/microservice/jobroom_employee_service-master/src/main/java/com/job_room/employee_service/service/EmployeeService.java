package com.job_room.employee_service.service;
import com.job_room.employee_service.model.Employee;
import com.job_room.employee_service.model.dto.EmployeeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface EmployeeService {

    Employee addEmployee(Employee employee);

    Page<Employee> findAll(int page, int pageSize);

    Employee deleteEmployee(int id);

    Employee findById(int id);

    Employee updateEmployee(Employee employee);

    Page<Employee> findAllByFullName(String fullName,Pageable pageable);

}
