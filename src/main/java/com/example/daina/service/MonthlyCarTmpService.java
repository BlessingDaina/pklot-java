package com.example.daina.service;

import com.example.daina.entity.MonthlyCarTmp;
import com.example.daina.mapper.MonthlyCarTmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Daina
 * @description:
 * @date: Created in 14:22 2019/3/27
 */
@Service
public class MonthlyCarTmpService {
    @Autowired
    MonthlyCarTmpMapper monthlyCarTmpMapper;

    public Integer addMonthlyCarTmp(List<MonthlyCarTmp> monthlyCarTmps) {
        Integer result = monthlyCarTmpMapper.addMonthlyCarTmp(monthlyCarTmps);
        return result;
    }

    public Integer deleteMonthlyCarTmp(String guid) {
        Integer result = monthlyCarTmpMapper.deleteMonthlyCarTmp(guid);
        return result;
    }

    public List<MonthlyCarTmp> getMonthlyCarTmpList(String guid) {
        List<MonthlyCarTmp> monthlyCarTmpList = monthlyCarTmpMapper.getMonthlyCarTmpList(guid);
        return monthlyCarTmpList;
    }

    public Integer deleteAllMonthlyCarTmp() {
        Integer result = monthlyCarTmpMapper.deleteAllMonthlyCarTmp();
        return result;
    }
}
