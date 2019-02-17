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
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        Bquery = new JButton();
        Bedit = new JButton();
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
        Bquery.addActionListener(e -> ConfirmActionPerformed(e));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets.bottom = 5;
        gbc.insets.right = 5;
        jp.add(Bquery, gbc);

        Bedit.setText("修改");
        Bedit.addActionListener(e -> ConfirmActionEdit(e));
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets.bottom = 5;
        gbc.insets.right = 5;
        jp.add(Bedit, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets.bottom = 5;
        jp.add(separator1, gbc);



        Archivesquery.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 14)); //NON-NLS
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
        List<DocumentManagement> list =GuiVerification.GetModel(Archivesquery);
        for (int i=0;i<list.size();i++){
            new DocumentManagementDao().update(list.get(i));
        }

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JButton Bquery;
    private JButton Bedit;
    private JSeparator separator1;
    private JScrollPane scrollPane1;
    private static JTable Archivesquery;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    //查询面板反写JTable值
    public static void setArchivesquery(DefaultTableModel tableModel) {
        Archivesquery.setModel(tableModel);
    }
}




