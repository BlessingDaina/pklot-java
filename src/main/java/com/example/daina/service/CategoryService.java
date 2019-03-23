package com.example.daina.service;

import com.example.daina.entity.Category;
import com.example.daina.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author: Daina
 * @description:
 * @date: Created in 10:26 2019/3/23
 */
@Service
public class CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    public List<Map<String, Object>> getCarCategoryList(String parkingLotId, String categoryType) {
        List<Map<String, Object>> categories = categoryMapper.getCarCategoryList(parkingLotId, categoryType);
        return categories;
    }

    public Integer addCarCategory(Category category) {
        Integer result = categoryMapper.addCarCategory(category);
        return result;
    }

    public Integer deleteCarCategory(String categoryId) {
        Integer result = categoryMapper.deleteCarCategory(categoryId);
        return result;
    }
}
