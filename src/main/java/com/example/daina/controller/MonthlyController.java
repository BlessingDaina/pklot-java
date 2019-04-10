package com.example.daina.controller;

import com.alibaba.fastjson.JSON;
import com.example.daina.annotation.UserLoginToken;
import com.example.daina.entity.Monthly;
import com.example.daina.entity.MonthlyOccupy;
import com.example.daina.entity.Page;
import com.example.daina.entity.Result;
import com.example.daina.service.CategoryService;
import com.example.daina.service.MonthlyCarService;
import com.example.daina.service.MonthlyOccupyService;
import com.example.daina.service.MonthlyService;
import com.example.daina.utils.DatabaseUtils;
//import com.example.daina.utils.ExcelUtils;
import com.example.daina.utils.ResultUtil;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import com.alibaba.fastjson.JSONArray;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Daina
 * @description:
 * @date: Created in 10:01 2019/3/26
 */
@RestController
@RequestMapping(value = "/api/pklot")
public class MonthlyController {
    @Autowired
    MonthlyService monthlyService;
    @Autowired
    MonthlyOccupyService monthlyOccupyService;
    @Autowired
    MonthlyCarService monthlyCarService;
    @Autowired
    CategoryService categoryService;

    @UserLoginToken
    @RequestMapping(value = "/getMonthlyListByPage")
    public Result getMonthlyListByPage(@RequestParam("pageNum") Integer pageNum,
                                       @RequestParam("pageSize") Integer pageSize,
                                       @RequestParam("parkingLotId") String parkingLotId,
                                       @RequestParam("searchInfo") String searchInfo,
                                       @RequestParam("monthlyType") String monthlyType) {
        Page<Monthly> monthlyPage = monthlyService.getMonthlyListByPage(pageNum, pageSize, parkingLotId, searchInfo, monthlyType);
        return ResultUtil.success(monthlyPage);
    }

    @UserLoginToken
    @RequestMapping(value = "/addMonthlyAndOccupy")
    public Result addMonthlyAndOccupy(Monthly monthly) {
        Monthly setOccupyNum = new Monthly();
        List<MonthlyOccupy> occupyNums;
        String monthlyId = monthlyService.addMonthly(monthly);
        String parkingLotId = monthly.getParkingLotId();
        // 获取包月车辆信息列表
        Object obj = monthly.getOccupyList();
        // 转换list为json字符串
        List<MonthlyOccupy> monthlyOccupies = JSON.parseArray(obj.toString(), MonthlyOccupy.class);
        for (MonthlyOccupy monthlyOccupy : monthlyOccupies) {
            monthlyOccupy.setMonthlyId(monthlyId);
        }
        Integer addTag = monthlyOccupyService.addMonthlyOccupy(monthlyOccupies);
        if (addTag != 0) {
            Integer occupyNum = 0;
            occupyNums = monthlyOccupyService.getOccupyByMonthlyId(monthlyId);
            for (MonthlyOccupy monthlyOccupy : occupyNums) {
                occupyNum += monthlyOccupy.getOccupyNum();
            }
            setOccupyNum.setOccupyNum(occupyNum);
            setOccupyNum.setMonthlyId(monthlyId);
            monthlyService.updateOccupyNum(setOccupyNum);
            return ResultUtil.success(monthlyId);
        } else {
            return ResultUtil.error(500, "添加失败");
        }
    }

    @UserLoginToken
    @RequestMapping(value = "/deleteMonthly")
    public Result deleteMonthly(@RequestParam("monthlyId") String monthlyId) {
        Integer result = monthlyService.deleteMonthly(monthlyId);
        if (result != 0) {
            monthlyOccupyService.deleteMonthlyOccupy(monthlyId);
            monthlyCarService.deleteMonthlyCarByMonthlyId(monthlyId);
            return ResultUtil.success(result);
        } else {
            return ResultUtil.error(500, "删除失败");
        }
    }

