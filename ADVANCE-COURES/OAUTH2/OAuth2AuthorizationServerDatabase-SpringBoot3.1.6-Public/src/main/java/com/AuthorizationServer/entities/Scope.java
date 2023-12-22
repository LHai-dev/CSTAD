package com.AuthorizationServer.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "scopes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Scope {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String scope;

    @ManyToOne
    private Client client;

    public static Scope from(String scope ,Client  client){
        Scope s = new Scope();
        s.setScope(scope);
        s.setClient(client);
        return s;
    }
}


 