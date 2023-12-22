package com.webclient.demo.api.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.print.Book;

@RestController
@RequiredArgsConstructor
public class EmployeeRestController
{
    private final EmployeeService employeeService;
    @GetMapping("/")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Flux<Employee> getEmployeeAll(){
        return employeeService.getAllEmployee();
    }
}
