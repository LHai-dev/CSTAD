package com.AuthorizationServer.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;

@Entity
@Table(name = "authentication_methods")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AuthenticationMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "authentication_method")
    private String authenticationMethod;


    @ManyToOne
    private Client client;


    public static AuthenticationMethod from(ClientAuthenticationMethod authenticationMethod,Client client){
        AuthenticationMethod a = new AuthenticationMethod();
        a.setAuthenticationMethod(authenticationMethod.getValue());
        a.setClient(client);
        return a;
    }



}