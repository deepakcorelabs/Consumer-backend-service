package com.example.consumer.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "channel_session_stats")
public class ChannelSessionStats
{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ch_ses_stats_id")
    private Integer id;

    @Column(name = "record_create_ts")
    private Long recordCreateTs;


    @ManyToOne
    @JoinColumn(name="channel_id")
    private ChannelMaster channel;

    @ManyToOne
    @JoinColumn(name ="device_id")
    private DeviceMaster deviceId;

    @ManyToOne
    @JoinColumn(name="channel_stat_id")
    private ChannelStat channelStat;


    private Double duration;

    @Column(name =  "start_time")
    private String startTime;

    @Column(name =  "end_time")
    private String endTime;

    @Column(name =  "start_ts")
    private Long  startTs;

    @Column(name =  "end_ts")
    private Long endTs;




}
