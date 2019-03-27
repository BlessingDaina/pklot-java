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
    /**
     * 功能描述:
     * 〈分页获取包月用户〉
     * @param parkingLotId 1
     * @param searchInfo 2
     * @return : java.util.List<com.example.daina.entity.Monthly>
     * @author : daina
     * @date : 2019/3/26 17:05
     */
    List<Monthly> getMonthlyListByPage(@Param("parkingLotId") String parkingLotId,
                                       @Param("searchInfo") String searchInfo);

    /**
     * 功能描述:
     * 〈获取包月用户数量〉
     * @param parkingLotId 1
     * @param searchInfo 2
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/26 17:05
     */
    Integer getMonthlyCount(@Param("parkingLotId") String parkingLotId,
                            @Param("searchInfo") String searchInfo);

    /**
     * 功能描述:
     * 〈添加包月用户〉
     * @param monthly 1
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/26 17:06
     */
    Integer addMonthly(Monthly monthly);

    /**
     * 功能描述:
     * 〈更新占位车辆〉
     * @param monthly 1
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/26 17:06
     */
    Integer updateOccupyNum(Monthly monthly);

    /**
     * 功能描述:
     * 〈删除包月用户〉
     * @param monthlyId 1
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/26 17:06
     */
    Integer deleteMonthly(@Param("monthlyId")String monthlyId);

    /**
     * 功能描述:
     * 〈根据包月id查询包月用户〉
     * @param monthlyId 1
     * @return : com.example.daina.entity.Monthly
     * @author : daina
     * @date : 2019/3/27 9:31
     */
    Monthly getMonthlyById(@Param("monthlyId")String monthlyId);

    /**
     * 功能描述:
     * 〈根据id修改包月信息〉
     * @param monthly 1
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/27 9:39
     */
    Integer updateMonthly(Monthly monthly);
}
