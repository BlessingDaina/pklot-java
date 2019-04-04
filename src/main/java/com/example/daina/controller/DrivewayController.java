package com.example.daina.controller;

import com.example.daina.annotation.UserLoginToken;
import com.example.daina.entity.Driveway;
import com.example.daina.entity.Result;
import com.example.daina.service.DrivewayService;
import com.example.daina.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: Daina
 * @description:
 * @date: Created in 15:02 2019/3/23
 */
@RestController
@RequestMapping(value = "/api")
public class DrivewayController {
    @Autowired
    DrivewayService drivewayService;

    @UserLoginToken
    @RequestMapping(value = "/pklot/getDrivewayList")
    public Result getDrivewayList(@RequestParam("parkingLotId")String parkingLotId,
                                  @RequestParam("drivewayName")String drivewayName) {
        List<Driveway> driveways = drivewayService.getDrivewayList(parkingLotId, drivewayName);
        return ResultUtil.success(driveways);
    }

    @UserLoginToken
    @RequestMapping(value = "/pklot/getDrivewayListByType")
    public Result getDrivewayListByType(@RequestParam("parkingLotId")String parkingLotId,
                                        @RequestParam("drivewayName")String drivewayName,
                                        @RequestParam("drivewayType")String drivewayType) {
        List<Driveway> driveways = drivewayService.getDrivewayListType(parkingLotId, drivewayName, drivewayType);
        return ResultUtil.success(driveways);
    }

    @UserLoginToken
    @RequestMapping(value = "/pklot/getDrivewayListByStatus")
    public Result getDrivewayListByStatus(@RequestParam("parkingLotId")String parkingLotId,
                                          @RequestParam("drivewayName")String drivewayName,
                                          @RequestParam("drivewayStatus")String drivewayStatus) {
        List<Driveway> driveways = drivewayService.getDrivewayListByStatus(parkingLotId, drivewayName, drivewayStatus);
        return ResultUtil.success(driveways);
    }

    @UserLoginToken
    @RequestMapping(value = "/pklot/getDrivewayInfo")
    public Result getDrivewayInfo(@RequestParam("drivewayId")String drivewayId) {
        Driveway driveway = drivewayService.getDrivewayInfo(drivewayId);
        return ResultUtil.success(driveway);
    }

    @UserLoginToken
    @RequestMapping(value = "/pklot/updateDriveway")
    public Result updateDriveway(Driveway driveway) {
        Integer result = drivewayService.updateDriveway(driveway);
        return ResultUtil.success(result);
    }

    @UserLoginToken
    @RequestMapping(value = "/pklot/updateDrivewayStatus")
    public Result updateDrivewayStatus(@RequestParam("drivewayId")String drivewayId,
                                       @RequestParam("drivewayStatus")Integer drivewayStatus) {
        Integer result = drivewayService.updateDrivewayStatus(drivewayId, drivewayStatus);
        return ResultUtil.success(result);
    }

    @UserLoginToken
    @RequestMapping(value = "/sentry/getDrivewayListByParkId")
    public Result getDrivewayListByParkId(@RequestParam("parkingLotId")String parkingLotId) {
        List<Driveway> driveways = drivewayService.getDrivewayListByParkId(parkingLotId);
        return ResultUtil.success(driveways);
    }
}
