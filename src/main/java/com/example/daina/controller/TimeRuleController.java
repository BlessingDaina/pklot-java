package com.example.daina.controller;

import com.example.daina.annotation.UserLoginToken;
import com.example.daina.entity.Page;
import com.example.daina.entity.Result;
import com.example.daina.entity.TimeRule;
import com.example.daina.service.TimeRuleService;
import com.example.daina.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Daina
 * @description:
 * @date: Created in 10:39 2019/3/25
 */
@RestController
@RequestMapping(value = "/api/pklot")
public class TimeRuleController {
    @Autowired
    TimeRuleService timeRuleService;

    @UserLoginToken
    @RequestMapping(value = "/getTimeRuleListByPage")
    public Result getTimeRuleListByPage(@RequestParam("pageNum") Integer pageNum,
                                        @RequestParam("pageSize") Integer pageSize,
                                        @RequestParam("parkingLotId") String parkingLotId,
                                        @RequestParam("searchInfo") String searchInfo) {
        Page<TimeRule> timeRulePage = timeRuleService.getTimeRuleListByPage(pageNum, pageSize, parkingLotId, searchInfo);
        return ResultUtil.success(timeRulePage);
    }

    @UserLoginToken
    @RequestMapping(value = "/addTimeRule")
    public Result addTimeRule(TimeRule timeRule) {
        Integer result = timeRuleService.addTimeRule(timeRule);
        return ResultUtil.success(result);
    }

    @UserLoginToken
    @RequestMapping(value = "/updateTimeRule")
    public Result updateTimeRule(TimeRule timeRule) {
        Integer result = timeRuleService.updateTimeRule(timeRule);
        return ResultUtil.success(result);
    }

    @UserLoginToken
    @RequestMapping(value = "/deleteTimeRule")
    public Result deleteTimeRule(@RequestParam("timeRuleId")String timeRuleId) {
        Integer result = timeRuleService.deleteTimeRule(timeRuleId);
        return ResultUtil.success(result);
    }
}
