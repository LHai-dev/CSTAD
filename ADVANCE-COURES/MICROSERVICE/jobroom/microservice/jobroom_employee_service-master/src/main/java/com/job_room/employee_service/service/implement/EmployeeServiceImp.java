package com.job_room.employee_service.service.implement;

import com.job_room.employee_service.model.Employee;
import com.job_room.employee_service.model.dto.EmployeeDto;
import com.job_room.employee_service.repository.EmployeeRepository;
import com.job_room.employee_service.rest.message.*;
import com.job_room.employee_service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImp implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private MessageProperties messageProperties;

    @Autowired
    public void setMessageProperties(MessageProperties messageProperties) {
        this.messageProperties = messageProperties;
    }

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        employee.setStatus(true);
        Employee employee1=employeeRepository.save(employee);
        return employee;
    }

    @Override
    public Page<Employee> findAll(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Employee deleteEmployee(int id) {
        Optional<Employee> employee=employeeRepository.findById(id);
        if(employee.isEmpty()){
            return null;
        }else{
            employeeRepository.delete(employee.get());
            return employee.get();
        }

    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> employee=employeeRepository.findById(id);
        if(employee.isEmpty()){
            return null;
        }else{
            return employee.get();
        }

    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Page<Employee> findAllByFullName(String fullName,Pageable pageable) {

        return employeeRepository.findAllByFullNameContaining(fullName, pageable);
    }
}
