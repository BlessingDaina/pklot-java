package com.example.daina.controller;

import com.example.daina.annotation.UserLoginToken;
import com.example.daina.entity.Result;
import com.example.daina.entity.Rule;
import com.example.daina.service.RuleService;
import com.example.daina.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: Daina
 * @description:
 * @date: Created in 16:34 2019/3/22
 */
@RestController
@RequestMapping(value = "/api/pklot")
public class RuleController {
    @Autowired
    RuleService ruleService;

    @UserLoginToken
    @RequestMapping(value = "/getChargeRuleList")
    public Result getChargeRuleList(@RequestParam("parkingLotId")String parkingLotId) {
        List<Rule> rules = ruleService.getChargeRuleList(parkingLotId);
        return ResultUtil.success(rules);
    }

    @UserLoginToken
    @RequestMapping(value = "/addChargeRule")
    public Result addChargeRule(Rule rule) {
        Integer result = ruleService.addChargeRule(rule);
        return ResultUtil.success(result);
    }
}
