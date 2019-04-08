package com.example.daina.service;

import com.example.daina.entity.MonthlyCar;
import com.example.daina.entity.Page;
import com.example.daina.mapper.MonthlyCarMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author: Daina
 * @description:
 * @date: Created in 17:06 2019/3/26
 */
@Service
public class MonthlyCarService {
    @Autowired
    MonthlyCarMapper monthlyCarMapper;

    public Page<MonthlyCar> getMonthlyCarListByPage(Integer pageNum,
                                                    Integer pageSize,
                                                    String monthlyId,
                                                    String searchInfo) {
        PageHelper.startPage(pageNum, pageSize);
        List<MonthlyCar> monthlyCars = monthlyCarMapper.getMonthlyCarListByPage(monthlyId, searchInfo);
        Integer count = monthlyCarMapper.getMonthlyCarCount(monthlyId, searchInfo);
        Page<MonthlyCar> pageData = new Page<>(pageNum, pageSize, count);
        pageData.setItems(monthlyCars);
        return pageData;
    }

    public Integer addMonthlyCar(MonthlyCar monthlyCar) {
        Integer result = monthlyCarMapper.addMonthlyCar(monthlyCar);
        return result;
    }

    public Integer updateMonthlyCar(MonthlyCar monthlyCar) {
        Integer result = monthlyCarMapper.updateMonthlyCar(monthlyCar);
        return result;
    }

    public Integer getIsUsedMonthlyCarLicense(String parkingLotId, String carLicense) {
        Integer result = monthlyCarMapper.getIsUsedMonthlyCarLicense(parkingLotId, carLicense);
        return result;
    }

    public Integer deleteMonthlyCar(String monthlyCarId) {
        Integer result = monthlyCarMapper.deleteMonthlyCarById(monthlyCarId);
        return result;
    }

    public Integer deleteMonthlyCarByMonthlyId(String monthlyId) {
        Integer result = monthlyCarMapper.deleteMonthlyCarByMonthlyId(monthlyId);
        return result;
    }

    public List<MonthlyCar> getMonthlyCarList(String monthlyId) {
        List<MonthlyCar> monthlyCars= monthlyCarMapper.getMonthlyCarList(monthlyId);
        return monthlyCars;
    }

    public Integer updateMonthlyCarList(List<MonthlyCar> monthlyCarList) {
        Integer result = monthlyCarMapper.updateMonthlyCarList(monthlyCarList);
        return result;
    }

    public String getCarLicense(Map<String,Object> params){
        return monthlyCarMapper.getCarLicense(params);
    }

    public void updateParkMonthlyList(Map<String,Object> params) {
        monthlyCarMapper.updateParkMonthlyList(params);
    }
}
