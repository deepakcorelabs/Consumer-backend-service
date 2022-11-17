package com.example.consumer.repository;

import com.example.consumer.entity.ChannelMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelMasterRepo  extends JpaRepository<ChannelMaster,Integer>
{

}
