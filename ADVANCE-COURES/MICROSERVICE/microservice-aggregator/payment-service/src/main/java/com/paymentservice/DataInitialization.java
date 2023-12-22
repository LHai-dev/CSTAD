package com.paymentservice;


import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class DataInitialization {

    private final PaymentRepository paymentRepository;

    @PostConstruct
    void init() {
        Payment payment = Payment.builder().
                paymentDate(Faker.instance().date().between(Date.from(Instant.now()), Date.from(Instant.now())))
                .paymentMethod(Faker.instance().crypto().md5())
                .amount(Faker.instance().number().randomDouble(1000,10,10000))
                .build();
        Payment payment1 = Payment.builder().
                paymentDate(Faker.instance().date().between(Date.from(Instant.now()), Date.from(Instant.now())))
                .paymentMethod(Faker.instance().crypto().md5())
                .amount(Faker.instance().number().randomDouble(1000,10,10000))
                .build();
        Payment payment2 = Payment.builder().
                paymentDate(Faker.instance().date().between(Date.from(Instant.now()), Date.from(Instant.now())))
                .paymentMethod(Faker.instance().crypto().md5())
                .amount(Faker.instance().number().randomDouble(1000,10,10000))
                .build();


        paymentRepository.saveAll(List.of(payment1,payment2,payment));

    }

}