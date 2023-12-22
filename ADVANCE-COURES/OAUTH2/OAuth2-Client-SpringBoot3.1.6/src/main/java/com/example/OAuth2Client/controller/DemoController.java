package com.example.OAuth2Client.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.util.LinkedCaseInsensitiveMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;

@RestController
@AllArgsConstructor

public class DemoController {

    private final OAuth2AuthorizedClientManager oAuth2AuthorizedClientManager;  // proxy

    @GetMapping("/token")
    public Map<String,String> token() {
        OAuth2AuthorizeRequest request = OAuth2AuthorizeRequest
                .withClientRegistrationId("1")
                .principal("client")
                .build();

        OAuth2AuthorizedClient client = oAuth2AuthorizedClientManager.authorize(request); // request to the AS
        Map<String ,String > stringStringMap = new LinkedCaseInsensitiveMap<>();
        stringStringMap.put("Principal",client.getPrincipalName());
        stringStringMap.put("AccessToken",client.getAccessToken().getTokenValue());
        stringStringMap.put("GrantType",client.getClientRegistration().getAuthorizationGrantType().getValue());
        stringStringMap.put("Scopes",client.getClientRegistration().getScopes().toString());
        stringStringMap.put("AuthenticationMethod",client.getClientRegistration().getClientAuthenticationMethod().getValue());


//        stringStringMap.put("",client.getRefreshToken().getTokenValue());
        return stringStringMap;
    }

    @GetMapping("/limhai")
    public String inti(){
        return "thank you";
    }


}
