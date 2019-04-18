package com.example.daina.service;

import com.example.daina.entity.Role;
import com.example.daina.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Daina
 * @description:
 * @date: Created in 11:45 2019/3/18
 */
@Service
public class RoleService {
    @Autowired
    RoleMapper roleMapper;

    public List<Role> getAllRole(String roleId) {
        return roleMapper.getAllRole(roleId);
    }
}
