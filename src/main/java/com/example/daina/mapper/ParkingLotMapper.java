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
    /**
     * 功能描述:
     * 〈分页获取停车场列表〉
     * @param parkingLotName 1
     * @return : java.util.List<com.example.daina.entity.ParkingLot>
     * @author : daina
     * @date : 2019/3/24 11:21
     */
    List<ParkingLot> getParkingLotByPage(@Param("parkingLotName") String parkingLotName);
    /**
     * 功能描述:
     * 〈获取停车场总数〉
     * @param  1
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/24 11:21
     */
    Integer getParkingLotCount();
    /**
     * 功能描述:
     * 〈获取停车场信息〉
     * @param parkingLotId 1
     * @return : com.example.daina.entity.ParkingLot
     * @author : daina
     * @date : 2019/3/24 11:21
     */
    ParkingLot getParkingLotInfo(@Param("parkingLotId") String parkingLotId);
    /**
     * 功能描述:
     * 〈获取子停车场〉
     * @param parkingLotId 1
     * @return : java.util.List<com.example.daina.entity.ParkingLot>
     * @author : daina
     * @date : 2019/3/24 11:21
     */
    List<ParkingLot> getNestParkingLot(@Param("parkingLotId") String parkingLotId);
    /**
     * 功能描述:
     * 〈更新管理设置相关项〉
     * @param key 1
     * @param value 2
     * @param parkingLotId 3
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/24 11:22
     */
    Integer updateManagement(@Param("key") String key, @Param("value") String value, @Param("parkingLotId") String parkingLotId);
}
