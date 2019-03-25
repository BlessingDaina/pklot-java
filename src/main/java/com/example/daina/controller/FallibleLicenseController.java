package com.example.daina.controller;

import com.example.daina.annotation.UserLoginToken;
import com.example.daina.entity.FallibleLicense;
import com.example.daina.entity.Page;
import com.example.daina.entity.Result;
import com.example.daina.service.FallibleLicenseService;
import com.example.daina.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Daina
 * @description:
 * @date: Created in 14:35 2019/3/25
 */
@RestController
@RequestMapping(value = "/api/pklot")
public class FallibleLicenseController {
    @Autowired
    FallibleLicenseService fallibleLicenseService;

    @UserLoginToken
    @RequestMapping(value = "/getFallibleLicenseByPage")
    public Result getFallibleLicenseByPage(@RequestParam("pageNum") Integer pageNum,
                                           @RequestParam("pageSize") Integer pageSize,
                                           @RequestParam("parkingLotId")String parkingLotId,
                                           @RequestParam("searchInfo")String searchInfo) {
        Page<FallibleLicense> fallibleLicensePage = fallibleLicenseService.getFallibleLicenseByPage(pageNum, pageSize,
                parkingLotId, searchInfo);
        return ResultUtil.success(fallibleLicensePage);
    }

    @UserLoginToken
    @RequestMapping(value = "/addFallibleLicense")
    public Result addFallibleLicense(FallibleLicense fallibleLicense) {
        Integer result = fallibleLicenseService.addFallibleLicense(fallibleLicense);
        return ResultUtil.success(result);
    }

    @UserLoginToken
    @RequestMapping(value = "/getIsUsedErrorLicense")
    public Result getIsUsedErrorLicense(@RequestParam("errorLicense")String errorLicense,
                                        @RequestParam("parkingLotId")String parkingLotId) {
        Integer result = fallibleLicenseService.getIsUsedErrorLicense(errorLicense, parkingLotId);
        return ResultUtil.success(result);
    }

    @UserLoginToken
    @RequestMapping(value = "/updateFallibleLicense")
    public Result updateFallibleLicense(FallibleLicense fallibleLicense) {
        Integer result = fallibleLicenseService.updateFallibleLicense(fallibleLicense);
        return ResultUtil.success(result);
    }

    @UserLoginToken
    @RequestMapping(value = "/deleteFallibleLicense")
    public Result deleteFallibleLicense(@RequestParam("fallibleId")String fallibleId) {
        Integer result = fallibleLicenseService.deleteFallibleLicense(fallibleId);
        return ResultUtil.success(result);
    }
}
