package com.example.daina.service;

import com.example.daina.entity.Page;
import com.example.daina.entity.TempCar;
import com.example.daina.mapper.TempCarMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Daina
 * @description:
 * @date: Created in 15:34 2019/3/25
 */
@Service
public class TempCarService {
    @Autowired
    TempCarMapper tempCarMapper;

    public Page<TempCar> getTempCarListByPage(Integer pageNum, Integer pageSize,
                                              String parkingLotId, String categoryId, String searchInfo) {
        String tag = new String("all");
        PageHelper.startPage(pageNum, pageSize);
        List<TempCar> tempCars;
        Integer count;
        if (categoryId.equals(tag)) {
            tempCars = tempCarMapper.getAllTempCarList(parkingLotId, searchInfo);
            count = tempCarMapper.getAllTempCarCount(parkingLotId, searchInfo);
        } else {
            tempCars = tempCarMapper.getTempCarListByCategoryId(parkingLotId, searchInfo, categoryId);
            count = tempCarMapper.getTempCarCountByCategoryId(parkingLotId, searchInfo, categoryId);
        }
        Page<TempCar> tempCarPage = new Page<>(pageNum, pageSize, count);
        tempCarPage.setItems(tempCars);
        return tempCarPage;
    }

    public Integer addTempCar(TempCar tempCar) {
        Integer result = tempCarMapper.addTempCar(tempCar);
        return result;
    }

    public Integer getIsUsedTempCar(String carLicense, String parkingLotId) {
        Integer result = tempCarMapper.getIsUsedTempCar(carLicense, parkingLotId);
        return result;
    }

    public Integer updateTempCar(TempCar tempCar) {
        Integer result = tempCarMapper.updateTempCar(tempCar);
        return result;
    }

    public Integer deleteTempCar(String tempCarId) {
        Integer result = tempCarMapper.deleteTempCar(tempCarId);
        return result;
    }
}
