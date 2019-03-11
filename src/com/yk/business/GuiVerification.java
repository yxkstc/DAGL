package com.yk.business;

import com.yk.dao.DocumentManagementDao;
import com.yk.model.DocumentManagement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class GuiVerification {
    public static int FieldVerification(String txt, String lable) {
        int count = 0;
        if (txt.equals("")) {
            JOptionPane.showMessageDialog(null, "请输入" + lable, "错误", JOptionPane.ERROR_MESSAGE);
            count = 1;
        }
        return count;
    }


    public static DefaultTableModel queryTableModel(List table) {
        Object[][] data=null;
        List<DocumentManagement> list=table;
        String head[]=new String[]{"档案号","责任人","主题","题名","页数","日期","存储位置","备注","创建时间"};
        data=new Object[list.size()][9];
        for(int i=0;i<list.size();i++){
            data[i][0]=list.get(i).getDocumentcoding();
            data[i][1]=list.get(i).getPersonliable();
            data[i][2]=list.get(i).getTheme();
            data[i][3]=list.get(i).getTitle();
            data[i][4]=list.get(i).getThenumberofpages();
            data[i][5]=list.get(i).getArchivalyear();
            data[i][6]=list.get(i).getStorageposition();
            data[i][7]=list.get(i).getRemarks();
            data[i][8]=list.get(i).getCreatetime();
        }
        DefaultTableModel tableModel=new DefaultTableModel(data,head){//设置第一列不能编辑
            @Override
            public boolean isCellEditable(int row,int column){
                if (column == 0) {
                    return false;
                }else {
                    return true;
                }

            }
        };
        return tableModel;
    }

    public  List<DocumentManagement>  GetModel(JTable table){
        List<DocumentManagement> list = new ArrayList<>();
        for (int i=0;i<table.getRowCount();i++){
            DocumentManagement DM=new DocumentManagement();
            DM.setDocumentcoding(table.getValueAt(i,0));
            DM.setPersonliable(table.getValueAt(i,1));
            DM.setTheme(table.getValueAt(i,2));
            DM.setTitle(table.getValueAt(i,3));
            DM.setThenumberofpages(table.getValueAt(i,4));
            DM.setArchivalyear(table.getValueAt(i,5));
            DM.setStorageposition(table.getValueAt(i,6));
            DM.setRemarks(table.getValueAt(i,7));
            DM.setCreatetime(table.getValueAt(i,8));
            list.add(DM);
        }
        return list;
   }
    //批量修改
    public void updateData(JTable table){
        List<DocumentManagement> list = null;
        for (int i=0;i<table.getRowCount();i++){
            DocumentManagement DM=new DocumentManagement();
            DM.setDocumentcoding(table.getValueAt(i,0));
            DM.setPersonliable(table.getValueAt(i,1));
            DM.setTheme(table.getValueAt(i,2));
            DM.setTitle(table.getValueAt(i,3));
            DM.setThenumberofpages(table.getValueAt(i,4));
            DM.setArchivalyear(table.getValueAt(i,5));
            DM.setStorageposition(table.getValueAt(i,6));
            DM.setRemarks(table.getValueAt(i,7));
            DM.setCreatetime(table.getValueAt(i,8));
            new DocumentManagementDao().update(DM);
        }
    }


}
