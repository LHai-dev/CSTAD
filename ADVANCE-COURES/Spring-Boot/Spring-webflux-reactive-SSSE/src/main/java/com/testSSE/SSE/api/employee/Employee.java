package com.testSSE.SSE.api.employee;

import lombok.Data;
import lombok.Generated;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Scope(scopeName = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Document(collection = "employees")
@Data
public class Employee {

    @Id
    private Integer id;
    private String name;
    private Long salary;
}
