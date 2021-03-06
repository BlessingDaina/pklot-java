package com.example.daina.controller;

import com.example.daina.annotation.UserLoginToken;
import com.example.daina.entity.Monthly;
import com.example.daina.entity.MonthlyCar;
import com.example.daina.entity.Page;
import com.example.daina.entity.Result;
import com.example.daina.service.MonthlyCarService;
import com.example.daina.service.MonthlyService;
import com.example.daina.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: Daina
 * @description:
 * @date: Created in 17:11 2019/3/26
 */
@RestController
@RequestMapping(value = "/api/pklot")
public class MonthlyCarController {
    @Autowired
    MonthlyCarService monthlyCarService;
    @Autowired
    MonthlyService monthlyService;

    @UserLoginToken
    @RequestMapping(value = "/getMonthlyCarListByPage")
    public Result getMonthlyCarListByPage(@RequestParam("pageNum") Integer pageNum,
                                          @RequestParam("pageSize") Integer pageSize,
                                          @RequestParam("monthlyId") String monthlyId,
                                          @RequestParam("searchInfo") String searchInfo) {
        Page<MonthlyCar> monthlyCarPage = monthlyCarService.getMonthlyCarListByPage(pageNum,
                pageSize, monthlyId, searchInfo);
        return ResultUtil.success(monthlyCarPage);
    }

    @UserLoginToken
    @RequestMapping(value = "/addMonthlyCar")
    public Result addMonthlyCar(MonthlyCar monthlyCar) {
        Monthly monthly = monthlyService.getMonthlyById(monthlyCar.getMonthlyId());
        String carLicense = monthly.getCarLicense();
        Integer result = monthlyCarService.addMonthlyCar(monthlyCar);
        if (result != 0) {
            if (carLicense == null || carLicense.length() == 0) {
                carLicense = monthlyCar.getCarLicense();
            } else {
                carLicense +=',' + monthlyCar.getCarLicense();
            }
            monthly.setCarLicense(carLicense);
            Integer updateMonthly = monthlyService.updateMonthly(monthly);
            return ResultUtil.success(result);
        } else {
            return ResultUtil.error(500, "添加失败");
        }
    }

    @UserLoginToken
    @RequestMapping(value = "/updateMonthlyCar")
    public Result updateMonthlyCar(MonthlyCar monthlyCar) {
        Integer result = monthlyCarService.updateMonthlyCar(monthlyCar);
        List<MonthlyCar> monthlyCars = monthlyCarService.getMonthlyCarList(monthlyCar.getMonthlyId());
        String carLicense = new String();
        Monthly monthly = monthlyService.getMonthlyById(monthlyCar.getMonthlyId());
        for (MonthlyCar monthlyCar1 : monthlyCars) {
            if (carLicense == null || carLicense.length() == 0) {
                carLicense = monthlyCar1.getCarLicense();
            } else {
                carLicense += ',' + monthlyCar1.getCarLicense();
            }
        }
        monthly.setCarLicense(carLicense);
        monthlyService.updateMonthly(monthly);
        return ResultUtil.success(result);
    }

    @UserLoginToken
    @RequestMapping(value = "/getIsUsedMonthlyCarLicense")
    public Result getIsUsedMonthlyCarLicense(@RequestParam("parkingLotId")String parkingLotId,
                                             @RequestParam("carLicense")String carLicense) {
        Integer result = monthlyCarService.getIsUsedMonthlyCarLicense(parkingLotId, carLicense);
        return ResultUtil.success(result);
    }

    @UserLoginToken
    @RequestMapping(value = "/deleteMonthlyCar")
    public Result deleteMonthlyCar(@RequestParam("monthlyCarId")String monthlyCarId) {
        Integer result = monthlyCarService.deleteMonthlyCar(monthlyCarId);
        return ResultUtil.success(result);
    }

    @UserLoginToken
    @RequestMapping(value = "/getMonthlyCarList")
    public Result getMonthlyCarList(@RequestParam("monthlyId")String monthlyId) {
        List<MonthlyCar> monthlyCars = monthlyCarService.getMonthlyCarList(monthlyId);
        return ResultUtil.success(monthlyCars);
    }
}
