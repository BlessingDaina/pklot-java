package com.example.daina.service;

import com.example.daina.entity.Rule;
import com.example.daina.mapper.RuleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Daina
 * @description:
 * @date: Created in 16:33 2019/3/22
 */
@Service
public class RuleService {
    @Autowired
    RuleMapper ruleMapper;

    public List<Rule> getChargeRuleList(String parkingLotId) {
        List<Rule> rules = ruleMapper.getChargeRuleList(parkingLotId);
        return rules;
    }

    public Integer addChargeRule(Rule rule) {
        return ruleMapper.addChargeRule(rule);
    }

    public Integer updateChargeRule(Rule rule) {
        return ruleMapper.updateChargeRule(rule);
    }

    public Integer deleteChargeRule(String ruleId) {
        return ruleMapper.deleteChargeRule(ruleId);
    }

    public Rule getRuleById(String ruleId) {
        return ruleMapper.getRuleById(ruleId);
    }

    public Integer getNextOrderLevel(String parkingLotId) {
        return ruleMapper.getNextOrderLevel(parkingLotId);
    }

    public Rule getLessOrderLevel(String parkingLotId,
                                  String ruleId) {
        return ruleMapper.getLessOrderLevel(parkingLotId, ruleId);
    }

    public Rule getGreaterOrderLevel(String parkingLotId,
                                     String ruleId) {
        return ruleMapper.getGreaterOrderLevel(parkingLotId, ruleId);
    }
}
