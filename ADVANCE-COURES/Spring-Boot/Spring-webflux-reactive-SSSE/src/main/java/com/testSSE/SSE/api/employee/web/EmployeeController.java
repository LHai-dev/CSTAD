package com.testSSE.SSE.api.employee.web;

import com.testSSE.SSE.api.employee.Employee;
import com.testSSE.SSE.api.employee.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;



    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public void create(@RequestBody Employee e) {
        employeeService.create(e);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<EmployeeDto>> findById(@PathVariable("id") Integer id) {
        Mono<EmployeeDto> e = employeeService.findById(id);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<Flux<Employee>> findAll(){
        Flux<Employee> employeeFlux = employeeService.findAll();
        return new ResponseEntity<>(employeeFlux,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mono<EmployeeDto>> updateById(@PathVariable("id") Integer id,@RequestBody Mono<EmployeeDto> employee){
         Mono<EmployeeDto> employeeMono = employeeService.update(id,employee);
        return new ResponseEntity<>(employeeMono, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Mono<?>> deleteById(@PathVariable("id") Integer id){
    Mono<Void> mono =    employeeService.delete(id);
        return new ResponseEntity<>(mono,HttpStatus.OK);
    }
    @GetMapping("name/{name}")
    public ResponseEntity<Flux<Employee>> findByName(@PathVariable("name") String name){
        Flux<Employee> employeeFlux = employeeService.findByName(name);
        return new ResponseEntity<>(employeeFlux,HttpStatus.OK);
    }


}
