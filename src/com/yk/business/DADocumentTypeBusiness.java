package com.yk.business;

import com.yk.dao.DADocumentTypeDao;
import com.yk.model.DADocumentType;
import com.yk.model.TypeNameJComboBox;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

import static com.yk.business.DocumentBusiness.documentCode;

public class DADocumentTypeBusiness {
    //表单数据通用方法
    private static Object[][] tableData(List<DADocumentType> list) {
        Object[][] data = new Object[list.size()][9];
        for (int i = 0; i < list.size(); i++) {
            data[i][0] = i + 1;
            data[i][1] = list.get(i).getTypeID();
            data[i][2] = list.get(i).getTypeNameEnglish();
            data[i][3] = list.get(i).getTypeNameChinese();
            data[i][4] = list.get(i).getState().toString().trim().equals("1") ? "启用" : "禁用";
            data[i][5] = list.get(i).getCreatetime();
        }

        return data;
    }

    //查询通用方法,状态为1启用
    public static DefaultTableModel queryTableModelQiYong() {
        Object[][] data = tableData(new DADocumentTypeDao().getQueryStateQiYong());
        DefaultTableModel tableModel = new DefaultTableModel(data, getHead()) {//设置第二列编辑
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 3) {
                    return true;
                } else {
                    return false;
                }

            }
        };
        return tableModel;
    }

    //查询通用方法,状态为2禁用
    public static DefaultTableModel queryTableModelPerformed() {
        Object[][] data = tableData(new DADocumentTypeDao().getQueryStatePerformed());
        DefaultTableModel tableModel = new DefaultTableModel(data, getHead()) {//设置第二列编辑
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 3) {
                    return true;
                } else {
                    return false;
                }

            }
        };
        return tableModel;
    }

    //查询通用方法,状态为2禁用
    public static DefaultTableModel queryTableModelAll() {
        Object[][] data = tableData(new DADocumentTypeDao().getQueryAll());
        DefaultTableModel tableModel = new DefaultTableModel(data, getHead()) {//设置第二列编辑
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 3) {
                    return true;
                } else {
                    return false;
                }

            }
        };
        return tableModel;
    }

    private static String[] getHead() {
        return new String[]{"序号", "类别编码", "英文名", "中文名", "状态", "创建时间"};
    }

    //文档类别管理批量修改
    public DADocumentType updateData(JTable table, int i) {
        DADocumentType dt = new DADocumentType();
        dt.setTypeID(table.getValueAt(i, 1));
        dt.setTypeNameEnglish(hanziZhuanPinyin.ToFirstChar(table.getValueAt(i, 3).toString()));
        dt.setTypeNameChinese(table.getValueAt(i, 3));
        dt.setState(table.getValueAt(i, 4).toString().trim().equals("启用") ? "1" : "2");
        dt.setCreatetime(table.getValueAt(i, 5));
        return dt;
    }

    //文档类别状态批量禁用
    public static DADocumentType updateStateProhiBituse(JTable table, int i) {
        DADocumentType dt = new DADocumentType();
        dt.setTypeID(table.getValueAt(i, 1));
        dt.setState("2");//2为禁用
        return dt;
    }

    //文档类别状态批量启用
    public void updateStateQiYong(JTable table, int i) {
        DADocumentType dt = new DADocumentType();
        dt.setTypeID(table.getValueAt(i, 1));
        dt.setState("1");//2为禁用
        new DADocumentTypeDao().updateStateQiYong(dt);
    }

    //计算JComboBox档案类别
    public static DefaultComboBoxModel QueryTypeNameEnglish() {
        DefaultComboBoxModel dbm = new DefaultComboBoxModel();
        List<TypeNameJComboBox> list = new DADocumentTypeDao().getQueryTypeNameEnglish();
        TypeNameJComboBox tjb = new TypeNameJComboBox();
        tjb.setTypeNameEnglish("MBBM");
        tjb.setTypeNameChinese("模板编码");
        list.add(0, tjb);

        list.forEach(dbm::addElement);
        return dbm;
    }

    public static DefaultComboBoxModel selectState() {
        DefaultComboBoxModel dbm = new DefaultComboBoxModel();
        List<DADocumentType> list = new DADocumentTypeDao().getQueryStateValue();
        dbm.addElement("全部");
        for (int i = 0; i < list.size(); i++) {
            dbm.addElement(list.get(i).getState().toString().trim().equals("1") ? "启用" : "禁用");
        }

        return dbm;
    }

    //选择档案类别英文名自动编码
    public static String queryCode(String code) {
        String dlyCode;
        String TpyeCode = documentCode(code);
        int count = 0;
        if (code.equals("模板编码")) {
            return "";
        }
        if (TpyeCode.equals("0")) {
            dlyCode = code + "-" + GuiVerification.nowTimeYear() + "-" + 1;
        } else {
            count = Integer.valueOf(TpyeCode.substring(TpyeCode.lastIndexOf("-") + 1, TpyeCode.length()).trim());
            count += 1;
            TpyeCode=TpyeCode.substring(0,TpyeCode.lastIndexOf("-")+1);
            dlyCode = TpyeCode + count;
        }
        return dlyCode;
    }

    //保存档案编码自动新增
    public static String saveQueryCode(String code) {
        String dlyCode;
        code=code.substring(0,code.indexOf("-"));
        String TpyeCode = documentCode(code);
        int count = 0;
        count = Integer.valueOf(TpyeCode.substring(TpyeCode.lastIndexOf("-") + 1, TpyeCode.length()).trim());
        count += 1;
        TpyeCode=TpyeCode.substring(0,TpyeCode.lastIndexOf("-")+1);
        dlyCode = TpyeCode + count;
        return dlyCode;
    }

    //档案新增，单个
    public static void insertDG(DADocumentType da) {
        new DADocumentTypeDao().insert(da);
    }
}
