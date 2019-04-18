package com.example.daina.mapper;

import com.example.daina.entity.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Daina
 * @description:
 * @date: Created in 11:35 2019/3/18
 */
@Repository
public interface RoleMapper {
    /**
     * 功能描述:
     * 〈获取所有角色〉
     * @param  1
     * @return : java.util.List<com.example.daina.entity.Role>
     * @author : daina
     * @date : 2019/3/24 11:22
     */
    List<Role> getAllRole(@Param("roleId")String roleId);
}
