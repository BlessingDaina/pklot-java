package com.example.daina.service;

import com.example.daina.entity.MonthlyExtend;
import com.example.daina.entity.Page;
import com.example.daina.mapper.MonthlyExtendMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author: Daina
 * @description:
 * @date: Created in 13:50 2019/3/27
 */
@Service
public class MonthlyExtendService {
    @Autowired
    MonthlyExtendMapper monthlyExtendMapper;

    public Integer addMonthlyExtend(MonthlyExtend monthlyExtend) {
        Integer result = monthlyExtendMapper.addMonthlyExtend(monthlyExtend);
        return result;
    }

    public Page<List<Map<String, Object>>> getMonthlyIncomeList (Integer pageNum,
                                                                 Integer pageSize,
                                                                 String parkingLotId,
                                                                 String carLicense,
                                                                 String startDate,
                                                                 String endDate) {
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String, Object>> monthlyIncomes = monthlyExtendMapper.getMonthlyIncomeList(parkingLotId,
                carLicense, startDate, endDate);
        Integer count = monthlyExtendMapper.getMonthlyIncomeCount(parkingLotId,
                carLicense, startDate, endDate);
        Page<List<Map<String, Object>>> pageData = new Page<>(pageNum, pageSize, count);
        pageData.setRecordItems(monthlyIncomes);
        return pageData;
    }
}
