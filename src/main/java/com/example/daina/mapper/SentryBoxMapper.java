package com.example.daina.mapper;

import com.example.daina.entity.SentryBox;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Daina
 * @description:
 * @date: Created in 10:24 2019/4/1
 */
@Repository
public interface SentryBoxMapper {
    /**
     * 功能描述:
     * 〈获取岗亭列表〉
     * @param parkingLotId 1
     * @return : java.util.List<com.example.daina.entity.SentryBox>
     * @author : daina
     * @date : 2019/4/1 10:35
     */
    List<SentryBox> getSentry(@Param("parkingLotId")String parkingLotId);
}
