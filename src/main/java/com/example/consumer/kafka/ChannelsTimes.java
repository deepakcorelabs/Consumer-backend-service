package com.example.consumer.kafka;

import lombok.Data;


@Data
public class ChannelsTimes {

    private Long start_time_epoch;

    private Long end_time_epoch;

    private String start_time;

    private String end_time;

    private Long duration;
}
