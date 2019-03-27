package com.example.daina.mapper;

import com.example.daina.entity.MonthlyExtend;
import org.springframework.stereotype.Repository;

/**
 * @author: Daina
 * @description:
 * @date: Created in 11:46 2019/3/27
 */
@Repository
public interface MonthlyExtendMapper {

    /**
     * 功能描述:
     * 〈添加包月续费信息〉
     * @param monthlyExtend 1
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/27 13:50
     */
    Integer addMonthlyExtend(MonthlyExtend monthlyExtend);
}
