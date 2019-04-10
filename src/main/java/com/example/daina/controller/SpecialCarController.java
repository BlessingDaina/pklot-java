package com.example.daina.controller;

import com.example.daina.annotation.UserLoginToken;
import com.example.daina.entity.Page;
import com.example.daina.entity.Result;
import com.example.daina.entity.SpecialCar;
import com.example.daina.service.SpecialCarService;
import com.example.daina.utils.ExcelUtils;
import com.example.daina.utils.ResultUtil;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author: Daina
 * @description:
 * @date: Created in 13:37 2019/3/24
 */
@RestController
@RequestMapping(value = "/api/pklot")
public class SpecialCarController {
    @Autowired
    SpecialCarService specialCarService;

    @UserLoginToken
    @RequestMapping(value = "/getSpecialCarListByPage")
    public Result getSpecialCarListByPage(@RequestParam("pageNum") Integer pageNum,
                                          @RequestParam("pageSize") Integer pageSize,
                                          @RequestParam("specialType") Integer specialType,
                                          @RequestParam("parkingLotId") String parkingLotId,
                                          @RequestParam("status") Integer status,
                                          @RequestParam("searchInfo") String searchInfo) {
        Page<SpecialCar> specialCarPage = specialCarService.getSpecialCarListByPage(pageNum,
                pageSize, specialType, parkingLotId, status, searchInfo);
        return ResultUtil.success(specialCarPage);
    }

    @UserLoginToken
    @RequestMapping(value = "/addSpecialCar")
    public Result addSpecialCar(SpecialCar specialCar) {
        Integer result = specialCarService.addSpecialCar(specialCar);
        return ResultUtil.success(result);
    }

    @UserLoginToken
    @RequestMapping(value = "/getIsUsedCarLicense")
    public Result getIsUsedCarLicense(@RequestParam("carLicense") String carLicense, @RequestParam("parkingLotId") String parkingLotId) {
        Integer result = specialCarService.getIsUsedCarLicense(carLicense, parkingLotId);
        return ResultUtil.success(result);
    }

    @UserLoginToken
    @RequestMapping(value = "/updateSpecialCar")
    public Result updateSpecialCar(SpecialCar specialCar) {
        Integer result = specialCarService.updateSpecialCar(specialCar);
        return ResultUtil.success(result);
    }

    @UserLoginToken
    @RequestMapping(value = "/deleteSpecialCar")
    public Result deleteSpecialCar(@RequestParam("specialCarId")String specialCarId) {
        Integer result = specialCarService.deleteSpecialCar(specialCarId);
        return ResultUtil.success(result);
    }

//    @UserLoginToken
    @RequestMapping(value = "/exportSpecialCar")
    public void exportSpecialCar(@RequestParam Map<String, Object> params, HttpServletResponse response) {
        List<Map<String, Object>> list = specialCarService.exportSpecialCar(params);
        // excel标题 excel文件名
        String specialType = params.get("specialType").toString();
        String header = "";
        String fileName = "";
        if (specialType.equals("0")) {
            header = "免费车辆";
            fileName = "免费车辆" + System.currentTimeMillis() + ".xlsx";
        }else if (specialType.equals("1")) {
            header = "黑名车辆";
            fileName = "黑名车辆" + System.currentTimeMillis() + ".xlsx";
        }

        String[] title = {"车牌号", "期限", "免费类别", "开始时间", "结束时间", "备注"};

        //sheet名
        String sheetName = "特殊车辆";

        String[][] content = new String[list.size()][title.length];

        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet(sheetName);

        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> obj = list.get(i);
            System.out.println(obj.get("carLicense").toString());
            System.out.println(obj.get("restrictType").toString());
            System.out.println(obj.get("categoryName").toString());
            System.out.println(obj.get("startDate").toString());
            System.out.println(obj.get("endDate").toString());
            System.out.println(obj.get("remarks").toString());
            content[i][0] = obj.get("carLicense").toString();
            content[i][1] = obj.get("restrictType").toString();
            content[i][2] = obj.get("categoryName").toString();
            content[i][3] = obj.get("startDate").toString();
            content[i][4] = obj.get("endDate").toString();
            content[i][5] = obj.get("remarks").toString();

            sheet.setColumnWidth(i, 5000);
        }

        wb = ExcelUtils.getXSSFWorkbook(sheetName, header, title, content, wb);
        ExcelUtils.setResponseHeader(response, fileName, wb);
    }

//    private void createTitle(HSSFWorkbook workbook, HSSFSheet sheet) {
//        HSSFRow row = sheet.createRow(0);
//        sheet.setColumnWidth(1, 12*256);
//        sheet.setColumnWidth(3, 17*256);
//
//        HSSFCell cell;
//        cell = row.createCell(0);
//        cell.setCellValue("车牌号");
//
//
//        cell = row.createCell(1);
//        cell.setCellValue("期限");
//
//        cell.setCellValue("结束时间");
//        cell = row.createCell(2);
//    }
//
//    @RequestMapping(value = "/exportTest")
//    public String exportTest(HttpServletResponse response) throws Exception {
//        HSSFWorkbook workbook = new HSSFWorkbook();
//        HSSFSheet sheet = workbook.createSheet("统计表");
//        createTitle(workbook, sheet);
//        List<SpecialCar> rows = specialCarService.exportTest();
//
//        int rowNum = 1;
//        for (SpecialCar specialCar : rows) {
//            HSSFRow row = sheet.createRow(rowNum);
//            row.createCell(0).setCellValue(specialCar.getCarLicense());
//            row.createCell(1).setCellValue(specialCar.getRestrictType());
//            row.createCell(2).setCellValue(specialCar.getEndDate());
//            rowNum++;
//        }
//
//        String fileName = "d栗子.xls";
//        //生成excel文件
//        buildExcelFile(fileName, workbook);
//
//        //浏览器下载excel
//        buildExcelDocument(fileName,workbook,response);
//
//        return "download excel";
//    }
//    //生成excel文件
//    protected void buildExcelFile(String filename,HSSFWorkbook workbook) throws Exception{
//        FileOutputStream fos = new FileOutputStream(filename);
//        workbook.write(fos);
//        fos.flush();
//        fos.close();
//    }
//
//    //浏览器下载excel
//    protected void buildExcelDocument(String filename,HSSFWorkbook workbook,HttpServletResponse response) throws Exception{
//        response.setContentType("application/vnd.ms-excel");
//        response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(filename, "utf-8"));
//        OutputStream outputStream = response.getOutputStream();
//        workbook.write(outputStream);
//        outputStream.flush();
//        outputStream.close();
//    }

}
