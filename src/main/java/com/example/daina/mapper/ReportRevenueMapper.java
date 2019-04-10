package com.example.daina.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author: Daina
 * @description:
 * @date: Created in 14:31 2019/4/10
 */
@Repository
public interface ReportRevenueMapper {
    /**
     * 功能描述:
     * 〈获取收入报表列表〉
     * @param parkingLotId 1
     * @param startDate 2
     * @param endDate 3
     * @return : java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     * @author : daina
     * @date : 2019/4/10 14:38
     */
    List<Map<String, Object>> getReportRevenueList (@Param("parkingLotId")String parkingLotId,
                                                    @Param("startDate")String startDate,
                                                    @Param("endDate")String endDate);
}
