package com.example.daina.mapper;

import com.example.daina.entity.MonthlyCarTmp;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Daina
 * @description:
 * @date: Created in 14:14 2019/3/27
 */
@Repository
public interface MonthlyCarTmpMapper {
    /**
     * 功能描述:
     * 〈批量添加临时车〉
     * @param monthlyCarTmps 1
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/27 14:21
     */
    Integer addMonthlyCarTmp(List<MonthlyCarTmp> monthlyCarTmps);

    /**
     * 功能描述:
     * 〈删除临时车〉
     * @param guid 1
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/27 14:41
     */
    Integer deleteMonthlyCarTmp(@Param("guid")String guid);

    /**
     * 功能描述:
     * 〈根据guid获取临时车辆列表〉
     * @param guid 1
     * @return : java.util.List<com.example.daina.entity.MonthlyCarTmp>
     * @author : daina
     * @date : 2019/3/27 15:04
     */
    List<MonthlyCarTmp> getMonthlyCarTmpList(@Param("guid")String guid);

    /**
     * 功能描述:
     * 〈清空临时车辆列表〉
     * @param  1
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/27 16:21
     */
    Integer deleteAllMonthlyCarTmp();
}
