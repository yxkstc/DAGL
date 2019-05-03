/*
 * Created by JFormDesigner on Sat Apr 13 23:51:37 CST 2019
 */

package com.yk.view;


import com.yk.business.Base64Enclosure;
import com.yk.business.DAEnclosureBusiness;
import com.yk.dao.DAEnclosureDao;
import com.yk.model.DAEnclosure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author Brainrain
 */
public class EnclosureManager extends JDialog {
    EnclosureManager(JFrame owner, String EnclosureCode) {
        super(owner);
        owner.setEnabled(false);
        initComponents();
        this.frame1 = owner;
        this.EnclosureCode = EnclosureCode;
        enclosureTable.setModel(DAEnclosureBusiness.queryTableModel(EnclosureCode));
    }

    EnclosureManager(Dialog owner, String EnclosureCode) {
        super(owner);
        initComponents();
        this.EnclosureCode = EnclosureCode;
        enclosureTable.setModel(DAEnclosureBusiness.queryTableModel(EnclosureCode));
    }

    //新增上传
    private void newaddActionPerformed(ActionEvent e) {
        // TODO add your code here
        try {
            initUploadingfiles();
            String path = uploadpath.getText();
            if (path.length() > 0) {//没有选择文件不执行
                File file = new File(path);
                //文件名称
                String filename = file.getName();
                byte[] byteFile = Base64Enclosure.encodeByteFile(path);
                if (byteFile == null) {
                    JOptionPane.showMessageDialog(null, "附件大小不能超过20M");
                    return;
                }
                if (byteFile.length == 0) {
                    JOptionPane.showMessageDialog(null, "上传文件内容不能为0字节");
                    return;
                }
                DAEnclosure de = new DAEnclosure();
                de.setEnclosureCode(EnclosureCode);
                de.setEnclosureName(filename);
                //de.setEnclosureContent(byteFile);
                de.setCreatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()));
                DAEnclosureBusiness.insertEnclosure(de);//存入数据库附件信息,除附件内容
                enclosureTable.setModel(DAEnclosureBusiness.queryTableModel(EnclosureCode));//刷新附件信息
                DAEnclosureBusiness.updateEnclosure(byteFile, enclosureTable.getValueAt(0, 0).toString());//二进制存入数据库附件内容
                JOptionPane.showMessageDialog(null, "上传成功");
            }
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, e1.getMessage());
        }
    }

    //下载附件
    private void downloadActionPerformed(ActionEvent e) {
        // TODO add your code here
        int row = enclosureTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "请选择需要下载的附件");
            return;
        }
        String EnclosureName = new DAEnclosureDao().getQueryEnclosureName(enclosureTable.getValueAt(row, 0).toString());
        byte[] Enclosure = new DAEnclosureDao().getQueryEnclosure(enclosureTable.getValueAt(row, 0).toString());
        String path = initdownloadfiles(EnclosureName);
        if (path == null) {//防住未输入路径异常
            return;
        }
        Base64Enclosure.decoderByteFile(Enclosure, path);
        JOptionPane.showMessageDialog(null, "下载成功");
    }

    //关闭
    private void closeActionPerformed(ActionEvent e) {
        // TODO add your code here
        frame1.setEnabled(true);
        this.dispose();
    }

    //删除
    private void deleteActionPerformed(ActionEvent e) {
        // TODO add your code here
        try {
            int rows[] = enclosureTable.getSelectedRows();
            if (enclosureTable.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "请选中需要删除的数据");
            } else {
                int isDelete = JOptionPane.showConfirmDialog(null, "确认删除", "提示", JOptionPane.YES_NO_OPTION);
                if (isDelete == JOptionPane.YES_NO_OPTION) {
                    for (int row : rows) {
                        DAEnclosureDao dd = new DAEnclosureDao();
                        dd.delete(new DAEnclosureBusiness().deleteData(enclosureTable, row));
                    }
                    JOptionPane.showMessageDialog(null, "删除成功");
                    enclosureTable.setModel(DAEnclosureBusiness.queryTableModel(EnclosureCode));//刷新JTable
                }
            }
        } catch (HeadlessException e1) {
            e1.printStackTrace();
            JOptionPane.showMessageDialog(null, e1.getMessage());//弹出异常消息
        }
    }


    private void initComponents() {
        uploadchooser = new JFileChooser();
        downloadpath = new JTextField();
        uploadpath = new JTextField();
        downloadchooser = new JFileChooser();
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar1 = new JMenuBar();
        newadd = new JButton();
        download = new JButton();
        close = new JButton();
        delete = new JButton();
        scrollPane1 = new JScrollPane();
        enclosureTable = new JTable();

        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout) contentPane.getLayout()).columnWidths = new int[]{481, 0};
        ((GridBagLayout) contentPane.getLayout()).rowHeights = new int[]{299, 0};
        ((GridBagLayout) contentPane.getLayout()).columnWeights = new double[]{1.0, 1.0E-4};
        ((GridBagLayout) contentPane.getLayout()).rowWeights = new double[]{1.0, 1.0E-4};


        newadd.setText("\u65b0\u589e"); //NON-NLS
        newadd.setFont(new Font("宋体", Font.PLAIN, 15));
        newadd.addActionListener(e -> newaddActionPerformed(e));
        menuBar1.add(newadd);

        download.setText("\u4e0b\u8f7d"); //NON-NLS
        download.setFont(new Font("宋体", Font.PLAIN, 15));
        download.addActionListener(e -> downloadActionPerformed(e));
        menuBar1.add(download);

        close.setText("\u5173\u95ed"); //NON-NLS
        close.setFont(new Font("宋体", Font.PLAIN, 15));
        close.addActionListener(e -> closeActionPerformed(e));
        menuBar1.add(close);

        delete.setText("\u5220\u9664"); //NON-NLS
        delete.setFont(new Font("宋体", Font.PLAIN, 15));
        delete.addActionListener(e -> deleteActionPerformed(e));
        menuBar1.add(delete);
        setJMenuBar(menuBar1);

        enclosureTable.setFont(new Font("宋体", Font.PLAIN, 15));
        scrollPane1.setViewportView(enclosureTable);
        contentPane.add(scrollPane1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        Color c = new Color(0, 0, 0, 255);//背影颜色随便设任意值,只起占位作用。
        newadd.setBackground(c);
        newadd.setOpaque(false);//设置透明
        newadd.setBorderPainted(false);//不绘制边框
        download.setBackground(c);
        download.setOpaque(false);//设置透明
        download.setBorderPainted(false);//不绘制边框
        close.setBackground(c);
        close.setOpaque(false);//设置透明
        close.setBorderPainted(false);//不绘制边框
        delete.setBackground(c);
        delete.setOpaque(false);//设置透明
        delete.setBorderPainted(false);//不绘制边框
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar menuBar1;
    private JButton newadd;
    private JButton download;
    private JButton close;
    private JButton delete;
    private JScrollPane scrollPane1;
    private JTable enclosureTable;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private JTextField uploadpath;
    private JTextField downloadpath;
    private JFileChooser uploadchooser;
    private JFileChooser downloadchooser;
    private String EnclosureCode;
    private JFrame frame1;

    /**
     * @initUploadingfiles 初始化上传事件，获取选择文件路径
     */
    private void initUploadingfiles() {
        String path = null;
        uploadchooser.setDialogTitle("请选择要上传的文件...");
        uploadchooser.setApproveButtonText("确定");
        uploadchooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (JFileChooser.APPROVE_OPTION == uploadchooser.showOpenDialog(this)) {
            path = uploadchooser.getSelectedFile().getPath();
            uploadpath.setText(path);
        }
    }

    /**
     * @initUploadingfiles 初始化上传事件，获取选择文件路径
     */
    private String initdownloadfiles(String defaultDisk) {
        String path = null;
        downloadchooser.setDialogTitle("请选择要下载的文件...");
        downloadchooser.setApproveButtonText("确定");
        downloadchooser.setFileSelectionMode(JFileChooser.FILES_ONLY);//只能选文件夹
        downloadchooser.setSelectedFile(new File(defaultDisk));//设置默认文件名
        if (JFileChooser.APPROVE_OPTION == downloadchooser.showSaveDialog(this)) {
            path = downloadchooser.getSelectedFile().getPath();
            downloadpath.setText(path);
        }
        return path;
    }

    //重写JFrame关闭事件
    @Override
    protected void processWindowEvent(WindowEvent e) {
        //这里需要对进来的WindowEvent进行判断，因为，不仅会有窗口关闭的WindowEvent进来，还可能有其他的WindowEvent进来
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            frame1.setEnabled(true);
            dispose();
        }
    }
}
