package com.example.daina.service;

import com.example.daina.entity.FallibleLicense;
import com.example.daina.entity.Page;
import com.example.daina.mapper.FallibleLicenseMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Daina
 * @description:
 * @date: Created in 14:20 2019/3/25
 */
@Service
public class FallibleLicenseService {
    @Autowired
    FallibleLicenseMapper fallibleLicenseMapper;

    public Page<FallibleLicense> getFallibleLicenseByPage(Integer pageNum, Integer pageSize,
                                                          String parkingLotId, String searchInfo) {
        PageHelper.startPage(pageNum, pageSize);
        List<FallibleLicense> fallibleLicenses = fallibleLicenseMapper.getFallibleLicenseByPage(parkingLotId, searchInfo);
        Integer count = fallibleLicenseMapper.getFallibleLicenseCount(parkingLotId, searchInfo);
        Page<FallibleLicense> pageData = new Page<>(pageNum, pageSize, count);
        pageData.setItems(fallibleLicenses);
        return pageData;
    }

    public Integer addFallibleLicense(FallibleLicense fallibleLicense) {
        Integer result = fallibleLicenseMapper.addFallibleLicense(fallibleLicense);
        return  result;
    }

    public Integer getIsUsedErrorLicense(String errorLicense, String parkingLotId) {
        Integer result = fallibleLicenseMapper.getIsUsedErrorLicense(errorLicense, parkingLotId);
        return result;
    }

    public Integer updateFallibleLicense(FallibleLicense fallibleLicense) {
        Integer result = fallibleLicenseMapper.updateFallibleLicense(fallibleLicense);
        return result;
    }

    public Integer deleteFallibleLicense(String fallibleId) {
        Integer result = fallibleLicenseMapper.deleteFallibleLicense(fallibleId);
        return result;
    }
}
