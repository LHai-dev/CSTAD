package com.AuthorizationServer.service;

import com.AuthorizationServer.entities.*;
import com.AuthorizationServer.repositoies.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ClientService implements RegisteredClientRepository {
    private final ClientRepository clientRepository;

    @Override
    @Transactional
    public void save(RegisteredClient registeredClient) {
        Client client = new Client();
        client.setClientId(registeredClient.getClientId());
        client.setSecret(registeredClient.getClientSecret());
        //setter form table authenticationMethod
        client.setAuthenticationMethods(
                registeredClient.getClientAuthenticationMethods().stream().map(
                        c -> AuthenticationMethod.from(c, client)
                ).collect(Collectors.toList())
        );
        client.setGrantTypes(registeredClient.getAuthorizationGrantTypes().stream().map(
                        g -> GrantType.from(g, client)
                ).collect(Collectors.toList())
        );

        client.setRedirectUrls(registeredClient.getRedirectUris().stream().map(
                        r -> RedirectUrl.from(r, client)
                ).collect(Collectors.toList())
        );

        client.setScopes(registeredClient.getScopes().stream().map(
                s -> Scope.from(s, client)).collect(Collectors.toList())
        );

        client.setClientTokenSettings(ClientTokenSettings.from(client.getClientTokenSettings().getType(),client.getClientTokenSettings().getAccessTokenTTL(),client));



//        client.setClientTokenSettings(registeredClient.getTokenSettings().);

        clientRepository.save(client);

    }

    @Override
    public RegisteredClient findById(String id) {
       var client =  clientRepository.findById(Long.parseLong(id));

        return client.map(Client::fromClient
        ).orElseThrow(()  -> new RuntimeException(":(")  );
    }

    @Override
    public RegisteredClient findByClientId(String clientId) {
        var client =  clientRepository.findByClientId(clientId);

        return client.map(Client::fromClient
        ).orElseThrow(()  -> new RuntimeException(":(")  );
    }
}
