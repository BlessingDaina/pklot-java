package com.example.daina.mapper;

import com.example.daina.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author: Daina
 * @description:
 * @date: Created in 17:02 2019/3/11
 */
@Repository
public interface UserMapper {

    User login(User user);
    User findUserByLoginName(@Param("loginName") String loginName);
    User findUserByUserId(@Param("userId") String userId);
    List<Map<String, Object>> getUserList(@Param("userInfo") String userInfo, @Param("roleId") String roleId, @Param("delFlag") Integer delFlag);
    Integer getIsUsedLoginName(@Param("loginName") String loginName);
    Integer getIsUsedPhone(@Param("phone") String phone);
    Integer addUser(User user);
    Integer updateUser(User user);
    Integer resetPwd(User user);
    Integer updateStatus(User user);
}

