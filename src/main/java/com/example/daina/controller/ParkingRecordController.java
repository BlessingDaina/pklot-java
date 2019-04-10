package com.example.daina.controller;

import com.example.daina.annotation.UserLoginToken;
import com.example.daina.entity.Page;
import com.example.daina.entity.Result;
import com.example.daina.service.ParkingRecordService;
import com.example.daina.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author: Daina
 * @description:
 * @date: Created in 10:47 2019/4/10
 */
@RestController
@RequestMapping(value = "/api/pklot")
public class ParkingRecordController {
    @Autowired
    ParkingRecordService parkingRecordService;

    @UserLoginToken
    @RequestMapping(value = "/getParkingRecordByPage")
    public Result getParkingRecordByPage(@RequestParam("pageNum") Integer pageNum,
                                         @RequestParam("pageSize") Integer pageSize,
                                         @RequestParam("parkingLotId")String parkingLotId,
                                         @RequestParam("carLicense")String carLicense,
                                         @RequestParam("startDate")String startDate,
                                         @RequestParam("endDate")String endDate,
                                         @RequestParam("searchType")String searchType,
                                         @RequestParam("status")Integer status) {
        Page<List<Map<String, Object>>> records = parkingRecordService.getParkingRecordByPage(pageNum,
                pageSize, parkingLotId, carLicense, startDate, endDate, status, searchType);
        return ResultUtil.success(records);
    }

    @UserLoginToken
    @RequestMapping(value = "/getParkingRecordInfo")
    public Result getParkingRecordInfo(@RequestParam("recordId")String recordId) {
        Map<String, Object> details = parkingRecordService.getParkingRecordInfo(recordId);
        return ResultUtil.success(details);
    }
}
