package com.example.consumer.service;

import com.example.consumer.kafka.Channels;
import com.example.consumer.kafka.ChannelsTimes;
import com.example.consumer.kafka.DeviceData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.text.ParseException;

@Repository
public class TRPRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;


    String insert_values = """
            INSERT INTO device_data(device_id,create_timestamp) values(?,?)
                     """;
    String insert_values_channels = """
                INSERT INTO channel_data(count,name,total_duration,data_device_id) values(?,?,?,?)
            """;
    String insert_values_timeList = """
              
                                  
                 INSERT INTO time_list(device_data_id,start_time_epoch,end_time_epoch,start_time,end_time,duration,channel_id) values(?,?,?,?,?,?,?)
            """;
    String get_latest_id_value = "SELECT id FROM channel_data ORDER BY id DESC LIMIT 1";

    public void addRecord(DeviceData deviceData) throws ParseException {


        jdbcTemplate.update(insert_values, deviceData.getDevice_id(), deviceData.getCreate_timestamp());


        for (Channels channel : deviceData.getChannels()) {

            jdbcTemplate.update(insert_values_channels,
                    channel.getCount(), channel.getName(), channel.getTotal_duration(), deviceData.getDevice_id());


            channel.getChannelsTimesList().stream().forEach(channelsTimes ->
                    jdbcTemplate.update(insert_values_timeList,
                            deviceData.getDevice_id(),
                            channelsTimes.getStart_time_epoch(),
                            channelsTimes.getEnd_time_epoch(),
                            channelsTimes.getStart_time(),
                            channelsTimes.getEnd_time(),
                            channel.getTotal_duration(),
                            jdbcTemplate.queryForObject(get_latest_id_value, Integer.class)));


        }
    }

//            for (ChannelsTimes channelsTimes : channels.getChannelsTimesList()) {
//                System.out.println(channelsTimes);
//                jdbcTemplate.update(deviceData.getDevice_id(), channelsTimes.getStart_time_epoch(), channelsTimes.getEnd_time_epoch()
//                        , channelsTimes.getStart_time(), channelsTimes.getEnd_time(), channels.getTotal_duration(),
//                        jdbcTemplate.queryForObject(get_latest_id_value, Integer.class));
//            }


}
