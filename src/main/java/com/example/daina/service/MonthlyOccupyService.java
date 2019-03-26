package com.example.daina.service;

import com.example.daina.entity.MonthlyOccupy;
import com.example.daina.mapper.MonthlyOccupyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author: Daina
 * @description:
 * @date: Created in 11:16 2019/3/26
 */
@Service
public class MonthlyOccupyService {
    @Autowired
    MonthlyOccupyMapper monthlyOccupyMapper;

    public List<Map<String, Object>> getMonthlyOccupy(String parkingLotId, String monthlyId) {
        List<Map<String, Object>> monthlyOccupies;
        System.out.println(monthlyId);
        System.out.println(monthlyId.length() == 0);
        if (monthlyId == null || monthlyId.length() == 0) {
            monthlyOccupies = monthlyOccupyMapper.addGetMonthlyOccupy(parkingLotId);
        } else {
            monthlyOccupies = monthlyOccupyMapper.editGetMonthlyOccupy(parkingLotId, monthlyId);
        }
        return monthlyOccupies;
    }

    public Integer addMonthlyOccupy(List<MonthlyOccupy> monthlyOccupyList) {
        Integer result = monthlyOccupyMapper.addMonthlyOccupy(monthlyOccupyList);
        return result;
    }

    public List<MonthlyOccupy> getOccupyByMonthlyId(String monthlyId) {
        List<MonthlyOccupy> monthlyOccupies = monthlyOccupyMapper.getOccupyByMonthlyId(monthlyId);
        return monthlyOccupies;
    }

    public Integer deleteMonthlyOccupy(String monthlyId) {
        Integer result = monthlyOccupyMapper.deleteMonthlyOccupy(monthlyId);
        return result;
    }
}
