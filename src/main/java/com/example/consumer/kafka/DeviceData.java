package com.example.consumer.kafka;

import lombok.*;
import lombok.Data;

import java.util.List;


@Data
@Setter
@Getter
public class DeviceData {

    private String device_id;
    private Long create_timestamp;
    private List<Channels> channels;
}
