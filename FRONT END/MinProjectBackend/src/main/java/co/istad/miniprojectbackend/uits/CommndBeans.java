package com.istad.demo.uits;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommndBeans {
    @Bean
    public Faker faker(){
        return new Faker();
    }
}
