package com.example.daina.controller;

import com.example.daina.annotation.UserLoginToken;
import com.example.daina.entity.Monthly;
import com.example.daina.entity.MonthlyOccupy;
import com.example.daina.entity.Page;
import com.example.daina.entity.Result;
import com.example.daina.service.MonthlyOccupyService;
import com.example.daina.service.MonthlyService;
import com.example.daina.utils.ResultUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: Daina
 * @description:
 * @date: Created in 10:01 2019/3/26
 */
@RestController
@RequestMapping(value = "/api/pklot")
public class MonthlyController {
    @Autowired
    MonthlyService monthlyService;
    @Autowired
    MonthlyOccupyService monthlyOccupyService;

    @UserLoginToken
    @RequestMapping(value = "/getMonthlyListByPage")
    public Result getMonthlyListByPage(@RequestParam("pageNum") Integer pageNum,
                                       @RequestParam("pageSize") Integer pageSize,
                                       @RequestParam("parkingLotId") String parkingLotId,
                                       @RequestParam("searchInfo") String searchInfo) {
        Page<Monthly> monthlyPage = monthlyService.getMonthlyListByPage(pageNum, pageSize, parkingLotId, searchInfo);
        return ResultUtil.success(monthlyPage);
    }

    @UserLoginToken
    @RequestMapping(value = "/addMonthlyAndOccupy")
    public Result addMonthlyAndOccupy(Monthly monthly) {
        Monthly setOccupyNum = new Monthly();
        List<MonthlyOccupy> occupyNums;
        String monthlyId = monthlyService.addMonthly(monthly);
        String parkingLotId = monthly.getParkingLotId();
        JSONArray occupyArray = JSONArray.fromObject(monthly.getOccupyList());
        List<MonthlyOccupy> monthlyOccupies = (List<MonthlyOccupy>) JSONArray.toCollection(occupyArray, MonthlyOccupy.class);
        System.out.println(monthly);
        System.out.println(monthlyOccupies);
        for (MonthlyOccupy monthlyOccupy : monthlyOccupies) {
            System.out.println(monthlyOccupy);
            monthlyOccupy.setMonthlyId(monthlyId);
            monthlyOccupy.setParkingLotId(parkingLotId);
        }
        Integer addTag = monthlyOccupyService.addMonthlyOccupy(monthlyOccupies);
        if (addTag != 0) {
            Integer occupyNum = 0;
            occupyNums = monthlyOccupyService.getOccupyByMonthlyId(monthlyId);
            for (MonthlyOccupy monthlyOccupy : occupyNums) {
                occupyNum += monthlyOccupy.getOccupyNum();
            }
            setOccupyNum.setOccupyNum(occupyNum);
            setOccupyNum.setMonthlyId(monthlyId);
            monthlyService.updateOccupyNum(setOccupyNum);
            return ResultUtil.success("true");
        } else {
            return ResultUtil.error(500, "添加失败");
        }
    }

    @UserLoginToken
    @RequestMapping(value = "/deleteMonthly")
    public Result deleteMonthly(@RequestParam("monthlyId")String monthlyId) {
        Integer result = monthlyService.deleteMonthly(monthlyId);
        if (result != 0) {
            monthlyOccupyService.deleteMonthlyOccupy(monthlyId);
            return ResultUtil.success(result);
        } else {
            return ResultUtil.error(500, "删除失败");
        }
    }
}
