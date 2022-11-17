package com.example.consumer.entity;

import lombok.Data;

import javax.persistence.*;

@Table(name = "channel_master")
@Entity
@Data
public class ChannelMaster {


    @Column(name = "ch_id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer channelId;

    @Column(name = "ch_name")
    private String channelName;

    @Column(name = "ch_create_ts")
    private Long channelCreateTs;


}
