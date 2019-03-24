package com.example.daina.mapper;

import com.example.daina.entity.Menu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Daina
 * @description:
 * @date: Created in 14:08 2019/3/14
 */
@Repository
public interface MenuMapper {
    /**
     * 功能描述:
     * 〈通过siteId获取菜单〉
     * @param siteId 1
     * @return : java.util.List<com.example.daina.entity.Menu>
     * @author : daina
     * @date : 2019/3/24 11:20
     */
    List<Menu> getMenuParentBySiteId(@Param("siteId") String siteId);
}
