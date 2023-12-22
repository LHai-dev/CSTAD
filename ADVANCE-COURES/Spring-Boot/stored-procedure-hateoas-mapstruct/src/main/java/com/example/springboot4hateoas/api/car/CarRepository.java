package com.example.springboot4hateoas.api.car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {
//    @Procedure
//    Integer GET_TOTAL_CARS_BY_MODEL(String model);
    @Procedure("GET_TOTAL_CARS_BY_MODEL")
    Integer getTotalCarsByModel(String model);
//    @Procedure(procedureName = "GET_TOTAL_CARS_BY_MODEL")
//    int getTotalCarsByModelProcedureName(String model);

//    @Procedure(name = "Car.getTotalCardsbyModelEntity")
//    int getTotalCarsByModelEntiy(@Param("model_in") String model);
    @Modifying
    @Transactional
    @Query(value = "CALL FIND_CARS_AFTER_YEAR(:year_in);", nativeQuery = true)
    void findCarsAfterYear (@Param("year_in") Integer year_in);



}
