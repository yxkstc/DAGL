/*
 * Created by JFormDesigner on Wed Nov 28 11:32:40 CST 2018
 */

package com.yk.view;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

import com.yk.business.GuiVerification;
import com.yk.business.excelImport;
import com.yk.dao.DocumentManagementDao;
import com.yk.model.DocumentManagement;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 * @author 档案查询
 */
public class Documentquery extends JPanel {

    public JPanel initComponents() {
        JPanel jp=new JPanel();
        Bquery = new JButton();
        Bedit = new JButton();
        Bdelete=new JButton();
        m_popupMenu = new JPopupMenu();
        exportAllMenItem = new JMenuItem();
        exportMenItem = new JMenuItem();
        chooser=new JFileChooser();
        m_popupMenu.setFont(new Font("宋体", Font.PLAIN, 15));
        exportAllMenItem.setText("全部导出execl");
        exportAllMenItem.setFont(new Font("宋体", Font.PLAIN, 15));
        exportMenItem.setText("选中数据导出execl");
        exportMenItem.setFont(new Font("宋体", Font.PLAIN, 15));
        //创建JPopupMenu
        createPopupMenu();
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        separator1 = new JSeparator();
        scrollPane1 = new JScrollPane();
        Archivesquery = new JTable();
        GridBagConstraints gbc;

        jp.setLayout(new GridBagLayout());
        ((GridBagLayout)jp.getLayout()).columnWidths = new int[] {0, 0, 0, 289, 0};
        ((GridBagLayout)jp.getLayout()).rowHeights = new int[] {42, 0, 0, 0, 0};
        ((GridBagLayout)jp.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 1.0, 1.0E-4};
        ((GridBagLayout)jp.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0, 1.0E-4};

        Bquery.setText("\u67e5\u8be2"); //NON-NLS
        Bquery.setFont(new Font("宋体",Font.PLAIN, 15));
        Bquery.addActionListener(e -> ConfirmActionPerformed(e));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets.bottom = 5;
        gbc.insets.right = 5;
        jp.add(Bquery, gbc);

        Bedit.setText("修改");
        Bedit.setFont(new Font("宋体",Font.PLAIN, 15));
        Bedit.addActionListener(e -> ConfirmActionEdit(e));
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets.bottom = 5;
        gbc.insets.right = 5;
        jp.add(Bedit, gbc);

        Bdelete.setText("删除");
        Bdelete.setFont(new Font("宋体",Font.PLAIN, 15));
        Bdelete.addActionListener(e -> ConfirmActionDelete(e));
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.insets.bottom = 5;
        gbc.insets.right = 5;
        jp.add(Bdelete, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets.bottom = 5;
        jp.add(separator1, gbc);

        Archivesquery.setFont(new Font("宋体", Font.PLAIN, 15)); //NON-NLS
        scrollPane1.setViewportView(Archivesquery);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 4;
        gbc.gridheight = 3;
        gbc.fill = GridBagConstraints.BOTH;
        jp.add(scrollPane1, gbc);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        //增加右键菜单
        Archivesquery.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mouseRightButtonClick(evt);
                //jTable1MouseClicked(evt);
            }
        });
        jp.setName("档案查询");
        setArchivesquery(GuiVerification.queryTableModel(new DocumentManagementDao().getAll()));

        return jp;
    }
    //查询面板
    private void ConfirmActionPerformed(ActionEvent e) {
        // TODO add your code here
        Compositequery cq=new Compositequery();
        cq.setExtendedState(JFrame.MAXIMIZED_BOTH);
        cq.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        cq.setLocationRelativeTo(null);
        cq.setVisible(true);
    }

    //批量修改
    private void ConfirmActionEdit(ActionEvent e){
        //Archivesquery.getRowCount();
        try {
            int rows[]=Archivesquery.getSelectedRows();
            if (Archivesquery.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null,"请选中需要修改的数据");
            }else {
                for(int i=0;i<rows.length;i++){
                    DocumentManagementDao dd =new DocumentManagementDao();
                    dd.update(new GuiVerification().updateData(Archivesquery,rows[i]));
                }
                JOptionPane.showMessageDialog(null,"修改成功");
                setArchivesquery(GuiVerification.queryTableModel(new DocumentManagementDao().getAll()));//刷新JTable
            }

        } catch (HeadlessException e1) {
            e1.printStackTrace();
            JOptionPane.showMessageDialog(null, e1.getMessage());//弹出异常消息
        }

    }

    //删除
    private void ConfirmActionDelete(ActionEvent e){
        try {
            int rows[]=Archivesquery.getSelectedRows();
            if (Archivesquery.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null,"请选中需要删除的数据");
            }else {
                   for(int i=0;i<rows.length;i++){
                       DocumentManagementDao dd =new DocumentManagementDao();
                       dd.delete(Archivesquery.getValueAt(rows[i],0).toString());
                   }
                JOptionPane.showMessageDialog(null,"删除成功");
                setArchivesquery(GuiVerification.queryTableModel(new DocumentManagementDao().getAll()));//刷新JTable
            }

        } catch (HeadlessException e1) {
            e1.printStackTrace();
            JOptionPane.showMessageDialog(null, e1.getMessage());//弹出异常消息
        }

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JSeparator separator1;
    private JScrollPane scrollPane1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private JButton Bquery;
    private JButton Bedit;
    private JButton Bdelete;
    private static JTable Archivesquery;
    private JPopupMenu m_popupMenu;
    private JMenuItem exportAllMenItem;
    private JMenuItem exportMenItem;
    private JFileChooser chooser;

    //查询面板反写JTable值
    public  static void setArchivesquery(DefaultTableModel tableModel) {
        Archivesquery.setModel(tableModel);
    }

    //创建JPopupMenu事件
    private void createPopupMenu() {
        //导出全部
        exportAllMenItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {//该操作需要做的事
              //文件路径为空，不做任何操作
                if (initSaveingfiles()==null) return;//此代码防止点击关闭报文件路径错误
                try {
                    //调用导出功能
                    new excelImport().writeExcel(initSaveingfiles(),Archivesquery.getModel());
                    JOptionPane.showMessageDialog(null,"导出成功");
                } catch (IOException e) {
                    e.printStackTrace( );
                    JOptionPane.showMessageDialog(null,e.getMessage());
                }

            }
        });
        //导出选中
        exportMenItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {//该操作需要做的事
                //文件路径为空，不做任何操作
                if (initSaveingfiles()==null) return;//此代码防止点击关闭报文件路径错误
                try {
                    //调用导出功能
                    int rows[]=Archivesquery.getSelectedRows();
                    new excelImport().writeExcel(initSaveingfiles(),new GuiVerification().selectTabel(rows,Archivesquery));
                    JOptionPane.showMessageDialog(null,"导出成功");
                } catch (IOException e) {
                    e.printStackTrace( );
                    JOptionPane.showMessageDialog(null,e.getMessage());
                }


            }
        });
        m_popupMenu.add(exportAllMenItem);
        m_popupMenu.add(exportMenItem);

    }


    //添加JPopupMenu事件到Archivesquery(JTable)监听
  /*  private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {

    }*/

    //鼠标右键点击事件
    private void mouseRightButtonClick(java.awt.event.MouseEvent evt) {
        //判断是否为鼠标的BUTTON3按钮，BUTTON3为鼠标右键
        if (evt.getButton() == java.awt.event.MouseEvent.BUTTON3) {
            //选中行点击右键，在数据范围且鼠标位置显示右键菜单。未选中数据无法触发右键菜单
            int focusedRowIndex = Archivesquery.rowAtPoint(evt.getPoint());
            if (focusedRowIndex == -1 ||Archivesquery.getSelectedRow()==-1) {
                return;
            }
            //将表格所选项设为当前右键点击的行
            //Archivesquery.setRowSelectionInterval(focusedRowIndex, focusedRowIndex);
            //弹出菜单

            m_popupMenu.show(Archivesquery, evt.getX(), evt.getY());
        }

    }

    /**
     * @initUploadingfiles 初始化上传事件，获取选择文件路径
     */
    private String  initSaveingfiles() {
        String path=null;
        String defaultDisk="档案管理"+new GuiVerification().nowtime()+".xls";
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel 97-2003文件","xls");
        chooser.setDialogTitle("请选择要保存的路径...");
        chooser.setApproveButtonText("保存");
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);//只能选文件夹
        chooser.setSelectedFile(new File(defaultDisk));//设置默认文件名
        chooser.setFileFilter(filter);//设置文件类型
        if (JFileChooser.FILES_ONLY == chooser.showOpenDialog(this)) {
            path=chooser.getSelectedFile().getPath();

        }

        return path;
    }




}




