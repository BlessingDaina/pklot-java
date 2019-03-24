package com.example.daina.service;

import com.example.daina.entity.Page;
import com.example.daina.entity.SpecialCar;
import com.example.daina.mapper.SpecialCarMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Daina
 * @description:
 * @date: Created in 13:29 2019/3/24
 */
@Service
public class SpecialCarService {
    @Autowired
    SpecialCarMapper specialCarMapper;

    public Page<SpecialCar> getSpecialCarListByPage(Integer pageNum, Integer pageSize,
                                                    Integer specialType, String parkingLotId, Integer status, String searchInfo) {
        PageHelper.startPage(pageNum, pageSize);
        List<SpecialCar> specialCars = specialCarMapper.getSpecialCarListByPage(specialType, parkingLotId,status, searchInfo);
        Integer count = specialCarMapper.getSpecialCarCount(specialType, parkingLotId,status, searchInfo);
        Page<SpecialCar> pageData = new Page<>(pageNum, pageSize, count);
        pageData.setItems(specialCars);
        return pageData;
    }

    public Integer addSpecialCar(SpecialCar specialCar) {
        Integer result = specialCarMapper.addSpecialCar(specialCar);
        return result;
    }

    public Integer getIsUsedCarLicense(String carLicense, String parkingLotId) {
        Integer result = specialCarMapper.getIsUsedCarLicense(carLicense, parkingLotId);
        return result;
    }

    public Integer updateSpecialCar(SpecialCar specialCar) {
        Integer result = specialCarMapper.updateSpecialCar(specialCar);
        return result;
    }

    public Integer deleteSpecialCar(String specialCarId) {
        Integer result = specialCarMapper.deleteSpecialCar(specialCarId);
        return result;
    }
}
