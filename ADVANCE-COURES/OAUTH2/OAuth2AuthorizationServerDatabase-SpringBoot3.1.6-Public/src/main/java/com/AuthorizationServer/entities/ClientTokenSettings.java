package com.AuthorizationServer.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "token_settings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClientTokenSettings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "access_token_ttl" ,columnDefinition = "BigInt")
    private Long accessTokenTTL;

    private String type;

    @OneToOne
    private Client client;

    public static ClientTokenSettings from(String type,Long accessTokenTTL ,Client c){
        ClientTokenSettings clientTokenSettings = new ClientTokenSettings();
        clientTokenSettings.setClient(c);
        clientTokenSettings.setAccessTokenTTL(accessTokenTTL);
        clientTokenSettings.setType(type);
        return clientTokenSettings;
    }
}
