package com.yk.business;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.yk.model.DocumentManagement;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import javax.swing.table.TableModel;

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
            String row0=row.getCell(0)==null?"":row.getCell(0).toString();
            String row1=row.getCell(1)==null?"":row.getCell(1).toString();
            String row2=row.getCell(2)==null?"":row.getCell(2).toString();
            String row3=row.getCell(3)==null?"":row.getCell(3).toString();
            String row4=row.getCell(4)==null?"":row.getCell(4).toString();
            String row5=row.getCell(5)==null?"":row.getCell(5).toString();
            String row6=row.getCell(6)==null?"":row.getCell(6).toString();
            String row7=row.getCell(7)==null?"":row.getCell(7).toString();
            String subrow4;
            String subrow5;
            if (row4.trim().length()>0){
                subrow4=row4.substring(row4.trim().length()-2,row4.trim().length()).equals(".0")?row4.substring(0,row4.indexOf(".")):row4;
            }else {
                subrow4=row4;
            }
            if (row5.length()>0){
                subrow5=row5.substring(row5.trim().length()-2,row5.trim().length()).equals(".0")?row5.substring(0,row5.indexOf(".")):row5;
            }else {
                subrow5=row5;
            }
            dm.setDocumentcoding(row0);
            dm.setPersonliable(row1);
            dm.setTheme(row2);
            dm.setTitle(row3);
            dm.setThenumberofpages(subrow4);
            //execl数字取值为float类型，截取.号之前的值
            //String row_archivalyear= row.getCell(5).toString().length()>;
            //String s=row_archivalyear.substring(0,row_archivalyear.indexOf(".")).trim();
            //System.out.println(row.getCell(5));
            dm.setArchivalyear(subrow5);
            //dm.setArchivalyear(row.getCell(5).toString());
            dm.setStorageposition(row6);
            dm.setRemarks(row7);
            dm.setCreatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()));
            list.add(dm);
        }
        workbook.close();

        return list;
    }

    /**
     * table写入Excel表格内容
     * @throws FileNotFoundException
     * @throws IOException
     */
    @SuppressWarnings({ "resource", "rawtypes", "unchecked" })
    public  void writeExcel(String str,TableModel table) throws FileNotFoundException, IOException{
        // HSSFWorkbook 2003的excel .xls,XSSFWorkbook导入2007的excel   .xlsx
        //HSSFWorkbook workbook=new HSSFWorkbook(new FileInputStream(new File(file)));
        //XSSFWorkbook workbook=new XSSFWorkbook(new FileInputStream(file));
        //InputStream is = new FileInputStream(file);
        HSSFWorkbook workbook=new HSSFWorkbook();//定义输出方式为xls2003
        TableModel savetable =table;//输出数据源（流程超时表）
        Sheet sheet1 = workbook.createSheet("sheet1");//创建 sheet1 对象
        Row row = sheet1.createRow(0);//创建sheet1第一行标题对象
        //shee1标题赋值
        row.createCell(0).setCellValue(savetable.getColumnName(0));
        row.createCell(1).setCellValue(savetable.getColumnName(1));
        row.createCell(2).setCellValue(savetable.getColumnName(2));
        row.createCell(3).setCellValue(savetable.getColumnName(3));
        row.createCell(4).setCellValue(savetable.getColumnName(4));
        row.createCell(5).setCellValue(savetable.getColumnName(5));
        row.createCell(6).setCellValue(savetable.getColumnName(6));
        row.createCell(7).setCellValue(savetable.getColumnName(7));
        row.createCell(8).setCellValue(savetable.getColumnName(8));

        //数据源（流程超时表）遍历
        for (int i = 0;i <savetable.getRowCount(); i++) {
            //因为sheet1第一行已经设置了，所以从第二行开始
            row = sheet1.createRow(i+1);
            //写入sheet1行数据
            row.createCell(0).setCellValue(savetable.getValueAt(i,0).toString());
            row.createCell(1).setCellValue(savetable.getValueAt(i,1).toString());
            row.createCell(2).setCellValue(savetable.getValueAt(i,2).toString());
            row.createCell(3).setCellValue(savetable.getValueAt(i,3).toString());
            row.createCell(4).setCellValue(savetable.getValueAt(i,4).toString());
            row.createCell(5).setCellValue(savetable.getValueAt(i,5).toString());
            row.createCell(6).setCellValue(savetable.getValueAt(i,6).toString());
            row.createCell(7).setCellValue(savetable.getValueAt(i,7).toString());
            row.createCell(8).setCellValue(savetable.getValueAt(i,8).toString());
        }
        FileOutputStream fos = new FileOutputStream(str);
        workbook.write(fos);//写文件
        fos.close();
    }


}