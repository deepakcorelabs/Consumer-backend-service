package com.example.consumer.kafka;

import com.example.consumer.service.TRPRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public class Consumer {

    private final String SQL_INSERT_Consumer = "insert into Consumer(id, device_id, duration_start_time, duration_end_time,duration_time_period,channel_id,channel_name,channel_start_time,channel_end_time,channel_time_duration) values(?,?,?,?,?,?,?,?,?,?)";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    TRPRepo trpRepo;
    @Autowired
    ObjectMapper objectMapper;

    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String kafkaModel) throws ClassNotFoundException, JsonProcessingException, ParseException {
        DeviceData deviceData = objectMapper.readValue(kafkaModel, DeviceData.class);

        trpRepo.addRecord(deviceData);
        System.out.println("record added ");


    }
}
