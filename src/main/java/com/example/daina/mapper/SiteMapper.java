package com.example.daina.mapper;

import com.example.daina.entity.Site;

import java.util.List;

/**
 * @author: Daina
 * @description:
 * @date: Created in 14:25 2019/3/13
 */
public interface SiteMapper {
    /**
     * 功能描述:
     * 〈获取所有站点〉
     * @param  1
     * @return : java.util.List<com.example.daina.entity.Site>
     * @author : daina
     * @date : 2019/3/24 11:23
     */
    List<Site> getSites();
}
