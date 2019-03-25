package com.example.daina.mapper;

import com.example.daina.entity.FallibleLicense;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Daina
 * @description:
 * @date: Created in 14:14 2019/3/25
 */
@Repository
public interface FallibleLicenseMapper {
    /**
     * 功能描述:
     * 〈分页查询易错车牌〉
     * @param parkingLotId 1
     * @param searchInfo 2
     * @return : java.util.List<com.example.daina.entity.FallibleLicense>
     * @author : daina
     * @date : 2019/3/25 14:20
     */
    List<FallibleLicense> getFallibleLicenseByPage(@Param("parkingLotId")String parkingLotId,
                                                   @Param("searchInfo") String searchInfo);

    /**
     * 功能描述:
     * 〈获取易错车牌总数〉
     * @param parkingLotId 1
     * @param searchInfo 2
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/25 14:23
     */
    Integer getFallibleLicenseCount(@Param("parkingLotId")String parkingLotId,
                                    @Param("searchInfo") String searchInfo);

    /**
     * 功能描述:
     * 〈添加易错车牌〉
     * @param fallibleLicense 1
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/25 14:48
     */
    Integer addFallibleLicense(FallibleLicense fallibleLicense);

    /**
     * 功能描述:
     * 〈检查错误车牌是否已存在〉
     * @param errorLicense 1
     * @param parkingLotId 2
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/25 15:07
     */
    Integer getIsUsedErrorLicense(@Param("errorLicense")String errorLicense, @Param("parkingLotId")String parkingLotId);

    /**
     * 功能描述:
     * 〈更新易错车牌〉
     * @param fallibleLicense 1
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/25 15:07
     */
    Integer updateFallibleLicense(FallibleLicense fallibleLicense);

    /**
     * 功能描述:
     * 〈删除易错车牌〉
     * @param fallibleId 1
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/25 15:13
     */
    Integer deleteFallibleLicense(@Param("fallibleId")String fallibleId);
}
