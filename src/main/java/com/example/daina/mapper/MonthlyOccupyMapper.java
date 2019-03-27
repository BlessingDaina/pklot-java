package com.example.daina.mapper;

import com.example.daina.entity.MonthlyOccupy;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author: Daina
 * @description:
 * @date: Created in 11:02 2019/3/26
 */
@Repository
public interface MonthlyOccupyMapper {
    /**
     * 功能描述:
     * 〈添加包月用户时获取占位信息〉
     * @param parkingLotId 1
     * @return : java.util.List<com.example.daina.entity.MonthlyOccupy>
     * @author : daina
     * @date : 2019/3/26 11:15
     */
    List<Map<String, Object>> addGetMonthlyOccupy(@Param("parkingLotId")String parkingLotId);

    /**
     * 功能描述:
     * 〈编辑时获取包月用户占位信息〉
     * @param parkingLotId 1
     * @param monthlyId 2
     * @return : java.util.List<com.example.daina.entity.MonthlyOccupy>
     * @author : daina
     * @date : 2019/3/26 11:33
     */
    List<Map<String, Object>> editGetMonthlyOccupy(@Param("parkingLotId")String parkingLotId,
                                             @Param("monthlyId")String monthlyId);

    /**
     * 功能描述:
     * 〈添加包月占位信息〉
     * @param monthlyOccupyList 1
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/26 16:08
     */
    Integer addMonthlyOccupy(List<MonthlyOccupy> monthlyOccupyList);

    /**
     * 功能描述:
     * 〈批量更新包月占位信息〉
     * @param monthlyOccupyList 1
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/27 9:56
     */
    Integer updateMonthlyOccupy(List<MonthlyOccupy> monthlyOccupyList);

    /**
     * 功能描述:
     * 〈通过monthlyId获取占位信息〉
     * @param monthlyId 1
     * @return : java.util.List<com.example.daina.entity.MonthlyOccupy>
     * @author : daina
     * @date : 2019/3/26 16:09
     */
    List<MonthlyOccupy> getOccupyByMonthlyId(@Param("monthlyId")String monthlyId);

    /**
     * 功能描述:
     * 〈删除包月占位信息〉
     * @param monthlyId 1
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/27 9:55
     */
    Integer deleteMonthlyOccupy(@Param("monthlyId")String monthlyId);
}
