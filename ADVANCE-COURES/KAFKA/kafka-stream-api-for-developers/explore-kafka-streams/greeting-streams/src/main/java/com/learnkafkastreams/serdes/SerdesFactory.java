package com.learnkafkastreams.serdes;

import com.learnkafkastreams.domain.Greeting;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;

public class SerdesFactory {
    static public Serde<Greeting> greetingSerde() {
        return new GreetingSerdes();
    }
    //TODO 002. Integrate Generic SerializerDeserializer into the Greeting App
    static public Serde<Greeting> greetingSerdeUsingGenerics() {
        JsonSerializer<Greeting> serializer = new JsonSerializer<>();
        JsonDeserializer<Greeting> deserializer = new JsonDeserializer<>(Greeting.class);
        return Serdes.serdeFrom(serializer, deserializer);
    }


}
