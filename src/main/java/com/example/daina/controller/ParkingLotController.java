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

import java.util.List;

/**
 * @author: Daina
 * @description:
 * @date: Created in 12:26 2019/3/17
 */
@RestController
@RequestMapping(value = "/api")
public class ParkingLotController {
    @Autowired
    ParkingLotService parkingLotService;

    @UserLoginToken
    @RequestMapping(value = "/pklot/getParkingLotList", method = RequestMethod.POST)
    public Result getParkingLotByPage(@RequestParam("pageNum")Integer pageNum, @RequestParam("pageSize")Integer pageSize, @RequestParam("parkingLotName")String parkingLotName) {
        Page<ParkingLot> parkingLots = parkingLotService.getParkingLotByPage(pageNum, pageSize, parkingLotName);
        return ResultUtil.success(parkingLots);
    }

    @UserLoginToken
    @RequestMapping(value = "/pklot/getParkingLotInfo", method = RequestMethod.POST)
    public Result getParkingLotInfo(@RequestParam("parkingLotId")String parkingLotId) {
        ParkingLot parkingLot = parkingLotService.getParkingLotInfo(parkingLotId);
        return ResultUtil.success(parkingLot);
    }

    @UserLoginToken
    @RequestMapping(value = "/pklot/getNestParkingLot", method = RequestMethod.POST)
    public Result getNestParkingLot(@RequestParam("parkingLotId")String parkingLotId) {
        List<ParkingLot> parkingLots = parkingLotService.getNestParkingLot(parkingLotId);
        return ResultUtil.success(parkingLots);
    }

    @UserLoginToken
    @RequestMapping(value = "/pklot/updateManagement", method = RequestMethod.POST)
    public Result updateManagement(@RequestParam("key")String key,@RequestParam("value")String value,@RequestParam("parkingLotId")String parkingLotId) {
        Integer result = parkingLotService.updateManagement(key, value, parkingLotId);
        return ResultUtil.success(result);
    }

    @UserLoginToken
    @RequestMapping(value = "/sentry/getParkingLotByUnitId")
    public Result getParkingLotByUnitId(@RequestParam("unitId")String unitId) {
        List<ParkingLot> parkingLots = parkingLotService.getParkingLotByUnitId(unitId);
        return ResultUtil.success(parkingLots);
    }
}
