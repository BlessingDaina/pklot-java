package com.example.daina.service;

import com.example.daina.entity.Monthly;
import com.example.daina.entity.Page;
import com.example.daina.entity.TimeRule;
import com.example.daina.mapper.TimeRuleMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Daina
 * @description:
 * @date: Created in 10:33 2019/3/25
 */
@Service
public class TimeRuleService {
    @Autowired
    TimeRuleMapper timeRuleMapper;

    public Page<TimeRule> getTimeRuleListByPage(Integer pageNum, Integer pageSize, String parkingLotId, String searchInfo) {
        PageHelper.startPage(pageNum, pageSize);
        List<TimeRule> timeRules = timeRuleMapper.getTimeRuleListByPage(parkingLotId, searchInfo);
        Integer count = timeRuleMapper.getTimeRuleCount(parkingLotId, searchInfo);
        Page<TimeRule> pageData = new Page<>(pageNum, pageSize, count);
        pageData.setItems(timeRules);
        return pageData;
    }

    public Integer addTimeRule (TimeRule timeRule) {
        Integer result = timeRuleMapper.addTimeRule(timeRule);
        return result;
    }

    public Integer updateTimeRule (TimeRule timeRule) {
        Integer result = timeRuleMapper.updateTimeRule(timeRule);
        return result;
    }

    public Integer deleteTimeRule(String timeRuleId) {
        Integer result = timeRuleMapper.deleteTimeRule(timeRuleId);
        return result;
    }

    public List<TimeRule> getTimeRuleList(String parkingLotId) {
        List<TimeRule> timeRules = timeRuleMapper.getTimeRuleList(parkingLotId);
        return timeRules;
    }

    public TimeRule getTimeRuleById(String timeRuleId) {
        TimeRule timeRule = timeRuleMapper.getTimeRuleById(timeRuleId);
        return timeRule;
    }
}
