package com.example.daina.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author: Daina
 * @description:
 * @date: Created in 10:01 2019/4/10
 */
@Repository
public interface ParkingRecordMapper {
    /**
     * 功能描述:
     * 〈分页获取停车记录〉
     * @param parkingLotId 1
     * @param carLicense 2
     * @param startDate 3
     * @param endDate 4
     * @param searchType 5
     * @param status 6
     * @return : java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     * @author : daina
     * @date : 2019/4/10 10:24
     */
    List<Map<String, Object>> getParkingRecordByPage(@Param("parkingLotId")String parkingLotId,
                                                     @Param("carLicense")String carLicense,
                                                     @Param("startDate")String startDate,
                                                     @Param("endDate")String endDate,
                                                     @Param("searchType")String searchType,
                                                     @Param("status")Integer status);
    /**
     * 功能描述:
     * 〈获取分页总数〉
     * @param parkingLotId 1
     * @param carLicense 2
     * @param startDate 3
     * @param endDate 4
     * @param searchType 5
     * @param status 6
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/4/10 10:35
     */
    Integer getParkingRecordCount(@Param("parkingLotId")String parkingLotId,
                                  @Param("carLicense")String carLicense,
                                  @Param("startDate")String startDate,
                                  @Param("endDate")String endDate,
                                  @Param("searchType")String searchType,
                                  @Param("status")Integer status);

    /**
     * 功能描述:
     * 〈查询停车记录详情〉
     * @param recordId 1
     * @return : java.util.Map<java.lang.String,java.lang.Object>
     * @author : daina
     * @date : 2019/4/10 13:25
     */
    Map<String, Object> getParkingRecordInfo(@Param("recordId")String recordId);
}
