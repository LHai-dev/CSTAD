package com.example.springboot4hateoas.api.account;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "accounts")
@NamedStoredProcedureQuery(name = "TRANSFER",
        procedureName = "TRANSFER", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "sender", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "receiver", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.INOUT, name = "amount", type = Long.class),
        })
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private Double balance;

    // Getters and setters
}
