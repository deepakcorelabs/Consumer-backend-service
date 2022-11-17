package com.example.consumer.kafka;






public class KafkaModel
{

    private Long id;
    private  String  device_id;
    private  Long duration_start_time;

    private  Long duration_end_time;
    private Long channel_end_time;
    private Short channel_time_duration;

    private Short duration_time_period;
    private  String channel_id;
    private String  channel_name;

    private Long channel_start_time;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public Long getDuration_start_time() {
        return duration_start_time;
    }

    public void setDuration_start_time(Long duration_start_time) {
        this.duration_start_time = duration_start_time;
    }

    public Long getDuration_end_time() {
        return duration_end_time;
    }

    public void setDuration_end_time(Long duration_end_time) {
        this.duration_end_time = duration_end_time;
    }

    public short getDuration_time_period() {
        return duration_time_period;
    }

    public void setDuration_time_period(short duration_time_period) {
        this.duration_time_period = duration_time_period;
    }

    public String getChannel_id() {
        return channel_id;
    }

    public void setChannel_id(String channel_id) {
        this.channel_id = channel_id;
    }

    public String getChannel_name() {
        return channel_name;
    }

    public void setChannel_name(String channel_name) {
        this.channel_name = channel_name;
    }

    public Long getChannel_start_time() {
        return channel_start_time;
    }

    public void setChannel_start_time(Long channel_start_time) {
        this.channel_start_time = channel_start_time;
    }

    public Long getChannel_end_time() {
        return channel_end_time;
    }

    public void setChannel_end_time(Long channel_end_time) {
        this.channel_end_time = channel_end_time;
    }

    public Short getChannel_time_duration() {
        return channel_time_duration;
    }

    public void setChannel_time_duration(Short channel_time_duration) {
        this.channel_time_duration = channel_time_duration;
    }


    public KafkaModel() {
    }

    @Override
    public String toString() {
        return "KafkaModel{" +
                "id=" + id +
                ", device_id='" + device_id + '\'' +
                ", duration_start_time='" + duration_start_time + '\'' +
                ", duration_end_time='" + duration_end_time + '\'' +
                ", duration_time_period='" + duration_time_period + '\'' +
                ", channel_id=" + channel_id +
                ", channel_name='" + channel_name + '\'' +
                ", channel_start_time=" + channel_start_time +
                ", channel_end_time=" + channel_end_time +
                ", channel_time_duration=" + channel_time_duration +
                '}';
    }


}

