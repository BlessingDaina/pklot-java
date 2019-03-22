package com.example.daina.mapper;

import com.example.daina.entity.ParkingLot;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Daina
 * @description:
 * @date: Created in 11:36 2019/3/17
 */
@Repository
public interface ParkingLotMapper {
    List<ParkingLot> getParkingLotByPage(@Param("parkingLotName") String parkingLotName);
    Integer getParkingLotCount();
    ParkingLot getParkingLotInfo(@Param("parkingLotId") String parkingLotId);
    List<ParkingLot> getNestParkingLot(@Param("parkingLotId") String parkingLotId);
    Integer updateManagement(@Param("key") String key, @Param("value") String value, @Param("parkingLotId") String parkingLotId);
}
