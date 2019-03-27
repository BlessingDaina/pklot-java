package com.example.daina.mapper;

import com.example.daina.entity.MonthlyCar;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Daina
 * @description:
 * @date: Created in 9:33 2019/3/26
 */
@Repository
public interface MonthlyCarMapper {
    /**
     * 功能描述:
     * 〈分页获取包月用户车辆〉
     *
     * @param monthlyId  1
     * @param searchInfo 2
     * @return : java.util.List<com.example.daina.entity.MonthlyCar>
     * @author : daina
     * @date : 2019/3/26 17:05
     */
    List<MonthlyCar> getMonthlyCarListByPage(@Param("monthlyId") String monthlyId,
                                             @Param("searchInfo") String searchInfo);

    /**
     * 功能描述:
     * 〈获取包月用户总数〉
     *
     * @param monthlyId  1
     * @param searchInfo 2
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/26 17:08
     */
    Integer getMonthlyCarCount(@Param("monthlyId") String monthlyId,
                               @Param("searchInfo") String searchInfo);

    /**
     * 功能描述:
     * 〈添加包月用户车辆〉
     *
     * @param monthlyCar 1
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/26 17:20
     */
    Integer addMonthlyCar(MonthlyCar monthlyCar);

    /**
     * 功能描述:
     * 〈修改包月用户车辆信息〉
     *
     * @param monthlyCar 1
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/26 17:31
     */
    Integer updateMonthlyCar(MonthlyCar monthlyCar);

    /**
     * 功能描述:
     * 〈检测包月用户车牌号是否被使用〉
     *
     * @param parkingLotId 1
     * @param carLicense   2
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/26 17:37
     */
    Integer getIsUsedMonthlyCarLicense(@Param("parkingLotId") String parkingLotId,
                                       @Param("carLicense") String carLicense);

    /**
     * 功能描述:
     * 〈通过monthlyCarId删除包月用户车辆〉
     *
     * @param monthlyCarId 1
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/26 17:51
     */
    Integer deleteMonthlyCarById(@Param("monthlyCarId") String monthlyCarId);

    /**
     * 功能描述:
     * 〈通过monthlyId删除包月用户车〉
     * @param monthlyId 1
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/27 10:36
     */
    Integer deleteMonthlyCarByMonthlyId(@Param("monthlyId")String monthlyId);

    /**
     * 功能描述:
     * 〈根据monthlyId获取包月用户车辆类别〉
     * @param monthlyId 1
     * @return : java.util.List<com.example.daina.entity.MonthlyCar>
     * @author : daina
     * @date : 2019/3/27 11:02
     */
    List<MonthlyCar> getMonthlyCarList(@Param("monthlyId")String monthlyId);
}
