package com.example.daina.controller;

import com.example.daina.annotation.UserLoginToken;
import com.example.daina.entity.MonthlyCar;
import com.example.daina.entity.MonthlyCarTmp;
import com.example.daina.entity.MonthlyExtend;
import com.example.daina.entity.Result;
import com.example.daina.service.MonthlyCarService;
import com.example.daina.service.MonthlyCarTmpService;
import com.example.daina.service.MonthlyExtendService;
import com.example.daina.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: Daina
 * @description:
 * @date: Created in 13:52 2019/3/27
 */
@RestController
@RequestMapping(value = "/api/pklot")
public class MonthlyExtendController {
    @Autowired
    MonthlyExtendService monthlyExtendService;
    @Autowired
    MonthlyCarService monthlyCarService;
    @Autowired
    MonthlyCarTmpService monthlyCarTmpService;

    @UserLoginToken
    @RequestMapping(value = "/addMonthlyExtend")
    public Result addMonthlyExtend(MonthlyExtend monthlyExtend) {
        Integer result = monthlyExtendService.addMonthlyExtend(monthlyExtend);
        String guid = monthlyExtend.getGuid();
        List<MonthlyCar> monthlyCarList;
        List<MonthlyCarTmp> monthlyCarTmpList;
        if (result != 0) {
            if (monthlyExtend.getExpdateType() == 0) {
                monthlyCarList = monthlyCarService.getMonthlyCarList(monthlyExtend.getMonthlyId());
                for (MonthlyCar monthlyCar : monthlyCarList) {
                    monthlyCar.setEndDate(monthlyExtend.getExpdateEnd());
                }
                monthlyCarService.updateMonthlyCarList(monthlyCarList);
            } else {
                monthlyCarTmpList = monthlyCarTmpService.getMonthlyCarTmpList(guid);
                monthlyCarList = monthlyCarService.getMonthlyCarList(monthlyExtend.getMonthlyId());
                for (MonthlyCarTmp monthlyCarTmp : monthlyCarTmpList) {
                    for (MonthlyCar monthlyCar : monthlyCarList) {
                        if (monthlyCar.getMonthlyCarId().equals(monthlyCarTmp.getMonthlyCarId())) {
                            monthlyCar.setEndDate(monthlyCarTmp.getEndDate());
                        }
                    }
                }
                monthlyCarService.updateMonthlyCarList(monthlyCarList);
                monthlyCarTmpService.deleteMonthlyCarTmp(guid);
            }
        }
        return ResultUtil.success(result);
    }
}
