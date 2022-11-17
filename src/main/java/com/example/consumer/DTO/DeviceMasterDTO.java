package com.example.consumer.DTO;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Data
@Getter
@Setter
public class DeviceMasterDTO {
    private Integer id;


    private String deviceModel;


    private String deviceMacId;


    private Long deviceCreateTs;

    private List<ChannelMasterDTO> channelMasterList;

}
