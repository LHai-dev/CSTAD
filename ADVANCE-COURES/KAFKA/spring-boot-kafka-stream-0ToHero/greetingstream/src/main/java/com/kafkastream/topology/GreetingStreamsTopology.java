package com.kafkastream.topology;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafkastream.domain.Greeting;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Printed;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.serializer.JsonSerde;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class GreetingStreamsTopology {
    public   static String GREETING = "greetings";
    public   static String GREETING_OUTPUT = "greetings-output";

    private final ObjectMapper objectMapper;

    @Autowired
    public void process(StreamsBuilder streamsBuilder) {
        var greetingsStream = streamsBuilder.stream(GREETING, Consumed.with(Serdes.String(),
                new JsonSerde<>(Greeting.class,objectMapper)
                )
        );

//        greetingsStream.print(Printed.<String, String>toSysOut().withLabel("greetingsStream"));
        greetingsStream.print(Printed.<String, Greeting>toSysOut().withLabel("greetingsStream"));

        var modifiedStream = greetingsStream.mapValues((readOnlyKey, value) -> {
            return  new Greeting(value.getMessage().toUpperCase(),value.getTimeStamp());
        });

        modifiedStream.print(Printed.<String, Greeting>toSysOut().withLabel("modifiedStream"));

        modifiedStream
                .to(GREETING_OUTPUT
                        , Produced.with(Serdes.String(),
                                new JsonSerde<>(Greeting.class,objectMapper)
                                ));

    }

}
