package com.example.consumer.repository;

import com.example.consumer.entity.DeviceMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceMasterRepo extends JpaRepository<DeviceMaster,Integer> {

    public boolean existsByDeviceMacId(String id);

    public DeviceMaster findByDeviceMacId(String id);

}
