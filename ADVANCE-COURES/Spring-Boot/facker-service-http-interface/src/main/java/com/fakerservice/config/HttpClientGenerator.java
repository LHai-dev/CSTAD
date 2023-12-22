package com.fakerservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.lang.reflect.Proxy;

@Configuration
public class HttpClientGenerator {
    private static WebClient.Builder builder = WebClient.builder();
//    private static WebClient client = WebClient.builder().build();

    private static WebClient webClient = builder.build();

    private static HttpServiceProxyFactory factory = HttpServiceProxyFactory
            .builder(WebClientAdapter.forClient(webClient)).build();


    public static <S> S createService(Class<S> service){
        return factory.createClient(service);
    }
}
