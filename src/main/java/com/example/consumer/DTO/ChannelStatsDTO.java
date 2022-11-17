package com.example.consumer.DTO;


import lombok.Data;

import java.util.List;

@Data
public class ChannelStatsDTO
{

    private Integer id;


    private Long recordCreateTs;


    private Integer channelId;


    private Integer deviceId;


    private Long count;


    private Double totalDuration;


    private String startTime;


    private String endTime;


    private Long startTs;


    private Long endTs;

    private List<ChannelSessionStatsDTO> channelSessionStatsDTOList;
}
