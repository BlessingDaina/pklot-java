package com.example.daina.service;

import com.example.daina.entity.Site;
import com.example.daina.mapper.SiteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Daina
 * @description:
 * @date: Created in 14:34 2019/3/13
 */
@Service
public class SiteService {

    @Autowired
    SiteMapper siteMapper;

    public List<Site> getSites(String roleId) {
        List<Site> list = siteMapper.getSites(roleId);
        return list;
    }
}
