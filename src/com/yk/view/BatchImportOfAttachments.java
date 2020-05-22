/*
 * Created by JFormDesigner on Wed Apr 22 10:53:14 CST 2020
 */

package com.yk.view;

import com.yk.business.*;
import com.yk.model.DAEnclosure;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @author Brainrain
 */
public class BatchImportOfAttachments extends JPanel {
    BatchImportOfAttachments() {
        initComponents();
    }

    public static BatchImportOfAttachments getInstance() {
        if (instance == null) {
            synchronized (BatchImportOfAttachments.class) {
                if (instance == null) {
                    instance = new BatchImportOfAttachments();
                }
            }
        }
        return instance;
    }
    //导入数据
    private void button1ActionPerformed(ActionEvent e) throws IOException {
        // TODO add your code here
        initUploadingfiles();//读取上传数据
        if (table1.isEditing()) {//如果table在编辑中，取消table编辑状态，防止正在编辑数据没有被修改
            table1.getCellEditor().stopCellEditing();
        }

        if (textField1.getText().length() > 0) {
            table1.setModel(BatchImportOfAttachmentsBusiness.execlTableModel(textField1.getText()));
            //批量写入filesTable
        }
    }
    //批量上传附件
    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
        if(table1.getRowCount()==0){
            JOptionPane.showMessageDialog(null, "请先导入数据");
            return;
        }
        /*1、验证本地附件文件是否存在
         * 2、通过本地附件文件档案编码验证数据库是否有对应档案
         * 3、设置上传中状态
         * 4、验证附件大小是否大于20M
         * 5、验证附件文件是否为0KB*/
        for (int i=0;i<table1.getRowCount();i++){
            String EnclosureCode= table1.getValueAt(i,0).toString();
            String path = table1.getValueAt(i,1).toString();
            File file = new File(path);
            if(!file.exists()){//文件路径不存在
                table1.setValueAt("文件路径不存在",i,3);//文件上传错误信息
            }else {//文件路径存在
                if(DocumentBusiness.getCodeQuery(EnclosureCode).equals("0")){//文档不存在
                    table1.setValueAt("档案编码不存在",i,3);//文件上传错误信息
                }else {//文档存在
                    String filename = file.getName();//文件名称
                    byte[] byteFile = Base64Enclosure.encodeByteFile(path);
                    if(byteFile==null){//附件大小大于20M
                        table1.setValueAt("附件大小不能超过20M",i,3);//文件上传错误信息
                    }else {//附件大小小于20M
                        if (byteFile.length == 0) {
                            table1.setValueAt("上传文件内容不能为0字节",i,3);//文件上传错误信息
                        }else {//文件大小小于20M
                            //新增附件信息（除附件内容）
                            try {
                                DAEnclosure de = new DAEnclosure();
                                de.setEnclosureCode(EnclosureCode);
                                de.setEnclosureName(filename);
                                de.setCreatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()));
                                DAEnclosureBusiness.insertEnclosure(de);
                                int EnclosureID=DAEnclosureBusiness.queryEnclosureID(EnclosureCode);
                                DAEnclosureBusiness.updateEnclosure(byteFile,String.valueOf(EnclosureID));//附件存入数据库附件内容
                                table1.setValueAt("已上传",i,2);//文件上传状态
                                table1.setValueAt("",i,3);//初始化状态
                            } catch (Exception e1){
                                e1.printStackTrace( );
                                table1.setValueAt("附件传输错误，请重新上传",i,3);//文件上传状态
                            }
                        }
                    }
                }
            }
        }

    }

    private void initComponents() {
        chooser=new JFileChooser();
        textField1=new JTextField();
        m_popupMenu = new JPopupMenu();
        exportAllMenItem = new JMenuItem();
        exportMenItem = new JMenuItem();
        downloadchooser = new JFileChooser();
        m_popupMenu.setFont(new Font("宋体", Font.PLAIN, 15));
        exportAllMenItem.setText("全部导出execl");
        exportAllMenItem.setFont(new Font("宋体", Font.PLAIN, 15));
        exportMenItem.setText("未上传数据导出execl");
        exportMenItem.setFont(new Font("宋体", Font.PLAIN, 15));

        //创建JPopupMenu
        createPopupMenu();
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        button1 = new JButton();
        button2 = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        GridBagConstraints gbc;

        setLayout(new GridBagLayout());
        ((GridBagLayout)getLayout()).columnWidths = new int[] {101, 0, 77, 135, 0};
        ((GridBagLayout)getLayout()).rowHeights = new int[] {0, 0, 248, 0};
        ((GridBagLayout)getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 1.0, 1.0E-4};
        ((GridBagLayout)getLayout()).rowWeights = new double[] {0.0, 0.0, 1.0, 1.0E-4};

        button1.setText("\u4e0a\u4f20\u6570\u636e"); //NON-NLS
        button1.addActionListener(e -> {
            try {
                button1ActionPerformed(e);
            } catch (IOException e1) {
                e1.printStackTrace( );
            }
        });
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets.bottom = 5;
        gbc.insets.right = 5;
        add(button1, gbc);

        button2.setText("\u6279\u91cf\u5bfc\u5165"); //NON-NLS
        button2.addActionListener(e -> button2ActionPerformed(e));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets.bottom = 5;
        gbc.insets.right = 5;
        add(button2, gbc);

        scrollPane1.setViewportView(table1);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 4;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.BOTH;
        add(scrollPane1, gbc);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        table1.setFont(new Font("宋体", Font.PLAIN, 15));
        button1.setFont(new Font("宋体", Font.PLAIN, 15));
        button2.setFont(new Font("宋体", Font.PLAIN, 15));
        //增加右键菜单
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mouseRightButtonClick(evt);
                //jTable1MouseClicked(evt);
            }
        });
        setName("文档附件批量导入");
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JButton button1;
    private JButton button2;
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private static BatchImportOfAttachments instance;
    private JFileChooser chooser;
    private JTextField textField1;
    private JPopupMenu m_popupMenu;
    private JMenuItem exportAllMenItem;
    private JMenuItem exportMenItem;
    private JFileChooser downloadchooser;

    //创建JPopupMenu事件
    private void createPopupMenu() {
        //导出全部
        exportAllMenItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {//该操作需要做的事
                String path=initSaveingfiles();
                //文件路径为空，不做任何操作
                if (path == null) return;//此代码防止点击关闭报文件路径错误
                try {
                    //调用导出功能
                    new excelImport().writeExcelBatchImportOfAttachment(path,table1.getModel());
                    JOptionPane.showMessageDialog(null, "导出成功");
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        });
        //导出选中
        exportMenItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {//该操作需要做的事
                String path=initSaveingfiles();
                //文件路径为空，不做任何操作
                if (path == null) return;//此代码防止点击关闭报文件路径错误
                try {
                    //调用导出功能
                    new excelImport().writeExcelBatchImportOfAttachment(path, BatchImportOfAttachmentsBusiness.selectTabel(table1));
                    JOptionPane.showMessageDialog(null, "导出成功");
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        });
        m_popupMenu.add(exportAllMenItem);
        m_popupMenu.add(exportMenItem);
    }

    //鼠标右键点击事件
    private void mouseRightButtonClick(java.awt.event.MouseEvent evt) {
        //判断是否为鼠标的BUTTON3按钮，BUTTON3为鼠标右键
        if (evt.getButton() == java.awt.event.MouseEvent.BUTTON3) {
            //选中行点击右键，在数据范围且鼠标位置显示右键菜单。未选中数据无法触发右键菜单
            int focusedRowIndex = table1.rowAtPoint(evt.getPoint());
            if (focusedRowIndex == -1 || table1.getSelectedRow() == -1) {
                return;
            }
            //将表格所选项设为当前右键点击的行
            //Archivesquery.setRowSelectionInterval(focusedRowIndex, focusedRowIndex);
            //弹出菜单
            m_popupMenu.show(table1, evt.getX(), evt.getY());
        }

    }

    /**
     * @initUploadingfiles 初始化上传事件，获取选择文件路径
     */
    private String initSaveingfiles() {
        String path = null;
        String defaultDisk = "附件批量导入" + GuiVerification.nowtime() + ".xls";
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel 97-2003文件", "xls");
        downloadchooser.setDialogTitle("请选择要保存的路径...");
        downloadchooser.setApproveButtonText("保存");
        downloadchooser.setFileSelectionMode(JFileChooser.FILES_ONLY);//只能选文件夹
        downloadchooser.setSelectedFile(new File(defaultDisk));//设置默认文件名
        downloadchooser.setFileFilter(filter);//设置文件类型
        if (JFileChooser.APPROVE_OPTION == downloadchooser.showSaveDialog(this)) {
            path = downloadchooser.getSelectedFile().getPath();
        }
        return path;
    }

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
