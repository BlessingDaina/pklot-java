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
    /**
     * 功能描述:
     * 〈登录〉
     * @param user 1
     * @return : com.example.daina.entity.User
     * @author : daina
     * @date : 2019/3/24 11:23
     */
    User login(User user);
    /**
     * 功能描述:
     * 〈获取人员列表〉
     * @param userInfo 1
     * @param roleId 2
     * @param delFlag 3
     * @return : java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     * @author : daina
     * @date : 2019/3/24 11:24
     */
    /**
     * 功能描述:
     * 〈通过登录名查询用户〉
     * @param loginName 1
     * @return : com.example.daina.entity.User
     * @author : daina
     * @date : 2019/3/24 11:33
     */
    User findUserByLoginName(@Param("loginName") String loginName);
    /**
     * 功能描述:
     * 〈通过Id查询用户〉
     * @param userId 1
     * @return : com.example.daina.entity.User
     * @author : daina
     * @date : 2019/3/24 11:33
     */
    User findUserByUserId(@Param("userId") String userId);
    List<Map<String, Object>> getUserList(@Param("userInfo") String userInfo, @Param("roleId") String roleId, @Param("delFlag") Integer delFlag);
    /**
     * 功能描述:
     * 〈检测登录名是否使用〉
     * @param loginName 1
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/24 11:24
     */
    Integer getIsUsedLoginName(@Param("loginName") String loginName);
    /**
     * 功能描述:
     * 〈检测电话号码是否使用〉
     * @param phone 1
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/24 11:24
     */
    Integer getIsUsedPhone(@Param("phone") String phone);
    /**
     * 功能描述:
     * 〈添加人员〉
     * @param user 1
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/24 11:24
     */
    Integer addUser(User user);
    /**
     * 功能描述:
     * 〈更新人员〉
     * @param user 1
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/24 11:25
     */
    Integer updateUser(User user);
    /**
     * 功能描述:
     * 〈重置密码〉
     * @param user 1
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/24 11:25
     */
    Integer resetPwd(User user);
    /**
     * 功能描述:
     * 〈停用启用〉
     * @param user 1
     * @return : java.lang.Integer
     * @author : daina
     * @date : 2019/3/24 11:25
     */
    Integer updateStatus(User user);
}



