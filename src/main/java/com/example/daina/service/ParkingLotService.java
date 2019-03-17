package com.example.daina.service;

import com.example.daina.entity.Page;
import com.example.daina.entity.ParkingLot;
import com.example.daina.mapper.ParkingLotMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Daina
 * @description:
 * @date: Created in 13:22 2019/3/17
 */
@Service
public class ParkingLotService {
    @Autowired
    ParkingLotMapper parkingLotMapper;

    public Page<ParkingLot> getParkingLotByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<ParkingLot> parkingLots = parkingLotMapper.getParkingLotByPage();
        Integer count = parkingLotMapper.getParkingLotCount();
        Page<ParkingLot> pageData = new Page<>(pageNum, pageSize, count);
        pageData.setItems(parkingLots);
        return pageData;
    }
}
