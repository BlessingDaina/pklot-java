package com.example.daina.controller;

import com.example.daina.annotation.UserLoginToken;
import com.example.daina.entity.Driveway;
import com.example.daina.entity.Result;
import com.example.daina.entity.SentryBox;
import com.example.daina.service.DrivewayService;
import com.example.daina.service.SentryBoxService;
import com.example.daina.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: Daina
 * @description:
 * @date: Created in 10:37 2019/4/1
 */
@RestController
@RequestMapping(value = "/api")
public class SentryBoxController {
    @Autowired
    SentryBoxService sentryBoxService;
    @Autowired
    DrivewayService drivewayService;

    @UserLoginToken
    @RequestMapping(value = "/sentry/getSentry")
    public Result getSentry(@RequestParam("parkingLotId")String parkingLotId) {
        List<SentryBox> sentryBoxes = sentryBoxService.getSentry(parkingLotId);
        for (SentryBox sentryBox: sentryBoxes) {
            List<Driveway> driveways = drivewayService.getDrivewayListByParkId(parkingLotId);
//            String passageway = sentryBox.getPassagewayId();
//            String[] drivewayListId = passageway.split(",");
//            for (int i = 0; i < drivewayListId.length; i++) {
//                Driveway driveway = drivewayService.getDrivewayInfo(drivewayListId[i]);
//                driveways.add(driveway);
//            }
            sentryBox.setDriveways(driveways);
        }
        return ResultUtil.success(sentryBoxes);
    }
}
