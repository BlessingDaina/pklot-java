package com.example.daina.mapper;

import com.example.daina.entity.MonthlyExtend;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author: Daina
 * @description:
 * @date: Created in 11:46 2019/3/27
 */
@Repository
public interface MonthlyExtendMapper {

    /**
     * 功能描述:
     * 〈添加包月续费信息〉
     * @param monthlyExtend 1
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/27 13:50
     */
    Integer addMonthlyExtend(MonthlyExtend monthlyExtend);

    List<Map<String, Object>> getMonthlyIncomeList(@Param("parkingLotId")String parkingLotId,
                                                   @Param("carLicense")String carLicense,
                                                   @Param("startDate")String startDate,
                                                   @Param("endDate")String endDate);

    Integer getMonthlyIncomeCount(@Param("parkingLotId")String parkingLotId,
                                  @Param("carLicense")String carLicense,
                                  @Param("startDate")String startDate,
                                  @Param("endDate")String endDate);
}
