package com.example.daina.controller;

import com.example.daina.entity.Result;
import com.example.daina.entity.Role;
import com.example.daina.service.RoleService;
import com.example.daina.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: Daina
 * @description:
 * @date: Created in 11:50 2019/3/18
 */
@RestController
@RequestMapping(value = "/api/sys")
public class RoleController {
    @Autowired
    RoleService roleService;

    @RequestMapping(value = "/getAllRole")
    public Result<Role> getAllRole() {
        List<Role> roles = roleService.getAllRole();
        return ResultUtil.success(roles);
    }
}
