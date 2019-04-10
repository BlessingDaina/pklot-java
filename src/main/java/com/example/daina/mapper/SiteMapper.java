package com.example.daina.mapper;

import com.example.daina.entity.Site;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Daina
 * @description:
 * @date: Created in 14:25 2019/3/13
 */
@Repository
public interface SiteMapper {
    /**
     * 功能描述:
     * 〈获取所有站点〉
     * @param roleId 1
     * @return : java.util.List<com.example.daina.entity.Site>
     * @author : daina
     * @date : 2019/4/9 16:33
     */
    List<Site> getSites(@Param("roleId")String roleId);
}
