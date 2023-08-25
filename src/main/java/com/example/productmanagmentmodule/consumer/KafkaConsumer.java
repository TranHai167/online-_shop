package com.example.productmanagmentmodule.consumer;

import com.example.productmanagmentmodule.entity.Orders;
import org.springframework.kafka.annotation.KafkaListener;

public class KafkaConsumer {

    @KafkaListener(
            topics = "test",
            containerFactory = "kafkaListenerContainerFactory")
    public void greetingListener(Orders orders) {
        // process greeting message
        System.out.println(orders);
    }
}
