package com.example.daina.mapper;

import com.example.daina.entity.Rule;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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

    /**
     * 功能描述:
     * 〈根据ruleId查询规则〉
     * @param ruleId 1
     * @return : com.example.daina.entity.Rule
     * @author : daina
     * @date : 2019/4/8 9:52
     */
    Rule getRuleById (@Param("ruleId")String ruleId);

    /**
     * 功能描述:
     * 〈计费顺序最大值+1〉
     * @param parkingLotId 1
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/4/8 10:03
     */
    Integer getNextOrderLevel(@Param("parkingLotId")String parkingLotId);

    /**
     * 功能描述:
     * 〈获取小于当前项的第一条数据〉
     * @param parkingLotId 1
     * @param ruleId 2
     * @return : com.example.daina.entity.Rule
     * @author : daina
     * @date : 2019/4/8 10:22
     */
    Rule getLessOrderLevel(@Param("parkingLotId")String parkingLotId,
                                          @Param("ruleId")String ruleId);

    /**
     * 功能描述:
     * 〈获取大于当前项的第一条数据〉
     * @param parkingLotId 1
     * @param ruleId 2
     * @return : com.example.daina.entity.Rule
     * @author : daina
     * @date : 2019/4/8 10:35
     */
    Rule getGreaterOrderLevel(@Param("parkingLotId")String parkingLotId,
                              @Param("ruleId")String ruleId);
}
