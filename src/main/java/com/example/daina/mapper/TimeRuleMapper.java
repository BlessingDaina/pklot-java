package com.example.daina.mapper;

import com.example.daina.entity.TimeRule;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Daina
 * @description:
 * @date: Created in 10:12 2019/3/25
 */
@Repository
public interface TimeRuleMapper {
    /**
     * 功能描述:
     * 〈分页获取包月时间规则〉
     * @param parkingLotId 1
     * @param searchInfo 2
     * @return : java.util.List<com.example.daina.entity.TimeRule>
     * @author : daina
     * @date : 2019/3/25 10:36
     */
    List<TimeRule> getTimeRuleListByPage(@Param("parkingLotId") String parkingLotId,
                                         @Param("searchInfo") String searchInfo);
    /**
     * 功能描述:
     * 〈获取包月时间规则总数〉
     * @param parkingLotId 1
     * @param searchInfo 2
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/25 10:37
     */
    Integer getTimeRuleCount(@Param("parkingLotId") String parkingLotId,
                             @Param("searchInfo") String searchInfo);

    /**
     * 功能描述:
     * 〈添加包月时间规则〉
     * @param timeRule 1
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/25 11:10
     */
    Integer addTimeRule(TimeRule timeRule);

    /**
     * 功能描述:
     * 〈修改包月时间规则〉
     * @param timeRule 1
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/25 13:45
     */
    Integer updateTimeRule(TimeRule timeRule);

    /**
     * 功能描述:
     * 〈删除包月时间规则〉
     * @param timeRuleId 1
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/25 13:57
     */
    Integer deleteTimeRule(@Param("timeRuleId")String timeRuleId);

    /**
     * 功能描述:
     * 〈根据停车场获取包月时间规则〉
     * @param parkingLotId 1
     * @return : java.util.List<com.example.daina.entity.TimeRule>
     * @author : daina
     * @date : 2019/3/26 10:28
     */
    List<TimeRule> getTimeRuleList(@Param("parkingLotId")String parkingLotId);

    /**
     * 功能描述:
     * 〈通过id获取包月时间规则〉
     * @param timeRuleId 1
     * @return : com.example.daina.entity.TimeRule
     * @author : daina
     * @date : 2019/3/26 10:43
     */
    TimeRule getTimeRuleById(@Param("timeRuleId")String timeRuleId);
}
