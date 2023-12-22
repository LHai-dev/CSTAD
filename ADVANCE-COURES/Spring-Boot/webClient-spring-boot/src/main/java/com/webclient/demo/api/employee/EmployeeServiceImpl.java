package com.webclient.demo.api.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final WebClient client;
    public EmployeeServiceImpl(WebClient.Builder builder){
        this.client = builder.baseUrl("http://localhost:9090").build();
    }
    @Override
    public Flux<Employee> getAllEmployee() {
        return this.client
                .get()
                .uri("/")
                .retrieve()
                .bodyToFlux(Employee.class);
    }

    @Override
    public Mono<Employee> getEmployeeById(Integer id) {
        return null;
    }

    @Override
    public Mono<Employee> createNewEmployee(Employee employee) {
        return null;
    }

    @Override
    public Mono<Employee> updateEmployee(Integer id, Employee employee) {
        return null;
    }

    @Override
    public Mono<Void> deleteEmployee(Integer id) {
        return null;
    }
}
