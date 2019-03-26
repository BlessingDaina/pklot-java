package com.example.daina.controller;

import com.example.daina.annotation.UserLoginToken;
import com.example.daina.entity.MonthlyOccupy;
import com.example.daina.entity.Result;
import com.example.daina.service.MonthlyOccupyService;
import com.example.daina.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author: Daina
 * @description:
 * @date: Created in 11:34 2019/3/26
 */
@RestController
@RequestMapping(value = "/api/pklot")
public class MonthlyOccupyController {
    @Autowired
    MonthlyOccupyService monthlyOccupyService;

    @UserLoginToken
    @RequestMapping(value = "/getMonthlyOccupy")
    public Result getMonthlyOccupy(@RequestParam("parkingLotId")String parkingLotId,
                                   @RequestParam("monthlyId")String monthlyId) {
        List<Map<String, Object>> monthlyOccupies = monthlyOccupyService.getMonthlyOccupy(parkingLotId, monthlyId);
        return ResultUtil.success(monthlyOccupies);
    }
}
