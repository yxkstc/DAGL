/*
 * Created by JFormDesigner on Wed Nov 21 15:11:30 CST 2018
 */

package com.yk.view;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import com.yk.model.DocumentManagement;
import java.io.IOException;
import com.yk.business.*;


public class Batchimport extends JPanel {
    public Batchimport(){
        initComponents();
    }

    /**
     * @UploadingfilesActionPerformed 上传事件
     */
    private void UploadingfilesActionPerformed(ActionEvent e) throws IOException {
        // TODO add your code here

        initUploadingfiles();//读取上传数据
        if (filesTable.isEditing()){//如果table在编辑中，取消table编辑状态，防止正在编辑数据没有被修改
            filesTable.getCellEditor().stopCellEditing();
        }

        if(textField1.getText().length()>0){
            filesTable.setModel( GuiVerification.queryTableModel(excelImport.readExcel(textField1.getText())));//批量写入数据库
        }else {
            return;
        }
    }
    /**
     * @SaveActionPerformed 保存事件
     */
    private void SaveActionPerformed(ActionEvent e) {
        // TODO add your code here
        try {
            if (filesTable.getRowCount()>0){
                int rowCount=filesTable.getRowCount();
                for (int i=0;i<rowCount;i++){
                    DocumentManagement dm=new DocumentManagement();
                    com.yk.dao.DocumentManagementDao dmd=new com.yk.dao.DocumentManagementDao();
                    dm.setDocumentcoding(filesTable.getValueAt(i,0));
                    dm.setPersonliable(filesTable.getValueAt(i,1));
                    dm.setTheme( filesTable.getValueAt(i,2));
                    dm.setDocumentType(filesTable.getValueAt(i,3));
                    dm.setThenumberofpages(filesTable.getValueAt(i,4));
                    dm.setArchivalyear(filesTable.getValueAt(i,5));
                    dm.setStorageposition( filesTable.getValueAt(i,6));
                    dm.setRemarks( filesTable.getValueAt(i,7));
                    dm.setCreatetime(filesTable.getValueAt(i,8));
                    dmd.insert(dm);
                }
                JOptionPane.showMessageDialog(null, "保存成功");
            }

        }catch (Exception e1){
            JOptionPane.showMessageDialog(null, "保存失败", "失败", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        Uploadingfiles = new JButton();
        textField1 = new JTextField();
        Save = new JButton();
        scrollPane1 = new JScrollPane();
        filesTable = new JTable();
        chooser=new JFileChooser();

        this.setLayout(new GridBagLayout());
        ((GridBagLayout)this.getLayout()).columnWidths =  new int[] {112, 0, 0};
        ((GridBagLayout)this.getLayout()).rowHeights =  new int[] {41, 38, 0, 0};
        ((GridBagLayout)this.getLayout()).columnWeights = new double[] {0.0, 1.0, 1.0E-4};
        ((GridBagLayout)this.getLayout()).rowWeights = new double[] {0.0, 0.0, 1.0, 1.0E-4};

        Uploadingfiles.setText("\u9009\u62e9\u4e0a\u4f20\u6587\u4ef6");
        Uploadingfiles.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 20));
        Uploadingfiles.addActionListener(e -> {
            try {
                UploadingfilesActionPerformed(e);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        this.add(Uploadingfiles, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

        this.add(textField1, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));


        Save.setText("\u786e\u8ba4\u4e0b\u8868\u6570\u636e\u65e0\u8bef\u540e\u6279\u91cf\u5199\u5165\u6570\u636e\u5e93"); //NON-NLS
        Save.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 20)); //NON-NLS
        Save.addActionListener(e -> SaveActionPerformed(e));
        this.add(Save, new GridBagConstraints(0, 1, 2, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

        scrollPane1.setViewportView(filesTable);
        this.add(scrollPane1, new GridBagConstraints(0, 2, 2, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        this.setName("EXECL批量导入");
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JButton Uploadingfiles;
    private JTextField textField1;
    private JButton Save;
    private JScrollPane scrollPane1;
    private JTable filesTable;
    private JFileChooser chooser;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    /**
     * @initUploadingfiles 初始化上传事件，获取选择文件路径
     */
    private void  initUploadingfiles() {
        String path=null;
        chooser.setDialogTitle("请选择要上传的文件...");
        chooser.setApproveButtonText("确定");
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (JFileChooser.APPROVE_OPTION == chooser.showOpenDialog(this)) {
            path=chooser.getSelectedFile().getPath();
            textField1.setText(path);
        }
    }
}
