package com.example.consumer.service;


import com.example.consumer.DTO.DeviceMasterDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public class KafkaConsumer
{

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    kafkaConsumerService kafkaConsumerService;

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String kafkaModel) throws ClassNotFoundException, JsonProcessingException, ParseException {
        DeviceMasterDTO deviceData = objectMapper.readValue(kafkaModel, DeviceMasterDTO.class);

    kafkaConsumerService.createDeviceModel(deviceData);
        System.out.println("code add Successfully");
    }
}
