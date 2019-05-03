/*
 * Created by JFormDesigner on Wed Nov 21 15:11:30 CST 2018
 */

package com.yk.view;

import com.yk.business.DADocumentTypeBusiness;
import com.yk.business.DocumentBusiness;
import com.yk.model.DocumentManagement;
import com.yk.model.TypeNameJComboBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;


public class Batchimport extends JPanel {
    public Batchimport() {
        initComponents();
    }

    public static Batchimport getInstance() {
        if (instance == null) {
            synchronized (Batchimport.class) {
                if (instance == null) {
                    instance = new Batchimport();
                }
            }
        }
        return instance;
    }

    /**
     * @UploadingfilesActionPerformed 上传事件
     */
    private void UploadingfilesActionPerformed(ActionEvent e) throws IOException {
        // TODO add your code here
        initUploadingfiles();//读取上传数据
        if (filesTable.isEditing()) {//如果table在编辑中，取消table编辑状态，防止正在编辑数据没有被修改
            filesTable.getCellEditor().stopCellEditing();
        }

        if (textField1.getText().length() > 0) {
            TypeNameJComboBox tjb = (TypeNameJComboBox) comboBox.getSelectedItem();
            filesTable.setModel(DocumentBusiness.queryTableModel(textField1.getText(), tjb));//批量写入filesTable
        }
    }

    /**
     * @SaveActionPerformed 保存事件
     */
    private void SaveActionPerformed(ActionEvent e) {
        // TODO add your code here
        try {
            if (filesTable.getRowCount() > 0) {
                int rowCount = filesTable.getRowCount();
                for (int i = 0; i < rowCount; i++) {
                    DocumentManagement dm = new DocumentManagement();
                    com.yk.dao.DocumentManagementDao dmd = new com.yk.dao.DocumentManagementDao();
                    dm.setDocumentcoding(filesTable.getValueAt(i, 0));
                    dm.setPersonliable(filesTable.getValueAt(i, 1));
                    dm.setTheme(filesTable.getValueAt(i, 2));
                    dm.setDocumentType(filesTable.getValueAt(i, 3));
                    dm.setThenumberofpages(filesTable.getValueAt(i, 4));
                    dm.setArchivalyear(filesTable.getValueAt(i, 5));
                    dm.setStorageposition(filesTable.getValueAt(i, 6));
                    dm.setRemarks(filesTable.getValueAt(i, 7));
                    dm.setCreatetime(filesTable.getValueAt(i, 8));
                    dmd.insert(dm);
                }
                JOptionPane.showMessageDialog(null, "保存成功");
            }

        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, e1.getMessage());
        }

    }

    public void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        Uploadingfiles = new JButton();
        textField1 = new JTextField();
        Save = new JButton();
        scrollPane1 = new JScrollPane();
        filesTable = new JTable();
        chooser = new JFileChooser();
        comboBox = new JComboBox();

        this.setLayout(new GridBagLayout());
        ((GridBagLayout) this.getLayout()).columnWidths = new int[]{112, 0, 0};
        ((GridBagLayout) this.getLayout()).rowHeights = new int[]{41, 38, 0, 0};
        ((GridBagLayout) this.getLayout()).columnWeights = new double[]{0.0, 1.0, 1.0E-4};
        ((GridBagLayout) this.getLayout()).rowWeights = new double[]{0.0, 0.0, 1.0, 1.0E-4};

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
        this.add(comboBox, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));
        this.add(Save, new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));
        scrollPane1.setViewportView(filesTable);
        this.add(scrollPane1, new GridBagConstraints(0, 1, 5, 0, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        comboBox.setFont(new Font("宋体", Font.PLAIN, 15));
        Uploadingfiles.setFont(new Font("宋体", Font.PLAIN, 15));
        Save.setFont(new Font("宋体", Font.PLAIN, 15));
        comboBox.setModel(DADocumentTypeBusiness.QueryTypeNameEnglish());
        this.setName("EXECL批量导入");
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JButton Uploadingfiles;
    private JTextField textField1;
    private JButton Save;
    private JScrollPane scrollPane1;
    private JTable filesTable;
    private JFileChooser chooser;
    private JComboBox comboBox;
    private static Batchimport instance;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    /**
     * @initUploadingfiles 初始化上传事件，获取选择文件路径
     */
    private void initUploadingfiles() {
        String path = null;
        chooser.setDialogTitle("请选择要上传的文件...");
        chooser.setApproveButtonText("确定");
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (JFileChooser.APPROVE_OPTION == chooser.showOpenDialog(this)) {
            path = chooser.getSelectedFile().getPath();
            textField1.setText(path);
        }
    }
}