    @UserLoginToken
    @RequestMapping(value = "/updateMonthlyAndOccupy")
    public Result updateMonthly(Monthly monthly) {
        List<MonthlyOccupy> occupyNums;
        // 获取包月车辆信息列表
        Object obj = monthly.getOccupyList();
        // 转换list为json字符串
        List<MonthlyOccupy> monthlyOccupies = JSON.parseArray(obj.toString(), MonthlyOccupy.class);
        Integer updateOccupy = monthlyOccupyService.updateMonthlyOccupy(monthlyOccupies);
        if (updateOccupy != 0) {
            Integer occupyNum = 0;
            occupyNums = monthlyOccupyService.getOccupyByMonthlyId(monthly.getMonthlyId());
            for (MonthlyOccupy monthlyOccupy : occupyNums) {
                occupyNum += monthlyOccupy.getOccupyNum();
            }
            monthly.setOccupyNum(occupyNum);
        }
        Integer result = monthlyService.updateMonthly(monthly);
        return ResultUtil.success(result);
    }

    /**
     * 功能描述:
     * 〈下载导入模板〉
     *
     * @param downloadType 1
     * @param res          2
     * @return : void
     * @author : daina
     * @date : 2019/4/8 11:47
     */
    @RequestMapping(value = "/excelParkMonthlyMouldDownload/{downloadType}")
    public void getExcelMould(@PathVariable String downloadType, HttpServletResponse res) {
        //表示下载包月导入表
        String downloadParkMonthlyMould = "1";

        //表示下载包月车辆导入表
        String downloadParkMonthlyCarMould = "2";

        //表示下载特殊车辆导入表
        String downloadSpecialCarMould = "3";

        //表示下载特殊车辆导入表
        String downloadTempCarMould = "4";

        //设置下载文件名
        String fileName = "包月导入表.xlsx";
        String fileName1 = null;

        if (downloadParkMonthlyMould.equals(downloadType)) {
            //设置下载文件名
            fileName = "包月导入表.xlsx";
        }

        if (downloadParkMonthlyCarMould.equals(downloadType)) {
            fileName = "包月车辆导入.xlsx";
        }

        if (downloadSpecialCarMould.equals(downloadType)) {
            fileName = "特殊车辆导入表.xlsx";
        }

        if (downloadTempCarMould.equals(downloadType)) {
            fileName = "临停车辆导入表.xlsx";
        }

        try {
            fileName1 = new String(fileName.getBytes("gbk"), "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //设置相应类型
        res.setContentType("application/octet-stream");
        //设置响应头
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", fileName1);
        res.setHeader(headerKey, headerValue);
        // 模板下载
        try {
            // 读资源文件
            InputStream myStream = this.getClass().getResourceAsStream("/excelMouldFiles/" + fileName);
            IOUtils.copy(myStream, res.getOutputStream());
            res.flushBuffer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @UserLoginToken
    @RequestMapping(value = "/importParkMonthlyInfo")
    public Result importParkMonthlyInfo(@RequestParam Map<String, Object> params) {
        // 获取所有参数
        Object obj = params.get("params");
        List<Map> list = JSONArray.parseArray(obj.toString(), Map.class);

        //存放所有错误信息
        List<Map<String, Object>> errInfo = new ArrayList<>();

        // 获取前端数据
        for (Map<String, Object> pmInfo : list) {
            // 通过车主，车牌和停车场id查询monthlyId
            Map<String, Object> parkMonthlyMonthlyId = null;
            Map<String, Object> parkMonthlyCarMonthlyId;
            Map<String, Object> parkMonthlyOccupyMonthlyId;
            // 设置前端传递过来的参数
            pmInfo.put("parkingLotId", params.get("parkingLotId"));
            String monthlyId = DatabaseUtils.generateUniqueKey();
            // 标记选中停车场和表中停车场是否一致
            boolean flag = false;
            // 查看当前用户名是否已存在，如果存在返回monthlyId
            Object ownerName = pmInfo.get("ownerName");
            System.out.println(pmInfo.get("ownerName"));
            if (ownerName == null || ownerName.equals("")) {
                pmInfo.put("errMsg", "车主名不能为空");
                errInfo.add(pmInfo);
            } else {
                List<Map<String, Object>> monthlyMonthlies = monthlyService.isExistOwnerName(pmInfo);
                System.out.println(monthlyMonthlies.size());
                //如果存在多个同名包月用户
                if (monthlyMonthlies.size() > 1) {
                    //返回错误信息
                    pmInfo.put("errMsg", "车主名<" + ownerName + ">在系统中存在多个。");
                    errInfo.add(pmInfo);
                } else if (monthlyMonthlies.size() == 1) {
                    parkMonthlyMonthlyId = new HashMap<>(2);
                    parkMonthlyMonthlyId.putAll(monthlyMonthlies.get(0));
                }
            }
            // 统计总得占用车位数量
            Integer occupyNum = 0;
            //查询车位占用信息是否存在，如果存在，返回monthlyId
            Object parkingOccupy = pmInfo.get("parkingOccupy");
            if (parkingOccupy == null || parkingOccupy.equals("")) {
                //返回错误信息
                pmInfo.put("errMsg", "车位占用信息不能为空");
                Map<String, Object> map = new HashMap<>(16);
                map.putAll(pmInfo);
                errInfo.add(map);
            } else {
                // 查询主停车场和所有子停车场
                List<Map<String, Object>> allParkingLot = monthlyService.listAllParkingLotId(pmInfo);
                for (Map<String, Object> parkingLotInfo : allParkingLot) {
                    //该停车场是否添加占位信息
                    boolean isSaveOccupy = false;
                    // 将各个停车场分开（之间用分号隔开）
                    String[] parkingOccupys = parkingOccupy.toString().split(";");
                    for (String pkOccInfo : parkingOccupys) {
                        //0为停车场名称，1为占用类型，2为占用数量
                        String[] info = pkOccInfo.split(":");
                        if (info[0].equals(parkingLotInfo.get("parkingLotName").toString())) {
                            flag = true;
                            //统计车位占用数量
                            occupyNum += Integer.parseInt(info[2]);
                            //车位占用信息
                            parkingLotInfo.put("occupyType", info[1]);
                            parkingLotInfo.put("occupyNum", info[2]);
                            if (parkMonthlyMonthlyId == null) {
                                parkingLotInfo.put("monthlyId", monthlyId);
                            } else {
                                parkingLotInfo.put("monthlyId", parkMonthlyMonthlyId.get("monthlyId"));
                            }
                            parkMonthlyOccupyMonthlyId = monthlyService.isExistParkingLotId(parkingLotInfo);
                            if (parkMonthlyOccupyMonthlyId != null) {
                                monthlyService.updateParkMonthlyOccupyFromExcel(parkingLotInfo);
                            } else {
                                //如果parkMonthlyOccupyMonthlyId为空，数据库中不存在当前车位占用信息，添加
                                //生成新的车位占用id
                                String occupyId = DatabaseUtils.generateUniqueKey();
                                parkingLotInfo.put("occupyId", occupyId);
                                monthlyService.saveParkMonthlyOccupyFromExcel(parkingLotInfo);
                            }
                            isSaveOccupy = true;
                        }
                    }
                    // 如果未为该停车场添加车场，默认添加一个占用数量为0的车场
                    if (!isSaveOccupy) {
                        parkingLotInfo.put("occupyType", 0);
                        parkingLotInfo.put("occupyNum", 0);
                        if (parkMonthlyMonthlyId == null) {
                            parkingLotInfo.put("monthlyId", monthlyId);
                        } else {
                            parkingLotInfo.put("monthlyId", parkMonthlyMonthlyId.get("monthlyId"));
                        }
                        parkMonthlyOccupyMonthlyId = monthlyService.isExistParkingLotId(parkingLotInfo);
                        //如果parkMonthlyOccupyMonthlyId不为空，数据库中存在当前车位占用信息，更新
                        if (parkMonthlyOccupyMonthlyId != null) {
                            monthlyService.updateParkMonthlyOccupyFromExcel(parkingLotInfo);
                        } else { //如果parkMonthlyOccupyMonthlyId为空，数据库中不存在当前车位占用信息，添加
                            monthlyService.saveParkMonthlyOccupyFromExcel(parkingLotInfo);
                        }
                    }
                }
            }
            if (!flag) {
                break;
            }
            //查询车牌号是否存在，如果存在，返回monthlyId
            Object carLicense = pmInfo.get("carLicense");
            if (carLicense == null || carLicense.equals("")) {
                pmInfo.put("errMsg", "车牌号不能为空");
                errInfo.add(pmInfo);
            } else {//获取所有车牌信息
                //获取所有车牌信息
                String[] carLicenses = carLicense.toString().split(",");
                //遍历并更新所有车牌信息
                for (String carLic : carLicenses) {
                    //对截取的车牌号进行验证是否存在该车牌信息
                    pmInfo.put("carLicense", carLic);
                    parkMonthlyCarMonthlyId = monthlyService.isExistCarLicense(pmInfo);
                    //导入数据操作
                    //如果车牌号和车主都存在并且monthlyId相同，更新数据
                    if (parkMonthlyCarMonthlyId != null && parkMonthlyMonthlyId != null && parkMonthlyMonthlyId.get("monthlyId").toString().equals(parkMonthlyCarMonthlyId.get("monthlyId").toString())) {
                        //设置参数
                        pmInfo.put("monthlyId", parkMonthlyMonthlyId.get("monthlyId"));
                        monthlyService.updateParkMonthlyCarFromExcel(pmInfo);
                    } else if (parkMonthlyMonthlyId == null && parkMonthlyCarMonthlyId == null) {
                        //如果车牌号和车主都不存在，添加数据
                        //设置包月用户id
                        pmInfo.put("monthlyId", monthlyId);
                        //根据excel表添加包月车辆信息
                        String monthlyCarId = DatabaseUtils.generateUniqueKey();
                        pmInfo.put("carLicense", pmInfo.get("carLicense").toString().trim());
                        pmInfo.put("monthlyCarId", monthlyCarId);
                        monthlyService.saveParkMonthlyCarFromExcel(pmInfo);
                    } else if (parkMonthlyMonthlyId != null && parkMonthlyCarMonthlyId == null) {
                        //车主存在车牌不存在
                        pmInfo.put("errMsg", "当前车主" + pmInfo.get("ownerName") + "信息在系统中已经存在，请在编辑页面添加新车辆" + pmInfo.get("carLicense"));
                        Map<String, Object> map1 = new HashMap<>(16);
                        map1.putAll(pmInfo);
                        errInfo.add(map1);
                    } else if (parkMonthlyMonthlyId == null && parkMonthlyCarMonthlyId != null) {
                        //车主不存在车牌存在，返回错误信息
                        pmInfo.put("errMsg", "当前车辆" + pmInfo.get("carLicense") + "信息已被其他人使用");
                        Map<String, Object> map1 = new HashMap<>(16);
                        map1.putAll(pmInfo);
                        errInfo.add(map1);
                    } else { //车主车牌都存在，但是对应monthlyId不同，返回错误信息
                        pmInfo.put("errMsg", "当前车辆" + pmInfo.get("carLicense") + "并不在车主" + pmInfo.get("ownerName") + "名下");
                        Map<String, Object> map1 = new HashMap<>(16);
                        map1.putAll(pmInfo);
                        errInfo.add(map1);
                    }
                }
            }
            //查询车辆类别
            pmInfo.put("categoryType", 1);
            List<Map<String, Object>> listCarCategory = categoryService.listCarCategory(pmInfo);
            for (Map<String, Object> carCategory : listCarCategory) {
                //设置车辆类别id
                if (carCategory.get("categoryName").toString().equals(pmInfo.get("categoryName").toString())) {
                    pmInfo.put("categoryId", carCategory.get("categoryId"));
                }
            }
            //设置总的车位占用数量
            pmInfo.put("occupyNum", occupyNum);
            //保存包月用户信息
            if (parkMonthlyMonthlyId != null && flag) {
                pmInfo.put("monthlyId", parkMonthlyMonthlyId.get("monthlyId"));
                monthlyService.updateParkMonthlyFromExcel(pmInfo);
            } else if (parkMonthlyMonthlyId == null && flag) {
                pmInfo.put("monthlyId", monthlyId);
                monthlyService.saveParkMonthlyFromExcel(pmInfo);
            }
            String carLicenses = monthlyCarService.getCarLicense(pmInfo);
            if (null != carLicenses) {
                String[] carLicence = carLicenses.split(",");
                if (3 < carLicence.length) {
                    carLicenses = carLicence[0] + "," + carLicence[1] + "," + carLicence[2] + "等";
                }
                pmInfo.put("carLicense", carLicenses);
                monthlyCarService.updateParkMonthlyList(pmInfo);
            }
        }
        if (errInfo.size() > 0) {
            return ResultUtil.success(errInfo);
        } else {
            return ResultUtil.success();
        }
    }

    @UserLoginToken
    @RequestMapping(value = "/importParkMonthlyCarInfo")
    public Result importParkMonthlyCarInfo(@RequestParam Map<String, Object> params) {
        //获取所有参数
        Object obj = params.get("params");
        List<Map> list = JSONArray.parseArray(obj.toString(), Map.class);
        //保存错误消息
        List<Map<String, Object>> errInfo = new ArrayList<>();
        for (Map<String, Object> pmcInfo : list) {
            //判断当前车牌是否已经存在记录
            pmcInfo.put("parkingLotId", params.get("parkingLotId"));
            Map<String, Object> parkMonthlyCarMonthlyId = monthlyService.isExistCarLicense(pmcInfo);
            if (parkMonthlyCarMonthlyId == null) {
                pmcInfo.put("monthlyId", params.get("monthlyId"));
                pmcInfo.put("monthlyCarId", DatabaseUtils.generateUniqueKey());
                //导入数据
                monthlyService.saveParkMonthlyCarFromExcel(pmcInfo);
            } else if (params.get("monthlyId").equals(parkMonthlyCarMonthlyId.get("monthlyId"))) {
                pmcInfo.put("monthlyId", params.get("monthlyId"));
                monthlyService.updateParkMonthlyCarFromExcel(pmcInfo);
            } else {
                pmcInfo.put("errMsg", "当前车辆" + pmcInfo.get("carLicense") + "已存在记录");
                errInfo.add(pmcInfo);
            }
        }
        String carLicense = monthlyCarService.getCarLicense(params);
        if (null != carLicense) {
            String[] carLicence = carLicense.split(",");
            if (carLicence.length > 3) {
                carLicense = carLicence[0] + "," + carLicence[1] + "," + carLicence[2] + "等";
            }
            params.put("carLicense", carLicense);
            monthlyCarService.updateParkMonthlyList(params);
        }
        if (errInfo.size() > 0) {
            return ResultUtil.success(errInfo);
        } else {
            return ResultUtil.success();
        }
    }

    @UserLoginToken
    @RequestMapping(value = "/exportParkMonthly", method = RequestMethod.POST)
    public void exportParkMonthly(@RequestParam Map<String, Object> params, HttpServletResponse response) {
        List<Map<String, Object>> list = monthlyService.exportParkMonthly(params);
//当车牌数量超过三个，只保留三个车牌，加上等字
        for (Map<String, Object> map : list) {
            if (map.get("carLicense") != null) {
                String[] carLicenses = map.get("carLicense").toString().split(",");
                if (carLicenses.length >= 3) {
                    String carLicense = carLicenses[0] + "," + carLicenses[1] + "," + carLicenses[2] + "等";
                    map.put("carLicense", carLicense);
                }
            }
        }

        //excel标题
        String header = "包月信息";
        String[] title = {"房号", "车主", "电话　", "包月类型", "车牌号", "占用车位", "包月金额", "到期时间", "车辆类别", "包月车位"};

        //excel文件名
        String fileName = "包月信息" + System.currentTimeMillis() + ".xlsx";

        //sheet名
        String sheetName = "包月信息";

        String[][] content = new String[list.size()][title.length];

        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet(sheetName);

        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> obj = list.get(i);
            content[i][0] = obj.get("roomNumber").toString();
            content[i][1] = obj.get("ownerName").toString();
            content[i][2] = obj.get("phone").toString();
            content[i][3] = obj.get("monthlyType").toString();
            content[i][4] = obj.get("carLicense").toString();
            content[i][5] = obj.get("occupyNum").toString();
            content[i][6] = obj.get("amount").toString();
            System.out.println(obj.get("expDate").toString());
            content[i][7] = obj.get("expDate").toString();
            content[i][8] = obj.get("categoryName").toString();
            content[i][9] = obj.get("monthlySpace").toString();
        }

        //第一个参数代表列id(从0开始),第2个参数代表宽度值
        sheet.setColumnWidth(4, 6000);

        //创建HSSFWorkbook
//        wb = ExcelUtils.getXSSFWorkbook(sheetName,header,title,content,wb);

//        ExcelUtils.setResponseHeader(response, fileName, wb);
    }
}
