package com.anhen.excel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName TestExecl
 * @Description excel的读取导出
 * @Author wuxiaojian
 * @Date 2019/10/22 9:34
 * @Version 1.0
 **/

public class TestExecl {
    public static void main(String[] args) {
        read();
        write();
    }

    private static void read(){
        try {
            //创建工作簿
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new FileInputStream("E:\\ipGeoMapping.xlsx"));
            System.out.println("xssfWorkbook对象：" + xssfWorkbook);
            //读取第一个工作表
            XSSFSheet sheet = xssfWorkbook.getSheetAt(0);
            System.out.println("sheet对象：" + sheet);
            //获取最后一行的num，即总行数。此处从0开始计数
            int maxRow = sheet.getLastRowNum();
            System.out.println("总行数为：" + maxRow);
            for (int row = 0; row <= maxRow; row++) {
                //获取最后单元格num，即总单元格数 ***注意：此处从1开始计数***
                int maxRol = sheet.getRow(row).getLastCellNum();
                System.out.println("--------第" + row + "行的数据如下--------");
                for (int rol = 0; rol < maxRol; rol++){
                    System.out.print(sheet.getRow(row).getCell(rol) + "  ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void write(){
        //创建临时文件存放的路径
        String temp="E:\\temp\\excel\\";
        List<GeographicMapping> list = new ArrayList<>();
        GeographicMapping geographicMappingTemp = new GeographicMapping("127.0.0.1","中国","浙江","杭州","安恒信息");
        list.add(geographicMappingTemp);
        //创建工作簿
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        //创建工作表
        XSSFSheet sheet = xssfWorkbook.createSheet();
        xssfWorkbook.setSheetName(0,"地理映射表");
        //创建表头
        XSSFRow head = sheet.createRow(0);
        String[] heads = {"ip","国家","省","城市","单位"};
        for(int i = 0;i < 5;i++){
            XSSFCell cell = head.createCell(i);
            cell.setCellValue(heads[i]);
        }

        for (int i = 1;i <= list.size();i++) {
            GeographicMapping geographicMapping = list.get(i - 1);
            //创建行,从第二行开始，所以for循环的i从1开始取
            XSSFRow row = sheet.createRow(i);
            //创建单元格，并填充数据
            XSSFCell cell = row.createCell(0);
            cell.setCellValue(geographicMapping.getIp());
            cell = row.createCell(1);
            cell.setCellValue(geographicMapping.getCountry());
            cell = row.createCell(2);
            cell.setCellValue(geographicMapping.getProvince());
            cell = row.createCell(3);
            cell.setCellValue(geographicMapping.getCity());
            cell = row.createCell(4);
            cell.setCellValue(geographicMapping.getCompany());
        }
        //创建临时文件的目录
        File file = new File(temp);
        if(!file.exists()){
            file.mkdirs();
        }
        //临时文件路径/文件名
        String downloadPath = file + "\\"  +System.currentTimeMillis() + UUID.randomUUID() + "name.xlsx";
        OutputStream outputStream = null;
        try {
            //使用FileOutputStream将内存中的数据写到本地，生成临时文件
            outputStream = new FileOutputStream(downloadPath);
            xssfWorkbook.write(outputStream);
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
