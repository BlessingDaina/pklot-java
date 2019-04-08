package com.example.daina.mapper;

import com.example.daina.entity.Category;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author: Daina
 * @description:
 * @date: Created in 9:50 2019/3/23
 */
@Repository
public interface CategoryMapper {
    /**
     * 功能描述:
     * 〈获取类型列表〉
     * @param parkingLotId 1
     * @param categoryType 2 （1：包月类别；2：免费类别；3：免费放行类别；4：临停车类别）
     * @return : java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     * @author : daina
     * @date : 2019/3/24 11:19
     */
    List<Map<String, Object>> getCarCategoryList(@Param("parkingLotId") String parkingLotId, @Param("categoryType")String categoryType);
    /**
     * 功能描述:
     * 〈添加类别〉
     * @param category 1
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/24 11:20
     */
    Integer addCarCategory(Category category);
    /**
     * 功能描述:
     * 〈删除类别〉
     * @param categoryId 1
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/24 11:20
     */
    Integer deleteCarCategory(@Param("categoryId") String categoryId);
    /**
     * 功能描述:
     * 〈查询停车场车辆类别〉
     * @param params 1
     * @return : java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     * @author : daina
     * @date : 2019/4/8 15:18
     */
    List<Map<String,Object>> listCarCategory(Map<String,Object> params);
}
