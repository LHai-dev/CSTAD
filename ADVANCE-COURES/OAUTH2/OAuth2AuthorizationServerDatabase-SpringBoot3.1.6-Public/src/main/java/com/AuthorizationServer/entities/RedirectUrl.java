package com.AuthorizationServer.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "redirect_urls")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RedirectUrl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;

    @ManyToOne
    private Client client;


    public  static RedirectUrl from(String url, Client c){

        RedirectUrl redirectUrl = new RedirectUrl();
        redirectUrl.setClient(c);
        redirectUrl.setUrl(url);
        return redirectUrl;
    }

}


