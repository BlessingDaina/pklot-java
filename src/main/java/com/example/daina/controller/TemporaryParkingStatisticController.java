package com.example.daina.controller;

import com.example.daina.annotation.UserLoginToken;
import com.example.daina.entity.Page;
import com.example.daina.entity.Result;
import com.example.daina.service.TemporaryParkingStatisticService;
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
 * @date: Created in 15:56 2019/4/10
 */
@RestController
@RequestMapping(value = "/api/rpt")
public class TemporaryParkingStatisticController {
    @Autowired
    TemporaryParkingStatisticService temporaryParkingStatisticService;

    @UserLoginToken
    @RequestMapping(value = "/getTemporaryParkingDetailList")
    public Result getTemporaryParkingDetailList(@RequestParam("pageNum") Integer pageNum,
                                                @RequestParam("pageSize") Integer pageSize,
                                                @RequestParam("parkingLotId")String parkingLotId,
                                                @RequestParam("startDate")String startDate,
                                                @RequestParam("endDate")String endDate,
                                                @RequestParam("freeType")Integer freeType,
                                                @RequestParam("incomeName")String incomeName) {
        Page<List<Map<String, Object>>> tempList = temporaryParkingStatisticService.getTemporaryParkingDetailList(pageNum,
                pageSize, parkingLotId, startDate, endDate, freeType, incomeName);
        return ResultUtil.success(tempList);
    }
}
