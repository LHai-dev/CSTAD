package com.AuthorizationServer.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.settings.OAuth2TokenFormat;
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

@Entity
@Table(name = "clients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "client_id")
    private String clientId;


    private String secret;


    @OneToMany(mappedBy = "client")
    private List<AuthenticationMethod> authenticationMethods;

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private List<Authority> authorities;
    @OneToOne(mappedBy = "client")
    private ClientTokenSettings clientTokenSettings;
    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private List<GrantType> grantTypes;
    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private List<RedirectUrl> redirectUrls;
    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private List<Scope> scopes;


    public static RegisteredClient fromClient(Client client) {

        return RegisteredClient.withId(String.valueOf(client.getId())).
                clientId(client.clientId).clientSecret(client.secret)
                .clientAuthenticationMethods(clientAuthenticationMethods(client.getAuthenticationMethods()))
                .authorizationGrantTypes(authorizationGrantType(client.getGrantTypes()))
                .scopes(scopes(client.getScopes()))
                .redirectUris(redirectUris(client.getRedirectUrls()))

                .tokenSettings(TokenSettings.builder()
                        .accessTokenTimeToLive(Duration.ofMinutes(client.clientTokenSettings.getAccessTokenTTL()))
                        .accessTokenFormat(new OAuth2TokenFormat(client.clientTokenSettings.getType()))
                        .build())
                .build();
    }
//    new ClientAuthenticationMethod(client.getAuthenticationMethods().get(0).getAuthenticationMethod())

    private static Consumer<Set<AuthorizationGrantType>> authorizationGrantType(List<GrantType> grantTypes) {
        return s -> {
            for (GrantType g : grantTypes) {
                s.add(new AuthorizationGrantType(g.getGrantType()));
            }
        };
    }

    public static Consumer<Set<ClientAuthenticationMethod>> clientAuthenticationMethods(List<AuthenticationMethod> authenticationMethods) {
        return m -> {
            for (AuthenticationMethod a : authenticationMethods) {
                m.add(new ClientAuthenticationMethod(a.getAuthenticationMethod()));
            }
        };
    }

    private static Consumer<Set<String>> scopes(List<Scope> scopes) {
        return s -> {
            for (Scope scope : scopes) {
                s.add(scope.getScope());
            }
        };
    }

    private static Consumer<Set<String>> redirectUris(List<RedirectUrl> redirectUrls) {
        return r -> {
            for (RedirectUrl redirectUrl : redirectUrls) {
                r.add(redirectUrl.getUrl());
            }
        };
    }

    private static String clientTokenSettings1(ClientTokenSettings clientTokenSettings1) {
        return clientTokenSettings1.getType();
    }
}
