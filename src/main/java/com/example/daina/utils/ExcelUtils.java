package com.example.daina.utils;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author: Daina
 * @description:
 * @date: Created in 17:33 2019/4/8
 */
public class ExcelUtils {
    public static XSSFWorkbook getXSSFWorkbook(String sheetName, String header, String[] title, String[][] values, XSSFWorkbook wb) {

        // 第一步，创建一个XSSFWorkbook，对应一个Excel文件
        if (wb == null) {
            wb = new XSSFWorkbook();
        }

        // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
        XSSFSheet sheet = wb.getSheet(sheetName);

        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
        XSSFRow row = sheet.createRow(0);

        //声明列对象
        XSSFCell cell;
        cell = row.createCell(0);
        cell.setCellValue(header);

        // 表头标题样式
        XSSFFont headFont = wb.createFont();
        headFont.setFontName("宋体");
        // 字体加粗
        headFont.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
        // 字体大小
        headFont.setFontHeightInPoints((short) 20);
        XSSFCellStyle headStyle = wb.createCellStyle();
        headStyle.setFont(headFont);
        // 左右居中
        headStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        // 上下居中
        headStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        headStyle.setLocked(true);
        //起始行号，终止行号， 起始列号，终止列号
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, title.length - 1));
        row.setHeight((short) 0x480);
        cell.setCellStyle(headStyle);


        //内容样式
        XSSFFont valueFont = wb.createFont();
        valueFont.setFontName("微软雅黑");
        // 字体大小
        valueFont.setFontHeightInPoints((short) 10);
        XSSFCellStyle valueStyle = wb.createCellStyle();
        valueStyle.setFont(valueFont);
        // 左右居中
        valueStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        // 上下居中
        valueStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        valueStyle.setLocked(true);
        //边框
        valueStyle.setBorderBottom(BorderStyle.THIN);
        valueStyle.setBorderLeft(BorderStyle.THIN);
        valueStyle.setBorderRight(BorderStyle.THIN);
        valueStyle.setBorderTop(BorderStyle.THIN);

        //标题样式
        XSSFFont titleFont = wb.createFont();
        titleFont.setFontName("宋体");
        // 字体加粗
        titleFont.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
        // 字体大小
        titleFont.setFontHeightInPoints((short) 13);
        XSSFCellStyle titleStyle = wb.createCellStyle();
        titleStyle.setFont(titleFont);
        titleStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
        //填充方案
        titleStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        // 左右居中
        titleStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        // 上下居中
        titleStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        titleStyle.setLocked(true);
        //边框
        titleStyle.setBorderBottom(BorderStyle.THIN);
        titleStyle.setBorderLeft(BorderStyle.THIN);
        titleStyle.setBorderRight(BorderStyle.THIN);
        titleStyle.setBorderTop(BorderStyle.THIN);

        XSSFRow row1 = sheet.createRow(1);
        row1.setHeight((short) 0x150);
        //创建标题
        for (int i = 0; i < title.length; i++) {
            cell = row1.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(titleStyle);
        }

        //创建内容
        for (int i = 0; i < values.length; i++) {
            row = sheet.createRow(i + 2);
            for (int j = 0; j < values[i].length; j++) {
                //将内容按顺序赋给对应的列对象
                XSSFCell valueCell = row.createCell(j);
                valueCell.setCellValue(values[i][j]);
                valueCell.setCellStyle(valueStyle);
            }
            //设置行高
            row.setHeight((short) 0x130);
        }
        return wb;
    }

    //发送响应流方法
    public static void setResponseHeader(HttpServletResponse response, String fileName, XSSFWorkbook wb) {

        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        try {
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName.getBytes("utf-8"));
            /*response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");*/
            OutputStream os;
            os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
