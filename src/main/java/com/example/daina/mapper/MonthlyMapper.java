package com.example.daina.mapper;

import com.example.daina.entity.Monthly;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Daina
 * @description:
 * @date: Created in 17:36 2019/3/25
 */
@Repository
public interface MonthlyMapper {
    List<Monthly> getMonthlyListByPage(@Param("parkingLotId") String parkingLotId,
                                       @Param("searchInfo") String searchInfo);

    Integer getMonthlyCount(@Param("parkingLotId") String parkingLotId,
                            @Param("searchInfo") String searchInfo);

    Integer addMonthly(Monthly monthly);

    Integer updateOccupyNum(Monthly monthly);

    Integer deleteMonthly(@Param("monthlyId")String monthlyId);
}
