package com.example.daina.service;

import com.example.daina.entity.Driveway;
import com.example.daina.mapper.DrivewayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Daina
 * @description:
 * @date: Created in 15:00 2019/3/23
 */
@Service
public class DrivewayService {
    @Autowired
    DrivewayMapper drivewayMapper;

    public List<Driveway> getDrivewayList(String parkingLotId, String drivewayName) {
        List<Driveway> driveways = drivewayMapper.getDrivewayList(parkingLotId, drivewayName);
        return driveways;
    }

    public List<Driveway> getDrivewayListType(String parkingLotId, String drivewayName, String drivewayType) {
        List<Driveway> driveways = drivewayMapper.getDrivewayListByType(parkingLotId, drivewayName, drivewayType);
        return driveways;
    }

    public List<Driveway> getDrivewayListByStatus(String parkingLotId, String drivewayName, String drivewayStatus) {
        List<Driveway> driveways = drivewayMapper.getDrivewayListByStatus(parkingLotId, drivewayName, drivewayStatus);
        return driveways;
    }

    public Driveway getDrivewayInfo(String drivewayId) {
        Driveway driveway = drivewayMapper.getDrivewayInfo(drivewayId);
        return driveway;
    }

    public Integer updateDriveway(Driveway driveway) {
        Integer result = drivewayMapper.updateDriveway(driveway);
        return result;
    }

    public Integer updateDrivewayStatus(String drivewayId, Integer drivewayStatus) {
        Integer result = drivewayMapper.updateDrivewayStatus(drivewayId, drivewayStatus);
        return result;
    }
}
