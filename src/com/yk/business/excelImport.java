package com.yk.business;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.yk.model.DocumentManagement;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * Title: excelTest
 * Description: excel表格读取
 * 注意:引用poi 架包版本要一致
 * 如:
 * poi-4.0.0.jar
 * poi-ooxml-4.0.0.jar
 * poi-ooxml-schemas-4.0.0.jar
 * poi-scratchpad-4.0.0.jar
 * @author pancm
 */
public class excelImport {
    public static  List<DocumentManagement> readExcel(String str) throws FileNotFoundException, IOException{
        File file=new File(str);
        // HSSFWorkbook 2003的excel .xls,XSSFWorkbook导入2007的excel   .xlsx
        // HSSFWorkbook workbook=new HSSFWorkbook(new FileInputStream(new File(file)));
        InputStream is = new FileInputStream(file);
        XSSFWorkbook workbook=new XSSFWorkbook(is);
        Sheet sheet=workbook.getSheetAt(0);//读取第一个 sheet
        List<DocumentManagement> list= new ArrayList<>();
        Row row=null;
        int rowCount=sheet.getPhysicalNumberOfRows();
        //逐行处理 excel 数据
        for (int i = 3; i <rowCount; i++) {
            row=sheet.getRow(i);
            com.yk.model.DocumentManagement dm=new com.yk.model.DocumentManagement();
            dm.setDocumentcoding(row.getCell(0));
            dm.setPersonliable(row.getCell(1));
            dm.setTheme(row.getCell(2));
            dm.setTitle(row.getCell(3));
            //execl数字取值为float类型，截取.号之前的值
            dm.setThenumberofpages(row.getCell(4).toString().substring(0,row.getCell(4).toString().indexOf(".")).trim());
            dm.setArchivalyear(row.getCell(5).toString().substring(0,row.getCell(5).toString().indexOf(".")).trim());
            dm.setStorageposition(row.getCell(6));
            dm.setRemarks(row.getCell(7));
            dm.setCreatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()));
            list.add(dm);
        }
        workbook.close();

        return list;
    }

    /**
     * 写入Excel表格内容
     * @throws FileNotFoundException
     * @throws IOException
     */
   /* @SuppressWarnings({ "resource", "rawtypes", "unchecked" })
    private static void writeExcel(String str) throws FileNotFoundException, IOException{
        File file=new File(str);
        // HSSFWorkbook 2003的excel .xls,XSSFWorkbook导入2007的excel   .xlsx
//      HSSFWorkbook workbook=new HSSFWorkbook(new FileInputStream(new File(file)));
        XSSFWorkbook workbook=new XSSFWorkbook(new FileInputStream(file));
        List resultList =new ArrayList<>();

        Sheet sheet1 = workbook.createSheet();//创建 sheet 对象
        Row row = sheet1.createRow(0);//第一行，标题
        row.createCell(0).setCellValue("A");
        row.createCell(1).setCellValue("B");
        row.createCell(2).setCellValue("C");
        row.createCell(3).setCellValue("D");
        row.createCell(4).setCellValue("E");
        //拼接数据
        for(int i=1;i<=10;i++){
            *//*JSONObject json1=new JSONObject();
            json1.put("A", i);
            json1.put("B", i*2);
            json1.put("C", i*3);
            json1.put("D", i*4);
            json1.put("E", i*5);
            resultList.add(json1);*//*
        }
        Row row1;
        for (int i = 1, len = resultList.size(); i <=len; i++) {//循环创建数据行
            //因为第一行已经设置了，所以从第二行开始
          *//*  row1 = sheet1.createRow(i);
            JSONObject json=(JSONObject) resultList.get(i-1);
            row1.createCell(0).setCellValue(json.getString("A"));
            row1.createCell(1).setCellValue(json.getString("B"));
            row1.createCell(2).setCellValue(json.getString("C"));
            row1.createCell(3).setCellValue(json.getString("D"));
            row1.createCell(4).setCellValue(json.getString("E"));*//*
        }
        *//*FileOutputStream fos = new FileOutputStream(path1);
        workbook.write(fos);//写文件
        fos.close();
        System.out.println("写入成功！");*//*
    }*/
}