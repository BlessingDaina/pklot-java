package com.example.daina.service;

import com.example.daina.entity.Monthly;
import com.example.daina.entity.Page;
import com.example.daina.mapper.MonthlyMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author: Daina
 * @description:
 * @date: Created in 9:56 2019/3/26
 */
@Service
public class MonthlyService {
    @Autowired
    MonthlyMapper monthlyMapper;

    public Page<Monthly> getMonthlyListByPage(Integer pageNum,
                                              Integer pageSize,
                                              String parkingLotId,
                                              String searchInfo,
                                              String monthlyType) {
        List<Monthly> monthlies;
        PageHelper.startPage(pageNum, pageSize);
        if ("-1".equals(monthlyType)) {
            monthlies = monthlyMapper.getMonthlyListByPage(parkingLotId, searchInfo);
        } else {
            monthlies = monthlyMapper.getMonthlyListByPageByType(parkingLotId, searchInfo, monthlyType);
        }
        Integer count = monthlyMapper.getMonthlyCount(parkingLotId, searchInfo);
        Page<Monthly> pageData = new Page<>(pageNum, pageSize, count);
        pageData.setItems(monthlies);
        return pageData;
    }

    public String addMonthly(Monthly monthly) {
        Integer result = monthlyMapper.addMonthly(monthly);
        String monthlyId = monthly.getMonthlyId();
        return monthlyId;
    }

    public Integer updateOccupyNum(Monthly monthly) {
        Integer result = monthlyMapper.updateOccupyNum(monthly);
        return result;
    }

    public Integer deleteMonthly(String monthlyId) {
        Integer result = monthlyMapper.deleteMonthly(monthlyId);
        return result;
    }

    public Monthly getMonthlyById(String monthlyId) {
        Monthly monthly = monthlyMapper.getMonthlyById(monthlyId);
        return monthly;
    }

    public Integer updateMonthly(Monthly monthly) {
        Integer result = monthlyMapper.updateMonthly(monthly);
        return result;
    }

    public List<Map<String,Object>> isExistOwnerName(Map<String,Object> params) {
        return monthlyMapper.isExistOwnerName(params);
    }

    public List<Map<String, Object>> listAllParkingLotId(Map<String, Object> params) {
        return monthlyMapper.listAllParkingLotId(params);
    }

    public Map<String,Object> isExistParkingLotId(Map<String,Object> params){
        return monthlyMapper.isExistParkingLotId(params);
    }

    public void updateParkMonthlyOccupyFromExcel(Map<String,Object> params){
        monthlyMapper.updateParkMonthlyOccupyFromExcel(params);
    }
    public Integer saveParkMonthlyOccupyFromExcel(Map<String,Object> params){
        System.out.println("oo"+params.get("occupyNum"));
        return monthlyMapper.saveParkMonthlyOccupyFromExcel(params);
    }

    public Map<String,Object> isExistCarLicense(Map<String,Object> params){
        return monthlyMapper.isExistCarLicense(params);
    }

    public void updateParkMonthlyCarFromExcel(Map<String,Object> params){
        monthlyMapper.updateParkMonthlyCarFromExcel(params);
    }

    public void saveParkMonthlyCarFromExcel(Map<String,Object> params){
        monthlyMapper.saveParkMonthlyCarFromExcel(params);
    }

    public void updateParkMonthlyFromExcel(Map<String,Object> params){
        monthlyMapper.updateParkMonthlyFromExcel(params);
    }

    public void saveParkMonthlyFromExcel(Map<String,Object> params){
        monthlyMapper.saveParkMonthlyFromExcel(params);
    }

    public List<Map<String,Object>> exportParkMonthly(Map<String,Object> params){
        return monthlyMapper.exportParkMonthly(params);
    }
}
