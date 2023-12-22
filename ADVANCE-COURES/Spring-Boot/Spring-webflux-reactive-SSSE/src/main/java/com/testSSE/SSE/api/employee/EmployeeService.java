package com.testSSE.SSE.api.employee;

import com.testSSE.SSE.api.employee.web.EmployeeDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeService {
    void create(Employee e);

    Mono<EmployeeDto> findById(Integer id);

    Flux<Employee> findByName(String name);

//    Flux<Employee> findAll();

    Mono<EmployeeDto> update(Integer id,Mono<EmployeeDto> e);

    Mono<Void> delete(Integer id);
    Flux<Employee> findAll();


}
