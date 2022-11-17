package com.example.consumer.service;

import com.example.consumer.DTO.ChannelMasterDTO;
import com.example.consumer.DTO.ChannelSessionStatsDTO;
import com.example.consumer.DTO.ChannelStatsDTO;
import com.example.consumer.DTO.DeviceMasterDTO;
import com.example.consumer.entity.ChannelMaster;
import com.example.consumer.entity.ChannelSessionStats;
import com.example.consumer.entity.ChannelStat;
import com.example.consumer.entity.DeviceMaster;
import com.example.consumer.repository.ChannelMasterRepo;
import com.example.consumer.repository.ChannelSessionStatsRepo;
import com.example.consumer.repository.ChannelStatsRepo;
import com.example.consumer.repository.DeviceMasterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class kafkaConsumerService {

    @Autowired
    DeviceMasterRepo deviceMasterRepo;

    @Autowired
    ChannelMasterRepo channelMasterRepo;

    @Autowired
    ChannelStatsRepo channelStatsRepo;

    @Autowired
    ChannelSessionStatsRepo channelSessionStatsRepo;

    @Autowired(required = false)
    ChannelSessionStats channelSessionStats;




    public void createDeviceModel(DeviceMasterDTO deviceMasterDTO) {
        int device_id;
        DeviceMaster deviceMaster = new DeviceMaster();
        deviceMaster.setDeviceModel(deviceMasterDTO.getDeviceModel());
        deviceMaster.setDeviceMacId(deviceMasterDTO.getDeviceMacId());
        deviceMaster.setDeviceCreateTs(System.currentTimeMillis()/1000);

        if (!deviceMasterRepo.existsByDeviceMacId(deviceMaster.getDeviceMacId())) {
            device_id = deviceMasterRepo.save(deviceMaster).getId();
        }
        else {
            device_id=deviceMasterRepo.findByDeviceMacId(deviceMaster.getDeviceMacId()).getId();
        }

        for (ChannelMasterDTO channelMasterDTO : deviceMasterDTO.getChannelMasterList()) {

            int channel_id = createChannelMaster(channelMasterDTO);

            for (ChannelStatsDTO channelStatsDTO : channelMasterDTO.getChannelStatsDTOList()) {

                int stats_id = createChannelStats(channelStatsDTO, device_id, channel_id);

            for (ChannelSessionStatsDTO channelSessionStatsDTO : channelStatsDTO.getChannelSessionStatsDTOList()) {
                  createChannelSessionStats(channelSessionStatsDTO, device_id, channel_id, stats_id);
                }
            }
        }


    }

    public int createChannelMaster(ChannelMasterDTO channelMasterDTO) {
        ChannelMaster channelMaster = new ChannelMaster();
        channelMaster.setChannelCreateTs(System.currentTimeMillis()/1000);
        channelMaster.setChannelName(channelMasterDTO.getChannelName());
        return channelMasterRepo.save(channelMaster).getChannelId();

    }
    @Transactional
    public int createChannelStats(ChannelStatsDTO channelStatsDTO, int device_id, int channel_id) {

        ChannelMaster channelMaster = channelMasterRepo.findById(channel_id).get();
        DeviceMaster deviceMaster = deviceMasterRepo.findById(device_id).get();
        ChannelStat channelStat = new ChannelStat();
        channelStat.setChannelId(channelMaster);
        channelStat.setCount(channelStatsDTO.getCount());
        channelStat.setDeviceId(deviceMaster);
        channelStat.setEndTime(channelStatsDTO.getEndTime());
        channelStat.setRecordCreateTs(System.currentTimeMillis()/1000);
        channelStat.setEndTs(channelStatsDTO.getEndTs());
        channelStat.setStartTs(channelStatsDTO.getStartTs());
        channelStat.setStartTime(channelStatsDTO.getStartTime());
        channelStat.setTotalDuration(channelStatsDTO.getTotalDuration());
        return channelStatsRepo.save(channelStat).getId();

    }

    public String createChannelSessionStats(ChannelSessionStatsDTO channelSessionStats, int device_id, int channel_id, int stats_id) {
        ChannelMaster channelMaster = channelMasterRepo.findById(channel_id).get();
        DeviceMaster deviceMaster = deviceMasterRepo.findById(device_id).get();
        ChannelStat channelStat = channelStatsRepo.findById(stats_id).get();



        ChannelSessionStats channelSessionStats1 = new ChannelSessionStats();
        channelSessionStats1.setChannelStat(channelStat);
        channelSessionStats1.setChannel(channelMaster);
        channelSessionStats1.setDeviceId(deviceMaster);
        channelSessionStats1.setEndTime(channelSessionStats.getEndTime());
        channelSessionStats1.setRecordCreateTs(System.currentTimeMillis()/1000);
        channelSessionStats1.setStartTs(channelSessionStats.getStartTs());
        channelSessionStats1.setStartTime(channelSessionStats.getStartTime());
        channelSessionStats1.setEndTs(channelSessionStats.getEndTs());
        channelSessionStats1.setDuration(channelSessionStats.getDuration());


        channelSessionStatsRepo.save(channelSessionStats1);
        return "String";
    }
}