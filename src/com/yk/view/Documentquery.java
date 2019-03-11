/*
 * Created by JFormDesigner on Wed Nov 28 11:32:40 CST 2018
 */

package com.yk.view;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

import com.yk.business.GuiVerification;
import com.yk.dao.DocumentManagementDao;
import com.yk.model.DocumentManagement;

import javax.swing.*;
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

        Archivesquery.setFont(new Font("宋体", Font.PLAIN, 14)); //NON-NLS
        scrollPane1.setViewportView(Archivesquery);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 4;
        gbc.gridheight = 3;
        gbc.fill = GridBagConstraints.BOTH;
        jp.add(scrollPane1, gbc);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        jp.setName("档案查询");
        setArchivesquery(GuiVerification.queryTableModel(new DocumentManagementDao().getAll()));
        return jp;
    }
    //查询面板
    private void ConfirmActionPerformed(ActionEvent e) {
        // TODO add your code here
        Compositequery cq=new Compositequery();
        cq.setExtendedState(JFrame.MAXIMIZED_BOTH);
        cq.setDefaultCloseOperation(3);
        cq.setLocationRelativeTo(null);
        cq.setVisible(true);
    }

    //批量修改
    private void ConfirmActionEdit(ActionEvent e){
        //Archivesquery.getRowCount();
        try {
            List<DocumentManagement> list =new GuiVerification().GetModel(Archivesquery);
            for (int i=0;i<list.size();i++){
                new DocumentManagementDao().update(list.get(i));
            }
            JOptionPane.showMessageDialog(null,"修改成功");
        } catch (Exception e1) {
            e1.printStackTrace( );
            JOptionPane.showMessageDialog(null,e1.getMessage());
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
            }
            JOptionPane.showMessageDialog(null,"删除成功");
            setArchivesquery(GuiVerification.queryTableModel(new DocumentManagementDao().getAll()));//刷新JTable
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

    //查询面板反写JTable值
    public  static void setArchivesquery(DefaultTableModel tableModel) {
        Archivesquery.setModel(tableModel);
    }
}




