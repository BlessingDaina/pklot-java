package com.example.daina.service;

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
}
