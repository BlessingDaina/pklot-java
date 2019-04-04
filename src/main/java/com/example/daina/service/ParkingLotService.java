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

    public Page<ParkingLot> getParkingLotByPage(Integer pageNum, Integer pageSize, String parkingLotName) {
        PageHelper.startPage(pageNum, pageSize);
        List<ParkingLot> parkingLots = parkingLotMapper.getParkingLotByPage(parkingLotName);
        Integer count = parkingLotMapper.getParkingLotCount();
        Page<ParkingLot> pageData = new Page<>(pageNum, pageSize, count);
        pageData.setItems(parkingLots);
        return pageData;
    }

    public ParkingLot getParkingLotInfo(String parkingLotId) {
        ParkingLot parkingLot = parkingLotMapper.getParkingLotInfo(parkingLotId);
        return parkingLot;
    }

    public List<ParkingLot> getNestParkingLot(String parkingLotId) {
        List<ParkingLot> parkingLots = parkingLotMapper.getNestParkingLot(parkingLotId);
        return parkingLots;
    }

    public Integer updateManagement(String key, String value, String parkingLotId) {
        Integer result = parkingLotMapper.updateManagement(key, value, parkingLotId);
        return result;
    }

    public List<ParkingLot> getParkingLotByUnitId(String unitId) {
        List<ParkingLot> parkingLots = parkingLotMapper.getParkingLotByUnitId(unitId);
        return parkingLots;
    }
}
