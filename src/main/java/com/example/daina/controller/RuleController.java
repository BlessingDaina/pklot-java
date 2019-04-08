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
        Integer orderLevel = ruleService.getNextOrderLevel(rule.getParkingLotId());
        System.out.println(orderLevel);
        rule.setOrderLevel(orderLevel);
        Integer result = ruleService.addChargeRule(rule);
        return ResultUtil.success(result);
    }

    @UserLoginToken
    @RequestMapping(value = "/updateChargeRule")
    public Result updateChargeRule(Rule rule) {
        Integer result = ruleService.updateChargeRule(rule);
        return ResultUtil.success(result);
    }

    @UserLoginToken
    @RequestMapping(value = "/deleteChargeRule")
    public Result deleteChargeRule(@RequestParam("ruleId")String ruleId) {
        Integer result = ruleService.deleteChargeRule(ruleId);
        return ResultUtil.success(result);
    }

    @UserLoginToken
    @RequestMapping(value = "/updateChargeRuleOrderLevel")
    public Result updateChargeRuleOrderLevel(@RequestParam("parkingLotId")String parkingLotId,
                                             @RequestParam("ruleId")String ruleId,
                                             @RequestParam("direction")String direction) {
        Rule rule = ruleService.getRuleById(ruleId);
        Integer currentLevel = rule.getOrderLevel();
        if ("0".equals(direction)) {
            Rule less = ruleService.getLessOrderLevel(parkingLotId, ruleId);
            if (less == null) {
                return ResultUtil.error(500, "已经是最上级了");
            }
            Integer lessOrderLevel = less.getOrderLevel();
            rule.setOrderLevel(lessOrderLevel);
            ruleService.updateChargeRule(rule);
            less.setOrderLevel(currentLevel);
            ruleService.updateChargeRule(less);
        }
        if ("1".equals(direction)) {
            Rule greater = ruleService.getGreaterOrderLevel(parkingLotId, ruleId);
            if (greater == null) {
                return ResultUtil.error(500,"已经是最下级了");
            }
            Integer greaterOrderLevel = greater.getOrderLevel();
            rule.setOrderLevel(greaterOrderLevel);
            ruleService.updateChargeRule(rule);
            greater.setOrderLevel(currentLevel);
            ruleService.updateChargeRule(greater);
        }
        return ResultUtil.success();
    }
}
