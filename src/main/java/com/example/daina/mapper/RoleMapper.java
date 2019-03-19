package com.example.daina.mapper;

import com.example.daina.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Daina
 * @description:
 * @date: Created in 11:35 2019/3/18
 */
@Repository
public interface RoleMapper {
    List<Role> getAllRole();
}
