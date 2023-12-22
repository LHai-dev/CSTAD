package com.aggregatorgradle.aggregatorgradle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class AggregatorGradleApplication {

	public static void main(String[] args) {
		SpringApplication.run(AggregatorGradleApplication.class, args);
	}

}
