package com.userservice;


import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitialization {

    private final UserRepository userRepository;

    @PostConstruct
    void init() {
        User user = User.builder()
                .username(Faker.instance().funnyName().name())
                .email(Faker.instance().internet().emailAddress())
                .build();
        User user1 = User.builder()
                .username(Faker.instance().funnyName().name())
                .email(Faker.instance().internet().emailAddress())
                .build();
        User user2 = User.builder()
                .username(Faker.instance().funnyName().name())
                .email(Faker.instance().internet().emailAddress())
                .build();

        userRepository.saveAll(List.of(user1, user2, user));

    }

}