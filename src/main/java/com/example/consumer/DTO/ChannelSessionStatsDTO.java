package com.example.consumer.DTO;

import lombok.Data;


@Data
public class ChannelSessionStatsDTO
{

    private Integer id;


    private Long recordCreateTs;


    private Long channelId;


    private Long deviceId;


    private Integer channelStats;


    private Double duration;


    private String startTime;


    private String endTime;


    private Long  startTs;


    private Long endTs;




}
