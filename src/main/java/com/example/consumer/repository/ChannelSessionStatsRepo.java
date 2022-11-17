package com.example.consumer.repository;

import com.example.consumer.entity.ChannelSessionStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelSessionStatsRepo extends JpaRepository<ChannelSessionStats,Integer> {

}
