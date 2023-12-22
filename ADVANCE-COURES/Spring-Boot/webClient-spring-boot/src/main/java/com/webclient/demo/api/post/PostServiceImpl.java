package com.webclient.demo.api.post;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
@Service
public class PostServiceImpl implements PostService{
    private final WebClient client;
    public PostServiceImpl(WebClient.Builder builder){
        this.client = builder.baseUrl("http://localhost:9090").build();
    }
    @Autowired
    private ObjectMapper objectMapper; // Inject ObjectMapper as a Spring Bean
    @Override
    public Flux<ServerSentEvent<List<Post>>> streamDataSse() {

//        return this.client
//                .get()
//                .uri("/post/stream")
//                .accept(MediaType.TEXT_EVENT_STREAM)
//                .retrieve()
//                .bodyToFlux(ServerSentEvent.class)
//                .filter(event -> event.event().equals("post-list-event")) // Filter by event type if needed
//                .map(ServerSentEvent::data)
//                .map(postJson -> {
//                    try {
//
//                        List<Post> posts = objectMapper.readValue((JsonParser) postJson, new TypeReference<List<Post>>() {});
//                        return ServerSentEvent.builder(posts)
//                                .comment("it works 100%")
//                                .event("post-list-event")
//                                .build();
//                    } catch (IOException e) {
//                        // Handle the exception appropriately (e.g., log it)
//                        e.printStackTrace();
//                        return null; // You may want to handle deserialization errors better
//                    }
//                });

//    }}
        return null;
    }}