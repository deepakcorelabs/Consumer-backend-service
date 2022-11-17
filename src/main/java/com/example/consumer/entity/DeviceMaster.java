package com.example.consumer.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name ="device_master")
@Data
public class DeviceMaster
{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "dv_id")
    private Integer id;

    @Column(name="dv_model")
    private String deviceModel;

    @Column(name = "dv_mac_id")
    private String deviceMacId;

    @Column(name = "dv_create_ts")
    private Long deviceCreateTs;
}
