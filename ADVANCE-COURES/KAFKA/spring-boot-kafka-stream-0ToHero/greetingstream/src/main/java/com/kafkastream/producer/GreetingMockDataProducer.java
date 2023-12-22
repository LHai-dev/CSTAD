package com.kafkastream.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.javafaker.Faker;
import com.kafkastream.domain.Greeting;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.List;

import static com.kafkastream.producer.ProducerUtil.publishMessageSync;

@Slf4j
public class GreetingMockDataProducer {

    static String GREETINGS = "greetings";

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        englishGreetings(objectMapper);
        spanishGreetings(objectMapper);

    }

    private static void spanishGreetings(ObjectMapper objectMapper) {
        var spanishGreetings = List.of(
                new Greeting(Faker.instance().music().toString(), LocalDateTime.now()),
                new Greeting(Faker.instance().book().author(), LocalDateTime.now()),
                new Greeting(Faker.instance().music().instrument(), LocalDateTime.now()),
                new Greeting(Faker.instance().programmingLanguage().name(), LocalDateTime.now()),
                new Greeting(Faker.instance().esports().game(), LocalDateTime.now()),
                new Greeting(Faker.instance().currency().name(), LocalDateTime.now()),
                new Greeting(Faker.instance().internet().avatar(), LocalDateTime.now())



        );
        spanishGreetings
                .forEach(greeting -> {
                    try {
                        var greetingJSON = objectMapper.writeValueAsString(greeting);
                        var recordMetaData = publishMessageSync(GREETINGS, null, greetingJSON);
                        log.info("Published the alphabet message : {} ", recordMetaData);
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    private static void englishGreetings(ObjectMapper objectMapper) {
        var spanishGreetings = List.of(
                new Greeting("¡Hola buenos dias!", LocalDateTime.now()),
                new Greeting("¡Hola buenas tardes!", LocalDateTime.now()),
                new Greeting("¡Hola, buenas noches!", LocalDateTime.now())
        );
        spanishGreetings
                .forEach(greeting -> {
                    try {
                        var greetingJSON = objectMapper.writeValueAsString(greeting);
                        var recordMetaData = publishMessageSync(GREETINGS, null, greetingJSON);
                        log.info("Published the alphabet message : {} ", recordMetaData);
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                });
    }

}

