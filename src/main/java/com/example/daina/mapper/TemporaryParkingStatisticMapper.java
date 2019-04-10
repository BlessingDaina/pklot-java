package com.example.daina.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author: Daina
 * @description:
 * @date: Created in 15:34 2019/4/10
 */
@Repository
public interface TemporaryParkingStatisticMapper {
    List<Map<String, Object>> getTemporaryParkingDetailList(@Param("parkingLotId")String parkingLotId,
                                                            @Param("startDate")String startDate,
                                                            @Param("endDate")String endDate,
                                                            @Param("freeType")Integer freeType,
                                                            @Param("incomeName")String incomeName);

    Integer getTemporaryParkingDetailCount(@Param("parkingLotId")String parkingLotId,
                                           @Param("startDate")String startDate,
                                           @Param("endDate")String endDate,
                                           @Param("freeType")Integer freeType,
                                           @Param("incomeName")String incomeName);
}
