package com.example.daina.controller;

import com.example.daina.annotation.UserLoginToken;
import com.example.daina.entity.*;
import com.example.daina.service.MonthlyCarService;
import com.example.daina.service.MonthlyCarTmpService;
import com.example.daina.service.MonthlyExtendService;
import com.example.daina.service.ReportRevenueService;
import com.example.daina.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
    @Autowired
    ReportRevenueService reportRevenueService;

    @UserLoginToken
    @RequestMapping(value = "/addMonthlyExtend")
    public Result addMonthlyExtend(MonthlyExtend monthlyExtend) {
        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String extendDate = df.format(new Date());
        monthlyExtend.setExtendDate(extendDate);
        Integer result = monthlyExtendService.addMonthlyExtend(monthlyExtend);
        // 添加统计
        Integer reportTag = reportRevenueService.getReportRevenueByDayCount(monthlyExtend.getParkingLotId(), extendDate);
        System.out.println(reportTag);
        if (reportTag == 0) {
            System.out.println("id"+monthlyExtend.getParkingLotId());
            Integer addReport = reportRevenueService.addReportRevenue(monthlyExtend.getParkingLotId(), extendDate, monthlyExtend.getAmountCollected().intValue(), monthlyExtend.getAmountCollected().intValue());
        } else {
            Report day = reportRevenueService.getReportRevenueByDay(monthlyExtend.getParkingLotId(), extendDate);
            System.out.println("date"+day.getMonthlyAmount());
            Integer monthlyAmount = day.getMonthlyAmount() + monthlyExtend.getAmountCollected().intValue();
            Integer amountCount = day.getAmountCount() + monthlyExtend.getAmountCollected().intValue();
            Integer updateReport = reportRevenueService.updateReportRevenue(day.getDailyId(), monthlyAmount, amountCount);
        }
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

    @UserLoginToken
    @RequestMapping("/getMonthlyIncomeList")
    public Result getMonthlyIncomeList(@RequestParam("pageNum") Integer pageNum,
                                       @RequestParam("pageSize") Integer pageSize,
                                       @RequestParam("parkingLotId")String parkingLotId,
                                       @RequestParam("carLicense")String carLicense,
                                       @RequestParam("startDate")String startDate,
                                       @RequestParam("endDate")String endDate) {
        Page<List<Map<String, Object>>> monthlyIncomes = monthlyExtendService.getMonthlyIncomeList(pageNum,
                pageSize, parkingLotId, carLicense, startDate, endDate);
        return ResultUtil.success(monthlyIncomes);
    }
}
