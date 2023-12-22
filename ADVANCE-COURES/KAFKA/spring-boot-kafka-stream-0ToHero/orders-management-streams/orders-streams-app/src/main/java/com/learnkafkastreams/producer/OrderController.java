package com.learnkafkastreams.producer;// OrderController.java
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learnkafkastreams.domain.Order;
import com.learnkafkastreams.producer.ProducerUtil;
import com.learnkafkastreams.topology.OrdersTopology;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
@Slf4j

public class OrderController {

    private final ObjectMapper objectMapper;


    public OrderController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }



    @PostMapping("/receive")
    public ResponseEntity<String> receiveOrder(@RequestBody Order order) {
        try {
            String orderJson = objectMapper.writeValueAsString(order);
            ProducerUtil.publishMessageSync(OrdersTopology.ORDERS, order.locationId().toUpperCase(), orderJson);
            log.info("Received and published order: {}", order);
            return ResponseEntity.status(HttpStatus.CREATED).body("Order received and published successfully!");
        } catch (JsonProcessingException e) {
            log.error("Error processing order: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing order");
        } catch (Exception e) {
            log.error("Unexpected error: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unexpected error");
        }
    }
}
