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
    List<Map<String, Object>> getCarCategoryList(@Param("parkingLotId") String parkingLotId, @Param("categoryType")String categoryType);
    Integer addCarCategory(Category category);
    Integer deleteCarCategory(@Param("categoryId") String categoryId);
}
