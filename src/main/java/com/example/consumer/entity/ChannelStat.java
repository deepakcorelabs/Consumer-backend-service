package com.example.consumer.entity;

import lombok.Data;

import javax.persistence.*;

@Table
@Entity
@Data
public class ChannelStat
{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ch_stats_id")
    private Integer id;

    @Column(name = "record_create_ts")
    private Long recordCreateTs;

    @ManyToOne
    private ChannelMaster channelId;

    @ManyToOne
    private DeviceMaster  deviceId;


    private Long count;

    @Column(name = "total_duration")
    private Double totalDuration;

    @Column(name = "start_time")
    private  String startTime;

    @Column(name = "end_time")
    private String endTime;

    @Column(name = "start_ts")
    private Long startTs;

    @Column(name = "end_ts")
    private  Long endTs;



}
