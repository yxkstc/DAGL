package com.yk.business;

import com.yk.dao.DocumentManagementDao;
import com.yk.model.DocumentManagement;
import com.yk.model.TypeNameJComboBox;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.util.List;

public class DocumentBusiness {
    //查询编码
    public static String documentCode(String code) {
        return new DocumentManagementDao().tpyeCodeQuery(code + "-" + GuiVerification.nowTimeYear());
    }


    //导入数据，档案类别英文名自动编码
    public static DefaultTableModel queryTableModel(String path, TypeNameJComboBox tjb) throws IOException {
        List<DocumentManagement> list = excelImport.readExcel(path);
        String code = tjb.getTypeNameEnglish();
        String tpyeName = tjb.getTypeNameChinese();
        Object[][] data = DocumentData(list);
        String TpyeCode = documentCode(code);
        String dlyCode=TpyeCode.substring(0,TpyeCode.lastIndexOf("-")+1);
        int error=0;
        int count = 0;
        //查询数据库类别编码数值
        if(!TpyeCode.equals("0")){
            count = Integer.valueOf(TpyeCode.substring(TpyeCode.lastIndexOf("-") + 1, TpyeCode.length()).trim());
        }

        if (!code.equals("MBBM")) {
            for (int i = 0; i < list.size(); i++) {
                if (TpyeCode.equals("0")) {
                    if (i<9){
                        data[i][0] = code + "-" + GuiVerification.nowTimeYear() + "-" +"00"+ (i + 1);
                    }else if(i<99){
                        data[i][0] = code + "-" + GuiVerification.nowTimeYear() + "-" +"0"+ (i + 1);
                    }else if(i<999) {
                        data[i][0] = code + "-" + GuiVerification.nowTimeYear() + "-" + (i + 1);
                    }else {
                        data[i][0]=code + "-" + GuiVerification.nowTimeYear() + "-" + 999;
                        error=1;
                    }
                }else {
                    count++;
                    if(count<10){
                        data[i][0] = dlyCode + "00"+count;
                    } else if(count < 100){
                        data[i][0] = dlyCode + "0"+count;
                    }else if (count < 1000){
                        data[i][0] = dlyCode +count;
                    }else{
                        data[i][0]=dlyCode+999;
                        error=1;
                    }
                }
                data[i][3] = tpyeName;
            }

        }
        if (error==1){
            JOptionPane.showMessageDialog(null,"单个档案类别编码一年内最大编码已超过999,请重新选择档案类别");
            data=null;
        }

        DefaultTableModel tableModel = new DefaultTableModel(data, getHead()) {//设置第一列不能编辑
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0) {
                    return false;
                } else {
                    return true;
                }

            }
        };
        return tableModel;
    }

    //查询所有表单数据
    public static DefaultTableModel queryTableModel() {
        List<DocumentManagement> list = new DocumentManagementDao().getAll();//查询所有
        DefaultTableModel tableModel = new DefaultTableModel(DocumentData(list), getHead()) {//设置第一列不能编辑
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0) {
                    return false;
                } else {
                    return true;
                }

            }
        };
        return tableModel;
    }

    //组合查询表单数据
    public static DefaultTableModel queryTableModelZH(String Dlysql) {
        List<DocumentManagement> list = new DocumentManagementDao().CombinationQuery(Dlysql);//组合查询
        DefaultTableModel tableModel = new DefaultTableModel(DocumentData(list), getHead()) {//设置第一列不能编辑
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0) {
                    return false;
                } else {
                    return true;
                }

            }
        };
        return tableModel;
    }

    //导出数据算法
    public static DefaultTableModel selectTabel(int[] row, JTable table) {
        Object[][] data = new Object[row.length][9];
        for (int i = 0; i < row.length; i++) {
            data[i][0] = table.getValueAt(row[i], 0);
            data[i][1] = table.getValueAt(row[i], 1);
            data[i][2] = table.getValueAt(row[i], 2);
            data[i][3] = table.getValueAt(row[i], 3);
            data[i][4] = table.getValueAt(row[i], 4);
            data[i][5] = table.getValueAt(row[i], 5);
            data[i][6] = table.getValueAt(row[i], 6);
            data[i][7] = table.getValueAt(row[i], 7);
            data[i][8] = table.getValueAt(row[i], 8);
        }
        DefaultTableModel tableModel = new DefaultTableModel(data, getHead());
        return tableModel;
    }

    //table list转为Object数据类型
    private static Object[][] DocumentData(List<DocumentManagement> list) {
        Object[][] data = new Object[list.size()][9];
        for (int i = 0; i < list.size(); i++) {
            data[i][0] = list.get(i).getDocumentcoding();
            data[i][1] = list.get(i).getPersonliable();
            data[i][2] = list.get(i).getTheme();
            data[i][3] = list.get(i).getDocumentType();
            data[i][4] = list.get(i).getThenumberofpages();
            data[i][5] = list.get(i).getArchivalyear();
            data[i][6] = list.get(i).getStorageposition();
            data[i][7] = list.get(i).getRemarks();
            data[i][8] = list.get(i).getCreatetime();
        }
        return data;
    }

    //文档新增
    public static void insertDcoument(DocumentManagement dm) {
        new DocumentManagementDao().insert(dm);
    }

    //文档管理批量修改
    public static void updateData(JTable table, int i) {
        DocumentManagementDao dd = new DocumentManagementDao();
        DocumentManagement DM = new DocumentManagement();
        DM.setDocumentcoding(table.getValueAt(i, 0));
        DM.setPersonliable(table.getValueAt(i, 1));
        DM.setTheme(table.getValueAt(i, 2));
        DM.setDocumentType(table.getValueAt(i, 3));
        DM.setThenumberofpages(table.getValueAt(i, 4));
        DM.setArchivalyear(table.getValueAt(i, 5));
        DM.setStorageposition(table.getValueAt(i, 6));
        DM.setRemarks(table.getValueAt(i, 7));
        DM.setCreatetime(table.getValueAt(i, 8));
        dd.update(DM);
    }

    //档案表头
    private static String[] getHead() {
        return new String[]{"档案号", "责任人", "主题", "档案类别", "页数", "日期", "存储位置", "备注", "创建时间"};
    }
}
