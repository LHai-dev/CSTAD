package com.httpInterface.HttpInterface.config;

import com.httpInterface.HttpInterface.api.UserClientService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.time.Duration;

@Configuration
public class ClientConfig {
    @Bean
    UserClientService userClientService() {
        WebClient client = WebClient.builder()
                .defaultStatusHandler(HttpStatusCode::isError, ClientResponse::createException)
                .baseUrl("http://localhost:9090")
                .build();
        WebClientAdapter clientAdapter = WebClientAdapter.forClient(client);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory
//                .builder(WebClientAdapter.forClient(client))
                .builder(clientAdapter)
                .blockTimeout(Duration.ofMillis(10))
                .build();
        return factory.createClient(UserClientService.class);
    }
//    @Bean("basicClient")
//    public WebClient webClient() {
//        return WebClient.builder()
//                .baseUrl(userClientService().)
//
//                .defaultHeader("Authorization", "Bearer your_token")
//                .build();
//    }
}
