package com.testSSE.SSE.api.employee;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface EmployeeReactiveRepository extends ReactiveMongoRepository<Employee,Integer> {
    @Query("{ 'name': ?0 }")
    Flux<Employee> findByName(final String name);


}
