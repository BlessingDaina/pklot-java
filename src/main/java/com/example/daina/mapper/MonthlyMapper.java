package com.example.daina.mapper;

import com.example.daina.entity.Monthly;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author: Daina
 * @description:
 * @date: Created in 17:36 2019/3/25
 */
@Repository
public interface MonthlyMapper {
    /**
     * 功能描述:
     * 〈通过monthlyType分页获取包月用户〉
     *
     * @param parkingLotId 1
     * @param searchInfo   2
     * @param monthlyType  3
     * @return : java.util.List<com.example.daina.entity.Monthly>
     * @author : daina
     * @date : 2019/3/26 17:05
     */
    List<Monthly> getMonthlyListByPageByType(@Param("parkingLotId") String parkingLotId,
                                             @Param("searchInfo") String searchInfo,
                                             @Param("monthlyType") String monthlyType);

    /**
     * 功能描述:
     * 〈分页获取包月用户〉
     * @param parkingLotId 1
     * @param searchInfo 2
     * @return : java.util.List<com.example.daina.entity.Monthly>
     * @author : daina
     * @date : 2019/3/27 16:49
     */
    List<Monthly> getMonthlyListByPage(@Param("parkingLotId") String parkingLotId,
                                       @Param("searchInfo") String searchInfo);

    /**
     * 功能描述:
     * 〈获取包月用户数量〉
     *
     * @param parkingLotId 1
     * @param searchInfo   2
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/26 17:05
     */
    Integer getMonthlyCount(@Param("parkingLotId") String parkingLotId,
                            @Param("searchInfo") String searchInfo);

    /**
     * 功能描述:
     * 〈添加包月用户〉
     *
     * @param monthly 1
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/26 17:06
     */
    Integer addMonthly(Monthly monthly);

    /**
     * 功能描述:
     * 〈更新占位车辆〉
     *
     * @param monthly 1
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/26 17:06
     */
    Integer updateOccupyNum(Monthly monthly);

    /**
     * 功能描述:
     * 〈删除包月用户〉
     *
     * @param monthlyId 1
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/26 17:06
     */
    Integer deleteMonthly(@Param("monthlyId") String monthlyId);

    /**
     * 功能描述:
     * 〈根据包月id查询包月用户〉
     *
     * @param monthlyId 1
     * @return : com.example.daina.entity.Monthly
     * @author : daina
     * @date : 2019/3/27 9:31
     */
    Monthly getMonthlyById(@Param("monthlyId") String monthlyId);

    /**
     * 功能描述:
     * 〈根据id修改包月信息〉
     *
     * @param monthly 1
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/27 9:39
     */
    Integer updateMonthly(Monthly monthly);

    /**
     * 功能描述:
     * 〈查询当前车主姓名是否存在，如果存在，返回monthlyId〉
     * @param params 1
     * @return : java.lang.String
     * @author : daina
     * @date : 2019/4/8 14:27
     */
    List<Map<String,Object>> isExistOwnerName(Map<String,Object> params);

    /**
     * 功能描述:
     * 〈根据主停车场id查询出所有停车场id和名称〉
     * @param params 1
     * @return : java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     * @author : daina
     * @date : 2019/4/8 14:34
     */
    List<Map<String,Object>> listAllParkingLotId(Map<String, Object> params);

    /**
     * 功能描述:
     * 〈根据停车场id从车位占用表中查询停车场id是否存在，如果存在，返回monthlyId〉
     * @param params 1
     * @return : java.util.Map<java.lang.String,java.lang.Object>
     * @author : daina
     * @date : 2019/4/8 14:42
     */
    Map<String,Object> isExistParkingLotId(Map<String,Object> params);

    /**
     * 功能描述:
     * 〈根据excel表修改车位占用信息〉
     * @param params 1
     * @return : void
     * @author : daina
     * @date : 2019/4/8 14:46
     */
    void updateParkMonthlyOccupyFromExcel(Map<String,Object> params);

    /**
     * 功能描述:
     * 〈根据excel表添加包月用户基本信息〉
     * @param params 1
     * @return : void
     * @author : daina
     * @date : 2019/4/8 14:51
     */
    void saveParkMonthlyOccupyFromExcel(Map<String,Object> params);

    /**
     * 功能描述:
     * 〈查询车牌号是否存在，如果存在，返回monthlyId〉
     * @param params 1
     * @return : java.util.Map<java.lang.String,java.lang.Object>
     * @author : daina
     * @date : 2019/4/8 15:01
     */
    Map<String,Object> isExistCarLicense(Map<String,Object> params);

    /**
     * 功能描述:
     * 〈根据excel表修改包月车辆信息〉
     * @param params 1
     * @return : void
     * @author : daina
     * @date : 2019/4/8 15:05
     */
    void updateParkMonthlyCarFromExcel(Map<String,Object> params);

    /**
     * 功能描述:
     * 〈根据excel表修添加包月车辆信息〉
     * @param params 1
     * @return : void
     * @author : daina
     * @date : 2019/4/8 15:13
     */
    void saveParkMonthlyCarFromExcel(Map<String,Object> params);

    /**
     * 功能描述:
     * 〈根据excel表修改包月用户基本信息〉
     * @param params 1
     * @return : void
     * @author : daina
     * @date : 2019/4/8 15:22
     */
    void updateParkMonthlyFromExcel(Map<String,Object> params);

    /**
     * 功能描述:
     * 〈根据excel表添加包月用户基本信息〉
     * @param params 1
     * @return : void
     * @author : daina
     * @date : 2019/4/8 15:25
     */
    void saveParkMonthlyFromExcel(Map<String,Object> params);
}
