package com.example.daina.controller;

import com.example.daina.annotation.UserLoginToken;
import com.example.daina.entity.Page;
import com.example.daina.entity.ParkingLot;
import com.example.daina.entity.Result;
import com.example.daina.service.ParkingLotService;
import com.example.daina.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Daina
 * @description:
 * @date: Created in 12:26 2019/3/17
 */
@RestController
@RequestMapping(value = "/api/pklot")
public class ParkingLotController {
    @Autowired
    ParkingLotService parkingLotService;

    @UserLoginToken
    @RequestMapping(value = "getParkingLotList", method = RequestMethod.POST)
    public Result getParkingLotByPage(@RequestParam("pageNum")Integer pageNum, @RequestParam("pageSize")Integer pageSize) {
        Page<ParkingLot> parkingLots = parkingLotService.getParkingLotByPage(pageNum, pageSize);
        return ResultUtil.success(parkingLots);
    }
}
