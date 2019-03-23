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
@RequestMapping(value = "/api/pklot")
public class DrivewayController {
    @Autowired
    DrivewayService drivewayService;

    @UserLoginToken
    @RequestMapping(value = "/getDrivewayList")
    public Result getDrivewayList(@RequestParam("drivewayStatus")String drivewayStatus, @RequestParam("drivewayName")String drivewayName) {
        List<Driveway> driveways = drivewayService.getDrivewayList(drivewayStatus, drivewayName);
        return ResultUtil.success(driveways);
    }
}
