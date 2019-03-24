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
    /**
     * 功能描述:
     * 〈获取价格规则列表〉
     * @param parkingLotId 1
     * @return : java.util.List<com.example.daina.entity.Rule>
     * @author : daina
     * @date : 2019/3/24 11:22
     */
    List<Rule> getChargeRuleList(@Param("parkingLotId") String parkingLotId);
    /**
     * 功能描述:
     * 〈添加规则〉
     * @param rule 1
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/24 11:22
     */
    Integer addChargeRule(Rule rule);
    /**
     * 功能描述:
     * 〈更新规则〉
     * @param rule 1
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/24 11:23
     */
    Integer updateChargeRule(Rule rule);
    /**
     * 功能描述:
     * 〈删除规则〉
     * @param ruleId 1
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/24 11:23
     */
    Integer deleteChargeRule(@Param("ruleId")String ruleId);
}
