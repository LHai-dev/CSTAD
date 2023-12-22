package com.webclient.demo.api.employee;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeService {
    Flux<Employee> getAllEmployee();
    Mono<Employee> getEmployeeById(Integer id);
    Mono<Employee> createNewEmployee(Employee employee);
    Mono<Employee> updateEmployee(Integer id,Employee employee);
    Mono<Void> deleteEmployee(Integer id);
}
