package com.AuthorizationServer.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.oauth2.core.AuthorizationGrantType;

@Entity
@Table(name = "grant_types")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GrantType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "grant_type")
    private String grantType;

    @ManyToOne
    private Client client;
    public static GrantType from(AuthorizationGrantType authorizationGrantType,Client c) {
        GrantType g = new GrantType();
        g.setGrantType(authorizationGrantType.getValue());
        g.setClient(c);
        return g;
    }
}

 