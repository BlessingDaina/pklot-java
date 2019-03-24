package com.example.daina.mapper;

import com.example.daina.entity.Driveway;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Daina
 * @description:
 * @date: Created in 14:50 2019/3/23
 */
@Repository
public interface DrivewayMapper {

    /**
     * 功能描述:
     * 〈获取通道列表〉
     * @param parkingLotId 1
     * @param drivewayName 2
     * @return : java.util.List<com.example.daina.entity.Driveway>
     * @author : daina
     * @date : 2019/3/24 11:04
     */
    List<Driveway> getDrivewayList(@Param("parkingLotId") String parkingLotId, @Param("drivewayName") String drivewayName);
    /**
     * 功能描述:
     * 〈通过通道类型获取通道列表（0：入口；1：出口）〉
     * @param parkingLotId 1
     * @param drivewayName 2
     * @param drivewayType 3
     * @return : java.util.List<com.example.daina.entity.Driveway>
     * @author : daina
     * @date : 2019/3/24 11:05
     */
    List<Driveway> getDrivewayListByType(@Param("parkingLotId") String parkingLotId,
                                         @Param("drivewayName") String drivewayName,
                                         @Param("drivewayType") String drivewayType);
    /**
     * 功能描述:
     * 〈通过状态获取通道列表（0：已停用；1：启用）〉
     * @param parkingLotId 1
     * @param drivewayName 2
     * @param drivewayStatus 3
     * @return : java.util.List<com.example.daina.entity.Driveway>
     * @author : daina
     * @date : 2019/3/24 11:06
     */
    List<Driveway> getDrivewayListByStatus(@Param("parkingLotId") String parkingLotId,
                                           @Param("drivewayName") String drivewayName,
                                           @Param("drivewayStatus") String drivewayStatus);
    /**
     * 功能描述:
     * 〈通过Id获取通道信息〉
     * @param drivewayId 1
     * @return : com.example.daina.entity.Driveway
     * @author : daina
     * @date : 2019/3/24 11:07
     */
    Driveway getDrivewayInfo(@Param("drivewayId") String drivewayId);
    /**
     * 功能描述:
     * 〈更新通道信息〉
     * @param driveway 1
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/24 11:07
     */
    Integer updateDriveway(Driveway driveway);

    /**
     * 功能描述:
     * 〈停用启用通道〉
     * @param drivewayId 1
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/24 11:27
     */
    Integer updateDrivewayStatus(@Param("drivewayId") String drivewayId, @Param("drivewayStatus") Integer drivewayStatus);
}
