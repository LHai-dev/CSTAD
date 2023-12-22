package com.learnkafkastreams.serdes;

import com.learnkafkastreams.domain.Order;
import com.learnkafkastreams.domain.Revenue;
import com.learnkafkastreams.domain.Store;
import com.learnkafkastreams.domain.TotalRevenue;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;

public class SerdesFactory {

    //TODO 002. Integrate Generic SerializerDeserializer into the Greeting App
    static public Serde<Order> orderSerde() {
        JsonSerializer<Order> serializer = new JsonSerializer<>();
        JsonDeserializer<Order> deserializer = new JsonDeserializer<>(Order.class);
        return Serdes.serdeFrom(serializer, deserializer);
    }


    static public Serde<Revenue> revenueSerde() {
        JsonSerializer<Revenue> serializer = new JsonSerializer<>();
        JsonDeserializer<Revenue> deserializer = new JsonDeserializer<>(Revenue.class);
        return Serdes.serdeFrom(serializer, deserializer);
    }
    public static Serde<TotalRevenue> totalRevenueSerdes() {

        JsonSerializer<TotalRevenue> jsonSerializer = new JsonSerializer<>();
        JsonDeserializer<TotalRevenue> jsonDeSerializer = new JsonDeserializer<>(TotalRevenue.class);
        return  Serdes.serdeFrom(jsonSerializer, jsonDeSerializer);

    }

    public static Serde<Store> storeSerdes(){

        JsonSerializer<Store> jsonSerializer = new JsonSerializer<>();

        JsonDeserializer<Store> jsonDeSerializer = new JsonDeserializer<>(Store.class);
        return  Serdes.serdeFrom(jsonSerializer, jsonDeSerializer);
    }

}
