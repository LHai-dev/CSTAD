package com.example.springboot4hateoas.api.car;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "car")
@NamedStoredProcedureQuery(name = "Car.getTotalCardsbyModelEntity",
        procedureName = "GET_TOTAL_CARS_BY_MODEL", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "model_in", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "count_out", type = Integer.class)})
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column
    private String model;

    @Column
    private Integer year;
}
