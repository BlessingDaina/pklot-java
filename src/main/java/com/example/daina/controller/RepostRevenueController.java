package com.example.daina.controller;

import com.example.daina.annotation.UserLoginToken;
import com.example.daina.entity.Result;
import com.example.daina.service.ReportRevenueService;
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
 * @date: Created in 14:41 2019/4/10
 */
@RestController
@RequestMapping(value = "/api/rpt")
public class RepostRevenueController {
    @Autowired
    ReportRevenueService reportRevenueService;

    @UserLoginToken
    @RequestMapping(value = "/getReportRevenueList")
    public Result getReportRevenueList(@RequestParam("parkingLotId")String parkingLotId,
                                       @RequestParam("startDate")String startDate,
                                       @RequestParam("endDate")String endDate) {
        List<Map<String, Object>> reports = reportRevenueService.getReportRevenueList(parkingLotId, startDate, endDate);
        return ResultUtil.success(reports);
    }
}
