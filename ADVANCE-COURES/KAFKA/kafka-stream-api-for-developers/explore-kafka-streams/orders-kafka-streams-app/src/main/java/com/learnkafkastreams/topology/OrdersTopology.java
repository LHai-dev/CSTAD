package com.learnkafkastreams.topology;

import com.learnkafkastreams.domain.*;
import com.learnkafkastreams.serdes.SerdesFactory;
import com.learnkafkastreams.util.OrderTimeStampExtractor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.*;
import org.apache.kafka.streams.state.KeyValueStore;

import java.util.List;

import static org.apache.kafka.streams.kstream.Printed.toSysOut;

//   TODO Overview of the Retail App
//      Build the Topology for the Orders Management App
@Slf4j
public class OrdersTopology {
    public static final String ORDERS = "orders";
    public static final String GENERAL_ORDERS = "general_orders";
    public static final String GENERAL_ORDERS_COUNT = "general_orders_count";
    public static final String GENERAL_ORDERS_COUNT_WINDOWS = "general_orders_count_window";
    public static final String GENERAL_ORDERS_REVENUE = "general_orders_revenue";
    public static final String GENERAL_ORDERS_REVENUE_WINDOWS = "general_orders_revenue_window";

    public static final String RESTAURANT_ORDERS = "restaurant_orders";
    public static final String RESTAURANT_ORDERS_COUNT = "restaurant_orders_count";
    public static final String RESTAURANT_ORDERS_REVENUE = "restaurant_orders_revenue";
    public static final String RESTAURANT_ORDERS_COUNT_WINDOWS = "restaurant_orders_count_window";
    public static final String RESTAURANT_ORDERS_REVENUE_WINDOWS = "restaurant_orders_revenue_window";

    public static final String STORES = "stores";


    public static Topology buildTopology() {
        // TODO 003. Split the RestaurantRetail Shopping Orders - Using Split and Branch Operato
        Predicate<String, Order> generalPredicate = (key, order) -> order.orderType().equals(OrderType.GENERAL);
        Predicate<String, Order> restaurantPredicate = ((key, order) -> order.orderType().equals(OrderType.RESTAURANT));

        ValueMapper<Order, Revenue> revenueValueMapper = order -> new Revenue(order.locationId(), order.finalAmount());


        StreamsBuilder streamsBuilder = new StreamsBuilder();

        var orderStreams = streamsBuilder
                .stream(ORDERS,
                        Consumed.with(Serdes.String(), SerdesFactory.orderSerde())
                                .withTimestampExtractor(new OrderTimeStampExtractor())
                );
        var storesTable = streamsBuilder
                .table(STORES,
                        Consumed.with(Serdes.String(), SerdesFactory.storeSerdes()));

        storesTable
                .toStream()
                .print(Printed.<String,Store>toSysOut().withLabel("stores"));

        orderStreams
                .print(Printed.<String, Order>toSysOut().withLabel("orders"));

        ValueMapper<Order, Revenue> revenueMapper = (order) -> new Revenue(order.locationId(), order.finalAmount());
        //TODO create Consumed
        var orderStream = streamsBuilder.
                stream(ORDERS,
                        Consumed.with(Serdes.String(), SerdesFactory.orderSerde()));
        orderStream.print(Printed.<String, Order>toSysOut().withLabel("orders"));
        orderStream.peek((key, value) -> {
            log.info("Consumed : key : {}, value : {}", key, value);
        });
        orderStream.split(Named.as("General-restaurant-stream"))
                .branch(generalPredicate,
                        Branched.withConsumer(generalOrderStream -> {
//                            generalOrderStream
//                                    .print(Printed.<String, Order>toSysOut().withLabel("generalOrderStream")
//                                    );
//                            generalOrderStream
//                                    .mapValues((readOnlyKey, value) -> revenueValueMapper.apply(value))
//                                    .to(GENERAL_ORDERS
//                                            , Produced.with(Serdes.String()
//                                                    , SerdesFactory.revenueSerde()));
                            aggregateOrdersByCount(generalOrderStream,GENERAL_ORDERS_COUNT);
                            aggregateOrdersByRevenue(generalOrderStream, GENERAL_ORDERS_REVENUE, storesTable);
                        }))
                .branch(restaurantPredicate,
                        Branched.withConsumer(restaurantOrderStream -> {
                            restaurantOrderStream
                                    .print(Printed.<String, Order>toSysOut().withLabel("restaurantOrderStream"));
//                            restaurantOrderStream
//                                    .mapValues((readOnlyKey, value) -> revenueValueMapper.apply(value))
//                                    .to(RESTAURANT_ORDERS
//                                    , Produced.with(Serdes.String()
//                                            , SerdesFactory.revenueSerde()));
                            aggregateOrdersByCount(restaurantOrderStream,RESTAURANT_ORDERS_COUNT);
                            aggregateOrdersByRevenue(restaurantOrderStream,RESTAURANT_ORDERS_REVENUE,storesTable);

                        }));


        return streamsBuilder.build();
    }

    private static void aggregateOrdersByRevenue(KStream<String, Order> generalOrdersStream, String aggregateStoreName, KTable<String, Store> storesTable) {
        Initializer<TotalRevenue> totalRevenueInitializer = TotalRevenue::new;

        Aggregator<String, Order, TotalRevenue> aggregator   = (key,order, totalRevenue )-> {
            return totalRevenue.updateRunningRevenue(key, order);
        };

        var revenueTable = generalOrdersStream
                .map((key, value) -> KeyValue.pair(value.locationId(), value))
                .groupByKey(Grouped.with(Serdes.String(), SerdesFactory.orderSerde()))
                .aggregate(totalRevenueInitializer,
                        aggregator,
                        Materialized
                                .<String, TotalRevenue, KeyValueStore<Bytes, byte[]>>as(aggregateStoreName)
                                .withKeySerde(Serdes.String())
                                .withValueSerde(SerdesFactory.totalRevenueSerdes())
                );

        revenueTable
                .toStream()
                .print(Printed.<String,TotalRevenue>toSysOut().withLabel(aggregateStoreName));

        ValueJoiner<TotalRevenue, Store, TotalRevenueWithAddress> valueJoiner = TotalRevenueWithAddress::new;

        var revenueWithStoreTable = revenueTable
                .leftJoin(storesTable,valueJoiner);

        revenueWithStoreTable
                .toStream()
                .print(Printed.<String,TotalRevenueWithAddress>toSysOut().withLabel(aggregateStoreName+"-bystore"));
    }

    //001. Total Number of Orders by Each Store Using count Operator
    private static void aggregateOrdersByCount(KStream<String, Order> generalOrderStream, String storeName) {
      var orderCountPerStore = generalOrderStream
                .map((key, value) -> KeyValue.pair(value.locationId(),value))
                .groupByKey(Grouped.with(Serdes.String(),SerdesFactory.orderSerde()))
                .count(Named.as(storeName),Materialized.as(storeName));
      orderCountPerStore.toStream().print(Printed.<String,Long>toSysOut().withLabel(storeName));
    }
}
