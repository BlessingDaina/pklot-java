package com.example.daina.service;

import com.example.daina.entity.Report;
import com.example.daina.mapper.ReportRevenueMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author: Daina
 * @description:
 * @date: Created in 14:39 2019/4/10
 */
@Service
public class ReportRevenueService {
    @Autowired
    ReportRevenueMapper reportRevenueMapper;

    public List<Map<String, Object>> getReportRevenueList(String parkingLotId,
                                                          String startDate,
                                                          String endDate) {
        return reportRevenueMapper.getReportRevenueList(parkingLotId, startDate, endDate);
    }

    public Report getReportRevenueByDay(String parkingLotId,
                                        String toDay) {
        System.out.println("today"+toDay);
        return reportRevenueMapper.getReportRevenueByDay(parkingLotId, toDay);
    }
    public Integer getReportRevenueByDayCount(String parkingLotId,
                                              String toDay) {
        return reportRevenueMapper.getReportRevenueByDayCount(parkingLotId, toDay);
    }

    public Integer addReportRevenue(String parkingLotId,
                                    String reportdate,
                                    Integer monthlyAmount,
                                    Integer amountCount) {
        return reportRevenueMapper.addReportRevenue(parkingLotId, reportdate, monthlyAmount, amountCount);
    }

    public Integer updateReportRevenue(Integer dailyId,
                                       Integer monthlyAmount,
                                       Integer amountCount) {
        return reportRevenueMapper.updateReportRevenue(dailyId, monthlyAmount, amountCount);
    }
}
