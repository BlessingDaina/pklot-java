package com.example.daina.service;

import com.example.daina.entity.User;
import com.example.daina.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Daina
 * @description:
 * @date: Created in 17:03 2019/3/11
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public Map<String, Object> login(User user) {
        User u = userMapper.login(user);
        Map<String, Object> map = new HashMap<>();
        if (u == null) {
        } else {
            map.put("userId", u.getUserId());
            map.put("unitId", u.getUnitId());
            map.put("isAdmin", u.getIsAdmin());
            map.put("userName", u.getUserName());
            map.put("phone", u.getPhone());
            map.put("roleId", u.getRoleId());
            map.put("parkingLotId", u.getParkingLotId());
        }
        return map;
    }
    public User findUserByLoginName(String loginName) {
        return userMapper.findUserByLoginName(loginName);
    }
    public User findUserById(String userId) {
        return userMapper.findUserByUserId(userId);
    }

    public List<Map<String, Object>> getUserList (String userInfo, String roleId, Integer delFlag,String parkingLotId, String userRoleId) {
        List<Map<String, Object>> users = userMapper.getUserList(userInfo, roleId, delFlag, parkingLotId, userRoleId);
        return users;
    }
    public Integer getIsUsedLoginName(String loginName) {
        return userMapper.getIsUsedLoginName(loginName);
    }
    public Integer getIsUsedPhone(String phone) {
        return userMapper.getIsUsedPhone(phone);
    }
    public Integer addUser(User user) {
        return userMapper.addUser(user);
    }
    public Integer updateUser(User user) {
        return userMapper.updateUser(user);
    }
    public Integer resetPwd(User user) {
        return userMapper.resetPwd(user);
    }
    public Integer updateStatus(User user) {
        return userMapper.updateStatus(user);
    }
}
