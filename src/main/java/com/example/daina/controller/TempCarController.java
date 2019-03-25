package com.example.daina.controller;

import com.example.daina.annotation.UserLoginToken;
import com.example.daina.entity.Page;
import com.example.daina.entity.Result;
import com.example.daina.entity.TempCar;
import com.example.daina.service.TempCarService;
import com.example.daina.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Daina
 * @description:
 * @date: Created in 16:06 2019/3/25
 */
@RestController
@RequestMapping(value = "/api/pklot")
public class TempCarController {
    @Autowired
    TempCarService tempCarService;

    @UserLoginToken
    @RequestMapping("/getTempCarListByPage")
    public Result getTempCarListByPage(@RequestParam("pageNum") Integer pageNum,
                                       @RequestParam("pageSize") Integer pageSize,
                                       @RequestParam("parkingLotId") String parkingLotId,
                                       @RequestParam("categoryId") String categoryId,
                                       @RequestParam("searchInfo") String searchInfo) {
        Page<TempCar> tempCarPage = tempCarService.getTempCarListByPage(pageNum, pageSize, parkingLotId, categoryId, searchInfo);
        return ResultUtil.success(tempCarPage);
    }

    @UserLoginToken
    @RequestMapping("/addTempCar")
    public Result addTempCar(TempCar tempCar) {
        Integer result = tempCarService.addTempCar(tempCar);
        return ResultUtil.success(result);
    }

    @UserLoginToken
    @RequestMapping("/getIsUsedTempCar")
    public Result getIsUsedTempCar(@RequestParam("carLicense")String carLicense,
                                   @RequestParam("parkingLotId")String parkingLotId) {
        Integer result = tempCarService.getIsUsedTempCar(carLicense, parkingLotId);
        return ResultUtil.success(result);
    }

    @UserLoginToken
    @RequestMapping("/updateTempCar")
    public Result updateTempCar(TempCar tempCar) {
        Integer result = tempCarService.updateTempCar(tempCar);
        return ResultUtil.success(result);
    }

    @UserLoginToken
    @RequestMapping("/deleteTempCar")
    public Result deleteTempCar(@RequestParam("tempCarId")String tempCarId) {
        Integer result = tempCarService.deleteTempCar(tempCarId);
        return ResultUtil.success(result);
    }
}
