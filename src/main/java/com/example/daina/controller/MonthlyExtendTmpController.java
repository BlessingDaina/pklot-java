package com.example.daina.controller;

import com.example.daina.annotation.UserLoginToken;
import com.example.daina.entity.*;
import com.example.daina.service.MonthlyCarTmpService;
import com.example.daina.utils.ResultUtil;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: Daina
 * @description:
 * @date: Created in 14:28 2019/3/27
 */
@RestController
@RequestMapping(value = "/api/pklot")
public class MonthlyExtendTmpController {
    @Autowired
    MonthlyCarTmpService monthlyCarTmpService;

    @UserLoginToken
    @RequestMapping(value = "/addMonthlyCarTmp")
    public Result addMonthlyCarTmp(TmpCar tmpCar) {
        monthlyCarTmpService.deleteAllMonthlyCarTmp();
        JSONArray tempcarList = JSONArray.fromObject(tmpCar.getCarInfoList());
        String guid = tmpCar.getGuid();
        List<MonthlyCarTmp> monthlyCarTmpList = (List<MonthlyCarTmp>) JSONArray.toCollection(tempcarList, MonthlyCarTmp.class);
        for (MonthlyCarTmp monthlyCarTmp : monthlyCarTmpList ) {
            monthlyCarTmp.setGuid(guid);
        }
        Integer result = monthlyCarTmpService.addMonthlyCarTmp(monthlyCarTmpList);
        return ResultUtil.success(result);
    }
}
