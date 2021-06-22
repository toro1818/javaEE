package com.example.event_processor.service;


import bjtu.edu.orders_service.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class DeliveryService {


    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    @Value("${spring.kafka.topics.order}")
    private String orderTopic;

    @KafkaListener(topics = "${spring.kafka.topics.delivery}", groupId = "${spring.kafka.consumer.group-id}")
    public void process_delivery_events(Order order){
        order.setstate(0);
        order.setdate(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()));

        this.kafkaTemplate.send(orderTopic,order);
    }
}
