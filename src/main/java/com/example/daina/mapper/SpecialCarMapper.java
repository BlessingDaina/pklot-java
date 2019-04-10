package com.example.daina.mapper;

import com.example.daina.entity.SpecialCar;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author: Daina
 * @description:
 * @date: Created in 13:18 2019/3/24
 */
@Repository
public interface SpecialCarMapper {
    /**
     * 功能描述:
     * 〈分页查询特殊车辆〉
     * @param specialType 1 （0免费车；1黑名车）
     * @param parkingLotId 2
     * @param searchInfo 3
     * @return : java.util.List<com.example.daina.entity.SpecialCar>
     * @author : daina
     * @date : 2019/3/24 13:34
     */
    List<SpecialCar> getSpecialCarListByPage(@Param("specialType") Integer specialType,
                                             @Param("parkingLotId") String parkingLotId,
                                             @Param("status")Integer status,
                                             @Param("searchInfo") String searchInfo);
    /**
     * 功能描述:
     * 〈获取总数〉
     * @param specialType 1
     * @param parkingLotId 2
     * @param searchInfo 3
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/24 13:35
     */
    Integer getSpecialCarCount(@Param("specialType") Integer specialType,
                               @Param("parkingLotId") String parkingLotId,
                               @Param("status")Integer status,
                               @Param("searchInfo") String searchInfo);
    /**
     * 功能描述:
     * 〈添加特殊车辆〉
     * @param specialCar 1
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/24 14:28
     */
    Integer addSpecialCar(SpecialCar specialCar);
    /**
     * 功能描述:
     * 〈检验车牌是否被使用〉
     * @param carLicense 1
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/24 14:38
     */
    Integer getIsUsedCarLicense(@Param("carLicense")String carLicense, @Param("parkingLotId")String parkingLotId);
    /**
     * 功能描述:
     * 〈更新特殊车辆〉
     * @param specialCar 1
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/24 15:00
     */
    Integer updateSpecialCar(SpecialCar specialCar);

    /**
     * 功能描述:
     * 〈删除特殊车辆〉
     * @param specialCarId 1
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/24 15:06
     */
    Integer deleteSpecialCar(@Param("specialCarId")String specialCarId);

    /**
     * 功能描述:
     * 〈导出特殊车辆〉
     * @param params 1
     * @return : java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     * @author : daina
     * @date : 2019/4/9 13:54
     */
    List<Map<String, Object>> exportSpecialCar(Map<String, Object> params);

    List<SpecialCar> exportTest();
}
