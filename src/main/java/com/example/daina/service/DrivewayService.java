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

    public List<Driveway> getDrivewayList(String drivewayStatus, String dirvewayName) {
        List<Driveway> driveways = drivewayMapper.getDrivewayList(drivewayStatus, dirvewayName);
        return driveways;
    }
}
