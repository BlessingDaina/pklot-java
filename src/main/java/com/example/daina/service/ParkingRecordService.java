package com.example.daina.service;

import com.example.daina.entity.Page;
import com.example.daina.mapper.ParkingRecordMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author: Daina
 * @description:
 * @date: Created in 10:25 2019/4/10
 */
@Service
public class ParkingRecordService {
    @Autowired
    ParkingRecordMapper parkingRecordMapper;

    public Page<List<Map<String, Object>>> getParkingRecordByPage (Integer pageNum,
                                                                   Integer pageSize,
                                                                   String parkingLotId,
                                                                   String carLicense,
                                                                   String startDate,
                                                                   String endDate,
                                                                   Integer status,
                                                                   String searchType) {
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String, Object>> parkingRecords = parkingRecordMapper.getParkingRecordByPage(parkingLotId, carLicense,
                startDate, endDate, searchType, status);

        Integer count = parkingRecordMapper.getParkingRecordCount(parkingLotId, carLicense,
                startDate, endDate, searchType, status);
        Page<List<Map<String, Object>>> pageData = new Page<>(pageNum, pageSize, count);
        pageData.setRecordItems(parkingRecords);
        return pageData;
    }

    public Map<String, Object> getParkingRecordInfo(String recordId) {
        return parkingRecordMapper.getParkingRecordInfo(recordId);
    }
}
