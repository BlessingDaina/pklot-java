package com.example.daina.controller;

import com.example.daina.annotation.UserLoginToken;
import com.example.daina.entity.Category;
import com.example.daina.entity.Result;
import com.example.daina.service.CategoryService;
import com.example.daina.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author: Daina
 * @description:
 * @date: Created in 10:29 2019/3/23
 */
@RestController
@RequestMapping(value = "/api/pklot")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @UserLoginToken
    @RequestMapping(value = "/getCarCategoryList", method = RequestMethod.POST)
    public Result getCarCategoryList(@RequestParam("parkingLotId")String parkingLotId, @RequestParam("categoryType")String categoryType) {
        List<Map<String, Object>> categorys = categoryService.getCarCategoryList(parkingLotId, categoryType);
        return ResultUtil.success(categorys);
    }

    @UserLoginToken
    @RequestMapping(value = "/addCarCategory", method = RequestMethod.POST)
    public Result addCarCategory(Category category) {
        Integer result = categoryService.addCarCategory(category);
        return ResultUtil.success(result);
    }

    @UserLoginToken
    @RequestMapping(value = "/deleteCarCategory", method = RequestMethod.POST)
    public Result deleteCarCategory(@RequestParam("categoryId")String categoryId) {
        Integer result = categoryService.deleteCarCategory(categoryId);
        return ResultUtil.success(result);
    }
}
