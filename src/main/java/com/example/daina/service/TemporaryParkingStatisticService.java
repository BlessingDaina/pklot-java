package com.example.daina.service;

import com.example.daina.entity.Page;
import com.example.daina.mapper.TemporaryParkingStatisticMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author: Daina
 * @description:
 * @date: Created in 15:44 2019/4/10
 */
@Service
public class TemporaryParkingStatisticService {
    @Autowired
    TemporaryParkingStatisticMapper temporaryParkingStatisticMapper;

    public Page<List<Map<String, Object>>> getTemporaryParkingDetailList(Integer pageNum,
                                                                         Integer pageSize,
                                                                         String parkingLotId,
                                                                         String startDate,
                                                                         String endDate,
                                                                         Integer freeType,
                                                                         String incomeName) {
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String, Object>> tempList = temporaryParkingStatisticMapper.getTemporaryParkingDetailList(parkingLotId,
                startDate, endDate, freeType, incomeName);
        Integer count = temporaryParkingStatisticMapper.getTemporaryParkingDetailCount(parkingLotId,
                startDate, endDate, freeType, incomeName);
        Page<List<Map<String, Object>>> pageData = new Page<>(pageNum, pageSize, count);
        pageData.setRecordItems(tempList);
        return pageData;
    }
}
