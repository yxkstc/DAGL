package com.yk.business;

import com.yk.dao.DAEnclosureDao;
import com.yk.model.DAEnclosure;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class DAEnclosureBusiness {
    //table显示内容，第一次加载
    public static DefaultTableModel queryTableModel(String enclosureCode) {
        Object[][] data = null;
        List<DAEnclosure> list = new DAEnclosureDao().getQuery(enclosureCode);
        data = new Object[list.size()][5];
        for (int i = 0; i < list.size(); i++) {
            data[i][0] = list.get(i).getEnclosureID();
            data[i][1] = i + 1;
            data[i][2] = list.get(i).getEnclosureCode();
            data[i][3] = list.get(i).getEnclosureName();
            data[i][4] = list.get(i).getCreatetime();
        }
        DefaultTableModel tableModel = new DefaultTableModel(data, getDAEnclosureHead()) {//设置第一列不能编辑
            @Override
            public boolean isCellEditable(int row, int column) {//所有列不能编辑
                return false;
            }
        };
        return tableModel;
    }

    //附件信息新增,除附件内容
    public static void insertEnclosure(DAEnclosure de) {
        new DAEnclosureDao().insert(de);
    }

    //附件内容新增
    public static void updateEnclosure(byte[] byteFile, String enclosureId) {
        new DAEnclosureDao().update(byteFile, enclosureId);
    }
    //附件名称查询
    public static String getEnclosureName(String enclosureId) {
        return new DAEnclosureDao().getQueryEnclosureName(enclosureId);
    }

    //文档类别批量修改
    public String deleteData(JTable table, int i) {
        return table.getValueAt(i, 0).toString();
    }

    //附件内容ID
    public static int queryEnclosureID(String enclosureCode){
        return new DAEnclosureDao().getEnclosureID(enclosureCode);
    }

    //附件表头
    private static String[] getDAEnclosureHead() {
        return new String[]{"附件ID", "序号", "档案号", "附件名称", "创建时间"};
    }

}
