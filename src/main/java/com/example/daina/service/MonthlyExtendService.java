package com.example.daina.service;

import com.example.daina.entity.MonthlyExtend;
import com.example.daina.mapper.MonthlyExtendMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
