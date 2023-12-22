package com.testSSE.SSE.api.employee;

import com.testSSE.SSE.api.employee.web.EmployeeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeReactiveRepository employeeReactiveRepository;
    @Override
    public void create(Employee e) {
    employeeReactiveRepository.save(e).subscribe();
    }


    @Override
    public Mono<EmployeeDto> findById(Integer id) {
        //using map dto to entity
        return employeeReactiveRepository.findById(id).map(AppUtils::entityToDto);
    }

    @Override
    public Flux<Employee> findByName(String name) {
        return employeeReactiveRepository.findByName(name);
    }


    @Override
    public Mono<EmployeeDto> update(Integer id,Mono<EmployeeDto> e) {
        return findById(id).flatMap(b -> e.map(AppUtils::dtoToEntity))
                .doOnNext(b->b.setId(id))
                .flatMap(employeeReactiveRepository::save)
                .map(AppUtils::entityToDto);
    }

    @Override
    public Mono<Void> delete(Integer id) {
        return employeeReactiveRepository.deleteById(id);
    }

    @Override
    public Flux<Employee> findAll() {
        Flux<Employee> employees = employeeReactiveRepository.findAll();
        return employees;
    }


}
