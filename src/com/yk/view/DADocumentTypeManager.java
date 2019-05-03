/*
 * Created by JFormDesigner on Wed Apr 17 21:41:16 CST 2019
 */

package com.yk.view;

import com.yk.business.DADocumentTypeBusiness;
import com.yk.dao.DADocumentTypeDao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;

/**
 * @author Brainrain
 */
public class DADocumentTypeManager extends JPanel {
    DADocumentTypeManager() {
        initComponents();
        tpyetable.setModel(DADocumentTypeBusiness.queryTableModelQiYong());//初始化table
        state.setModel(DADocumentTypeBusiness.selectState());//初始化下拉菜单
    }

    public static DADocumentTypeManager getInstance() {
        if (instance == null) {
            synchronized (DADocumentTypeManager.class) {
                if (instance == null) {
                    instance = new DADocumentTypeManager();
                }
            }
        }
        return instance;
    }

    private void insertActionPerformed(ActionEvent e) {
        // TODO add your code here
        DADocumentTypeadd dt = DADocumentTypeadd.getInstance();
        dt.setSize(550, 200);
        dt.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        dt.setLocationRelativeTo(null);
        dt.setVisible(true);
    }

    //修改类别名称
    private void updateActionPerformed(ActionEvent e) {
        // TODO add your code here
        try {
            int rows[] = tpyetable.getSelectedRows();
            if (tpyetable.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "请选中需要修改的数据");
            } else {
                if (tpyetable.isEditing()) {//如果table在编辑中，取消table编辑状态，防止正在编辑数据没有被修改
                    tpyetable.getCellEditor().stopCellEditing();
                }
                int isUpdate = JOptionPane.showConfirmDialog(null, "确认修改", "提示", JOptionPane.YES_NO_OPTION);
                if (isUpdate == JOptionPane.YES_NO_OPTION) {
                    for (int row : rows) {
                        DADocumentTypeDao dt = new DADocumentTypeDao();
                        dt.update(new DADocumentTypeBusiness().updateData(tpyetable, row));
                    }
                    JOptionPane.showMessageDialog(null, "修改成功");
                    tpyetable.setModel(DADocumentTypeBusiness.queryTableModelQiYong());//刷新JTable
                }
            }
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, e1.getMessage());//弹出异常消息
        }
    }

    //禁用单据
    private void prohibituseActionPerformed(ActionEvent e) {
        // TODO add your code here
        try {
            int rows[] = tpyetable.getSelectedRows();
            if (tpyetable.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "请选中需要禁用的数据");
            } else {
                if (tpyetable.isEditing()) {//如果table在编辑中，取消table编辑状态，防止正在编辑数据没有被修改
                    tpyetable.getCellEditor().stopCellEditing();
                }
                int isProhibituse = JOptionPane.showConfirmDialog(null, "确认禁用", "提示", JOptionPane.YES_NO_OPTION);
                if (isProhibituse == JOptionPane.YES_NO_OPTION) {
                    for (int i = 0; i < rows.length; i++) {
                        DADocumentTypeDao dt = new DADocumentTypeDao();
                        dt.updateStateProhiBituse(DADocumentTypeBusiness.updateStateProhiBituse(tpyetable, rows[i]));
                    }
                    JOptionPane.showMessageDialog(null, "禁用成功");
                    tpyetable.setModel(DADocumentTypeBusiness.queryTableModelQiYong());//刷新JTable
                    state.setModel(DADocumentTypeBusiness.selectState());
                }
            }
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, e1.getMessage());//弹出异常消息
        }
    }

    private void stateItemStateChanged(ItemEvent e) {
        // TODO add your code here
    }

    //查询单据状态
    private void queryActionPerformed(ActionEvent e) {
        // TODO add your code here
        try {
            if (state.getSelectedItem().toString().trim().equals("全部")) {
                tpyetable.setModel(DADocumentTypeBusiness.queryTableModelAll());
                return;
            }
            if (state.getSelectedItem().toString().trim().equals("启用")) {
                tpyetable.setModel(DADocumentTypeBusiness.queryTableModelQiYong());
                return;
            }
            if (state.getSelectedItem().toString().trim().equals("禁用")) {
                tpyetable.setModel(DADocumentTypeBusiness.queryTableModelPerformed());
            }
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, e1.getMessage());//弹出异常消息
        }

    }

    //启用
    private void qiyongActionPerformed(ActionEvent e) {
        // TODO add your code here
        try {
            int rows[] = tpyetable.getSelectedRows();
            if (tpyetable.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "请选中需要启用的数据");
            } else {
                if (tpyetable.isEditing()) {//如果table在编辑中，取消table编辑状态，防止正在编辑数据没有被修改
                    tpyetable.getCellEditor().stopCellEditing();
                }

                int isQiyong = JOptionPane.showConfirmDialog(null, "确认启用", "提示", JOptionPane.YES_NO_OPTION);
                if (isQiyong == JOptionPane.YES_NO_OPTION) {
                    for (int row : rows) {
                        DADocumentTypeBusiness db = new DADocumentTypeBusiness();
                        db.updateStateQiYong(tpyetable, row);
                    }
                    JOptionPane.showMessageDialog(null, "启用成功");
                    tpyetable.setModel(DADocumentTypeBusiness.queryTableModelQiYong());//刷新JTable
                    state.setModel(DADocumentTypeBusiness.selectState());
                }
            }
        } catch (HeadlessException e1) {
            JOptionPane.showMessageDialog(null, e1.getMessage());//弹出异常消息
        }
    }

    private void initComponents() {

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar1 = new JMenuBar();
        insert = new JButton();
        update = new JButton();
        qiyong = new JButton();
        prohibituse = new JButton();
        state = new JComboBox();
        query = new JButton();
        hSpacer5 = new JPanel(null);
        hSpacer6 = new JPanel(null);
        hSpacer4 = new JPanel(null);
        hSpacer3 = new JPanel(null);
        hSpacer2 = new JPanel(null);
        hSpacer1 = new JPanel(null);
        scrollPane1 = new JScrollPane();
        tpyetable = new JTable();
        GridBagConstraints gbc;

        setLayout(new GridBagLayout());
        ((GridBagLayout) getLayout()).columnWidths = new int[]{64, 67, 60, 128, 126, 0, 0};
        ((GridBagLayout) getLayout()).rowHeights = new int[]{0, 0, 0, 0};
        ((GridBagLayout) getLayout()).columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0E-4};
        ((GridBagLayout) getLayout()).rowWeights = new double[]{0.0, 0.0, 1.0, 1.0E-4};


        insert.setText("\u65b0\u589e"); //NON-NLS
        insert.addActionListener(e -> insertActionPerformed(e));
        menuBar1.add(insert);

        update.setText("\u4fee\u6539"); //NON-NLS
        update.addActionListener(e -> updateActionPerformed(e));
        menuBar1.add(update);

        qiyong.setText("\u542f\u7528"); //NON-NLS
        qiyong.addActionListener(e -> qiyongActionPerformed(e));
        menuBar1.add(qiyong);

        prohibituse.setText("\u7981\u7528"); //NON-NLS
        prohibituse.addActionListener(e -> prohibituseActionPerformed(e));
        menuBar1.add(prohibituse);

        state.addItemListener(e -> stateItemStateChanged(e));
        menuBar1.add(state);

        query.setText("\u67e5\u8be2"); //NON-NLS
        query.addActionListener(e -> queryActionPerformed(e));
        menuBar1.add(query);
        menuBar1.add(hSpacer5);
        menuBar1.add(hSpacer6);
        menuBar1.add(hSpacer4);
        menuBar1.add(hSpacer3);
        menuBar1.add(hSpacer2);
        menuBar1.add(hSpacer1);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 6;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets.bottom = 5;
        add(menuBar1, gbc);

        scrollPane1.setViewportView(tpyetable);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 6;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.BOTH;
        add(scrollPane1, gbc);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        insert.setFont(new Font("宋体", Font.PLAIN, 15));
        update.setFont(new Font("宋体", Font.PLAIN, 15));
        prohibituse.setFont(new Font("宋体", Font.PLAIN, 15));
        state.setFont(new Font("宋体", Font.PLAIN, 15));
        query.setFont(new Font("宋体", Font.PLAIN, 15));
        qiyong.setFont(new Font("宋体", Font.PLAIN, 15));
        tpyetable.setFont(new Font("宋体", Font.PLAIN, 14));
        Color c = new Color(0, 0, 0, 255);//背影颜色随便设任意值,只起占位作用。
        insert.setBackground(c);
        insert.setOpaque(false);//设置透明
        insert.setBorderPainted(false);//不绘制边框
        update.setBackground(c);
        update.setOpaque(false);//设置透明
        update.setBorderPainted(false);//不绘制边框
        prohibituse.setBackground(c);
        prohibituse.setOpaque(false);//设置透明
        prohibituse.setBorderPainted(false);//不绘制边框
        query.setBackground(c);
        query.setOpaque(false);//设置透明
        query.setBorderPainted(false);//不绘制边框
        qiyong.setBackground(c);
        qiyong.setOpaque(false);//设置透明
        qiyong.setBorderPainted(false);//不绘制边框
        setName("档案类别");
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar menuBar1;
    private JButton insert;
    private JButton update;
    private JButton qiyong;
    private JButton prohibituse;
    private JComboBox state;
    private JButton query;
    private JPanel hSpacer5;
    private JPanel hSpacer6;
    private JPanel hSpacer4;
    private JPanel hSpacer3;
    private JPanel hSpacer2;
    private JPanel hSpacer1;
    private JScrollPane scrollPane1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private static JTable tpyetable;
    private static DADocumentTypeManager instance;

    public static void setTpyetable(DefaultTableModel dm) {
        tpyetable.setModel(dm);
    }
}
