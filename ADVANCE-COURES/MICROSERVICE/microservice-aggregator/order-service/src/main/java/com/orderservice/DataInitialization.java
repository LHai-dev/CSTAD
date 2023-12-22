package com.orderservice;


import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import jdk.dynalink.linker.LinkerServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitialization {


    private final OrderRepository orderRepository;


    @PostConstruct
    void init() {
    Order order = Order.builder()
            .orderNumber(Faker.instance().random().nextInt(1,100000))
            .orderDate(Faker.instance().date().between(Date.from(Instant.now()), Date.from(Instant.now())))
            .totalPrice(Faker.instance().number().randomDigit())
            .build();
        Order order1 = Order.builder()
                .orderNumber(Faker.instance().random().nextInt(1,100000))
                .orderDate(Faker.instance().date().between(Date.from(Instant.now()), Date.from(Instant.now())))
                .totalPrice(Faker.instance().number().randomDigit())
                .build();
        Order order2 = Order.builder()
                .orderNumber(Faker.instance().random().nextInt(1,100000))
                .orderDate(Faker.instance().date().between(Date.from(Instant.now()), Date.from(Instant.now())))
                .totalPrice(Faker.instance().number().randomDigit())
                .build();
        orderRepository.saveAll(List.of(order1,order2,order));
    }

}