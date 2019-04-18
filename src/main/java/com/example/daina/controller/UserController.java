package com.example.daina.controller;

import com.example.daina.entity.Result;
import com.example.daina.entity.User;
import com.example.daina.service.TokenService;
import com.example.daina.service.UserService;
import com.example.daina.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author: Daina
 * @description:
 * @date: Created in 17:01 2019/3/11
 */
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    TokenService tokenService;

    @RequestMapping(value = "/sys/login", method = RequestMethod.POST)
    public Result login(User user) {
        Map<String, Object> map = userService.login(user);
        String userId = (String)map.get("userId");
        if (userId == null) {
            return ResultUtil.error(500, "用户名或密码错误");
        } else {
            User tokenInfo = userService.findUserByLoginName(user.getLoginName());
            String token = tokenService.getToken(tokenInfo);
            map.put("token", token);
            return ResultUtil.success(map);
        }
    }

    @RequestMapping(value = "/pklot/getUserList", method = RequestMethod.POST)
    public Result getUserList(@RequestParam("userInfo")String userInfo,
                              @RequestParam("roleId")String roleId,
                              @RequestParam("delFlag")Integer delFlag,
                              @RequestParam("parkingLotId")String parkingLotId,
                              @RequestParam("userRoleId")String userRoleId) {
        List<Map<String, Object>> users = userService.getUserList(userInfo,
                roleId, delFlag, parkingLotId, userRoleId);
        return ResultUtil.success(users);
    }

    @RequestMapping(value = "/pklot/getIsUsedLoginName", method = RequestMethod.POST)
    public Result getIsUsedLoginName(@RequestParam("loginName")String loginName) {
        Integer count = userService.getIsUsedLoginName(loginName);
        return ResultUtil.success(count);
    }

    @RequestMapping(value = "/pklot/getIsUsedPhone", method = RequestMethod.POST)
    public Result getIsUsedPhone(@RequestParam("phone")String phone) {
        Integer count = userService.getIsUsedPhone(phone);
        return ResultUtil.success(count);
    }

    @RequestMapping(value = "/pklot/addUser", method = RequestMethod.POST)
    public Result addUser(User user) {
        Integer result = userService.addUser(user);
        return ResultUtil.success(result);
    }

    @RequestMapping(value = "/pklot/updateUser", method = RequestMethod.POST)
    public Result updateUser(User user) {
        Integer result = userService.updateUser(user);
        return ResultUtil.success(result);
    }

    @RequestMapping(value = "/pklot/resetPwd", method = RequestMethod.POST)
    public Result resetPwd(User user) {
        Integer result = userService.resetPwd(user);
        return ResultUtil.success(result);
    }

    @RequestMapping(value = "/pklot/updateStatus", method = RequestMethod.POST)
    public Result updateStatus(User user) {
        Integer result = userService.updateStatus(user);
        return ResultUtil.success(result);
    }

    @RequestMapping(value = "/sentry/findUserByUserId")
    public Result findUserByUserId(@RequestParam("userId")String userId) {
        User user = userService.findUserById(userId);
        return ResultUtil.success(user);
    }
}
