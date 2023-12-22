package com.kafkastream;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafkaStreams;


@SpringBootApplication
@EnableKafkaStreams
public class KafkaStreamApplication {


	public static void main(String[] args) {
		SpringApplication.run(KafkaStreamApplication.class, args);

	}
}
