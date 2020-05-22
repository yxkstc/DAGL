package com.yk.business;

import com.yk.model.BatchImportOfAttachmentsModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.util.List;

public class BatchImportOfAttachmentsBusiness {
    //table 数据格式转换DefaultTableModel
    public static DefaultTableModel execlTableModel(String path) throws IOException {
        List<BatchImportOfAttachmentsModel> list = excelImport.readExcelBatchImportOfAttachment(path);//组合查询
        DefaultTableModel tableModel = new DefaultTableModel(BatchImportOfAttachmentsData(list),getHead()) {//设置第一列不能编辑
            @Override
            public boolean isCellEditable(int row, int column) {
                return column != 0 && column != 2 && column != 3;
            }
        };
        return tableModel;
    }

    //table list转为Object数据类型
    private static Object[][] BatchImportOfAttachmentsData(List<BatchImportOfAttachmentsModel> list) {
        Object[][] data = new Object[list.size( )][4];
        for (int i = 0; i < list.size( ); i++) {
            data[i][0] = list.get(i).getDocumentcoding( );
            data[i][1] = list.get(i).getPath( );
            data[i][2] = list.get(i).getState( );
            data[i][3] = list.get(i).getErrorMessage( );
        }
        return data;
    }

    //导出数据算法(根据JTalbe数据导出)
    public static DefaultTableModel selectTabel(JTable table) {
        Object[][] data = new Object[table.getRowCount()][table.getColumnCount()];
        for (int i = 0; i < table.getRowCount(); i++) {
            if(table.getValueAt(i,2).toString().equals("未上传")){
                data[i][0] = table.getValueAt(i, 0);
                data[i][1] = table.getValueAt(i, 1);
                data[i][2] = table.getValueAt(i, 2);
                data[i][3] = table.getValueAt(i, 3);
            }
        }
        DefaultTableModel tableModel = new DefaultTableModel(data, getHead());
        return tableModel;
    }

    //附件批量导入表头
    private static String[] getHead(){
        return new String[]{"档案号", "路径", "状态","错误信息"};
    }
}
