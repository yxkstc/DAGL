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
        Row row1;//创建sheet1表行对象
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
        for (int i = 1;i <savetable.getRowCount(); i++) {
            //因为sheet1第一行已经设置了，所以从第二行开始
            row1 = sheet1.createRow(i);
            //写入sheet1行数据
            row1.createCell(0).setCellValue(savetable.getValueAt(i,0).toString());
            row1.createCell(1).setCellValue(savetable.getValueAt(i,1).toString());
            row1.createCell(2).setCellValue(savetable.getValueAt(i,2).toString());
            row1.createCell(3).setCellValue(savetable.getValueAt(i,3).toString());
            row1.createCell(4).setCellValue(savetable.getValueAt(i,4).toString());
            row1.createCell(5).setCellValue(savetable.getValueAt(i,5).toString());
            row1.createCell(6).setCellValue(savetable.getValueAt(i,6).toString());
            row1.createCell(7).setCellValue(savetable.getValueAt(i,7).toString());
            row1.createCell(8).setCellValue(savetable.getValueAt(i,8).toString());
        }
        FileOutputStream fos = new FileOutputStream(str);
        workbook.write(fos);//写文件
        fos.close();
    }
}