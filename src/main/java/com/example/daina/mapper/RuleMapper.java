package com.example.daina.mapper;

import com.example.daina.entity.Rule;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Daina
 * @description:
 * @date: Created in 16:02 2019/3/22
 */
@Repository
public interface RuleMapper {
    List<Rule> getChargeRuleList(@Param("parkingLotId") String parkingLotId);
    Integer addChargeRule(Rule rule);
}
