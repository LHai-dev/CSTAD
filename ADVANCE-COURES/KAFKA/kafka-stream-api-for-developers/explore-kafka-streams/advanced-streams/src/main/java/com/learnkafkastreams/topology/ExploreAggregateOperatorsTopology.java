package com.learnkafkastreams.topology;

import com.learnkafkastreams.domain.AlphabetWordAggregate;
import com.learnkafkastreams.serdes.SerdesFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.*;
import org.apache.kafka.streams.state.KeyValueStore;

@Slf4j
public class ExploreAggregateOperatorsTopology {


    public static String AGGREGATE = "aggregate";

    public static Topology build() {
        StreamsBuilder streamsBuilder = new StreamsBuilder();
        var inputStream = streamsBuilder.stream(AGGREGATE, Consumed.with(Serdes.String(), Serdes.String()));
        inputStream.print(Printed.<String, String>toSysOut().withLabel(AGGREGATE));
        var groupedString = inputStream
//                .groupBy((key, value) -> value,
//                        Grouped.with(Serdes.String(),Serdes.String())); //Apple - 2 , Alligator - 2
                .groupByKey(Grouped.with(Serdes.String(), Serdes.String()));
        exploreCount(groupedString);
        exploreReduce(groupedString);
//        exploreAggregate(groupedString);


        return streamsBuilder.build();
    }

    //005. Aggregation Using aggregate Operator
//    private static void exploreAggregate(KGroupedStream<String, String> groupedStream) {
//        Initializer<AlphabetWordAggregate> aggregateInitializer = AlphabetWordAggregate::new;
//
//        Aggregator<String ,String ,AlphabetWordAggregate> aggregator =
//                (key,value,alphabetWordAggregate)->
//                        alphabetWordAggregate.updateNewEvents(key,value);
//
//      var aggregatedStream =  groupedStream.aggregate(
//                aggregateInitializer,
//                aggregator,
//                Materialized
//                        .<String,AlphabetWordAggregate, KeyValueStore<Bytes,byte[]>>as("aggregated-word")
//                        .withKeySerde(Serdes.String())
//                        .withValueSerde(SerdesFactory.alphabetWordAggregate())
//        );
//        aggregatedStream.toStream().print(Printed.<String,AlphabetWordAggregate>toSysOut().withLabel("aggregated-words"));
//    }
    private static void exploreAggregate(KGroupedStream<String, String> groupedString) {

        //var alphabetWordAggregateInitializer = AlphabetWordAggregate::new;
        Initializer<AlphabetWordAggregate> alphabetWordAggregateInitializer = AlphabetWordAggregate::new;

        Aggregator<String, String, AlphabetWordAggregate> aggregator   = (key,value, alphabetWordAggregate )-> {
            return alphabetWordAggregate.updateNewEvents(key, value);
        };

        var aggregatedStream = groupedString
                .aggregate(
                        alphabetWordAggregateInitializer,
                        aggregator,
                        Materialized
                                .<String, AlphabetWordAggregate, KeyValueStore< Bytes, byte[]>>as("aggregated-words")
                                .withKeySerde(Serdes.String())
                                .withValueSerde(SerdesFactory.alphabetWordAggregate())
                );

        aggregatedStream
                .toStream()
                .print(Printed.<String,AlphabetWordAggregate>toSysOut().withLabel("aggregated-Words"));
    }

    //004. Aggregation Using reduce Operator
    private static void exploreReduce(KGroupedStream<String, String> groupedStream) {
    var reduceStream = groupedStream.reduce((value1, value2) -> {
        log.info("value : {} ,value2 : {}",value1,value2);
        return value1.toUpperCase()+"_"+value2.toUpperCase();
    },
                    Materialized.<String, String, KeyValueStore< Bytes, byte[]>>as("reduce-word")
                            .withKeySerde(Serdes.String())
                            .withValueSerde(Serdes.String())
        );//A -Apple-Alligator and so on
        reduceStream
                .toStream()
                .print(Printed.<String,String>toSysOut().withLabel("reduce-word"));

    }

    //create count key and value ex: key A have value 3 and key B have value
    // 2 [word-count-per-alphabet]: A, 3 ,[word-count-per-alphabet]: B, 2
    //when you close or down kafka it always store number pervade that you have
    // EX : that update  2 [word-count-per-alphabet]: A, 6 ,[word-count-per-alphabet]: B, 4
    // it very fast stateful operation
    private static void exploreCount(KGroupedStream<String, String> groupedStream) {
        var countByAlphabet = groupedStream.
//                count(Named.as("count-per-alphabet"));
        count(Named.as("count-per-alphabet"),Materialized.as("count-per-alphabet"));

        countByAlphabet.toStream().print(Printed.<String, Long>toSysOut().withLabel("word-count-per-alphabet"));
    }

}
