package com.example.consumer.DTO;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class ChannelMasterDTO {


    private Integer channelId;


    private String channelName;


    private Long channelCreateTs;

    private List<ChannelStatsDTO> channelStatsDTOList;



}
