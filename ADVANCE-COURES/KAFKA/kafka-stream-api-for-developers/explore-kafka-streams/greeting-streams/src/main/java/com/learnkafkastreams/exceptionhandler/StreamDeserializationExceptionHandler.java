package com.learnkafkastreams.exceptionhandler;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.streams.errors.DeserializationExceptionHandler;
import org.apache.kafka.streams.processor.ProcessorContext;

import java.util.Map;
//TODO 003. Custom Deserialization Error Handler
@Slf4j
public class StreamDeserializationExceptionHandler implements DeserializationExceptionHandler {

    int errorCount = 0;
    @Override
    public DeserializationHandlerResponse handle(ProcessorContext context, ConsumerRecord<byte[], byte[]> record, Exception exception) {
        log.error("Exception is : {} , and the kafka record is : {} ",exception.getMessage(),record,exception);
        log.info("errorCount : {}" ,errorCount);
        if(errorCount<2){
            errorCount++;
            return DeserializationHandlerResponse.CONTINUE;
        }

        return DeserializationHandlerResponse.FAIL;
    }

    @Override
    public void configure(Map<String, ?> configs) {

    }
}
