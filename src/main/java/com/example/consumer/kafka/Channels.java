package com.example.consumer.kafka;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Setter
@Getter
public class Channels {
    private Long count;

    private String name;

    private Long total_duration;

    private List<ChannelsTimes> channelsTimesList;

}
