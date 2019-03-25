package com.example.daina.mapper;

import com.example.daina.entity.TempCar;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Daina
 * @description:
 * @date: Created in 15:33 2019/3/25
 */
@Repository
public interface TempCarMapper {
    /**
     * 功能描述:
     * 〈获取全部临停车〉
     * @param parkingLotId 1
     * @param searchInfo 2
     * @return : java.util.List<com.example.daina.entity.TempCar>
     * @author : daina
     * @date : 2019/3/25 15:50
     */
    List<TempCar> getAllTempCarList(@Param("parkingLotId")String parkingLotId,
                                    @Param("searchInfo")String searchInfo);
    /**
     * 功能描述:
     * 〈查询全部临停车总数〉
     * @param parkingLotId 1
     * @param searchInfo 2
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/25 16:03
     */
    Integer getAllTempCarCount(@Param("parkingLotId")String parkingLotId,
                               @Param("searchInfo")String searchInfo);
    /**
     * 功能描述:
     * 〈通过临停类型id查询临停车辆〉
     * @param parkingLotId 1
     * @param searchInfo 2
     * @param categoryId 3
     * @return : java.util.List<com.example.daina.entity.TempCar>
     * @author : daina
     * @date : 2019/3/25 15:51
     */
    List<TempCar> getTempCarListByCategoryId(@Param("parkingLotId")String parkingLotId,
                                             @Param("searchInfo")String searchInfo,
                                             @Param("categoryId")String categoryId);
    /**
     * 功能描述:
     * 〈通过临停类型id查询临停车辆数量〉
     * @param parkingLotId 1
     * @param searchInfo 2
     * @param categoryId 3
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/25 16:03
     */
    Integer getTempCarCountByCategoryId(@Param("parkingLotId")String parkingLotId,
                                        @Param("searchInfo")String searchInfo,
                                        @Param("categoryId")String categoryId);

    /**
     * 功能描述:
     * 〈添加临停车辆〉
     * @param tempCar 1
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/25 16:25
     */
    Integer addTempCar(TempCar tempCar);

    /**
     * 功能描述:
     * 〈检验车牌号是否已存在〉
     * @param carLicense 1
     * @param parkingLotId 2
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/25 16:34
     */
    Integer getIsUsedTempCar(@Param("carLicense")String carLicense,
                             @Param("parkingLotId")String parkingLotId);

    /**
     * 功能描述:
     * 〈更新临时车辆〉
     * @param tempCar 1
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/25 17:03
     */
    Integer updateTempCar(TempCar tempCar);

    /**
     * 功能描述:
     * 〈删除临停车〉
     * @param tempCarId 1
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/25 17:09
     */
    Integer deleteTempCar(@Param("tempCarId")String tempCarId);
}
