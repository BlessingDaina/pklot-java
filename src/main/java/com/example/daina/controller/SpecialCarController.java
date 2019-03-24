package com.example.daina.controller;

import com.example.daina.annotation.UserLoginToken;
import com.example.daina.entity.Page;
import com.example.daina.entity.Result;
import com.example.daina.entity.SpecialCar;
import com.example.daina.service.SpecialCarService;
import com.example.daina.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Daina
 * @description:
 * @date: Created in 13:37 2019/3/24
 */
@RestController
@RequestMapping(value = "/api/pklot")
public class SpecialCarController {
    @Autowired
    SpecialCarService specialCarService;

    @UserLoginToken
    @RequestMapping(value = "/getSpecialCarListByPage")
    public Result getSpecialCarListByPage(@RequestParam("pageNum") Integer pageNum,
                                          @RequestParam("pageSize") Integer pageSize,
                                          @RequestParam("specialType") Integer specialType,
                                          @RequestParam("parkingLotId") String parkingLotId,
                                          @RequestParam("status") Integer status,
                                          @RequestParam("searchInfo") String searchInfo) {
        Page<SpecialCar> specialCarPage = specialCarService.getSpecialCarListByPage(pageNum,
                pageSize, specialType, parkingLotId, status, searchInfo);
        return ResultUtil.success(specialCarPage);
    }

    @UserLoginToken
    @RequestMapping(value = "/addSpecialCar")
    public Result addSpecialCar(SpecialCar specialCar) {
        Integer result = specialCarService.addSpecialCar(specialCar);
        return ResultUtil.success(result);
    }

    @UserLoginToken
    @RequestMapping(value = "/getIsUsedCarLicense")
    public Result getIsUsedCarLicense(@RequestParam("carLicense") String carLicense, @RequestParam("parkingLotId") String parkingLotId) {
        Integer result = specialCarService.getIsUsedCarLicense(carLicense, parkingLotId);
        return ResultUtil.success(result);
    }

    @UserLoginToken
    @RequestMapping(value = "/updateSpecialCar")
    public Result updateSpecialCar(SpecialCar specialCar) {
        Integer result = specialCarService.updateSpecialCar(specialCar);
        return ResultUtil.success(result);
    }

    @UserLoginToken
    @RequestMapping(value = "/deleteSpecialCar")
    public Result deleteSpecialCar(@RequestParam("specialCarId")String specialCarId) {
        Integer result = specialCarService.deleteSpecialCar(specialCarId);
        return ResultUtil.success(result);
    }
}
