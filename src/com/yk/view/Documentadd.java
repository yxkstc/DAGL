/*
 * Created by JFormDesigner on Mon Nov 26 12:03:45 CST 2018
 */

package com.yk.view;

import com.yk.business.DADocumentTypeBusiness;
import com.yk.business.DocumentBusiness;
import com.yk.business.GuiVerification;
import com.yk.model.DocumentManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author Brainrain
 */
public class Documentadd extends JPanel {
    Documentadd() {
        initComponents();
    }

    public static Documentadd getInstance() {
        if (instance == null) {
            synchronized (Documentadd.class) {
                if (instance == null) {
                    instance = new Documentadd();
                }
            }
        }
        return instance;
    }


    //新增方法
    private void SubmitActionPerformed(ActionEvent e) {
        try {
            if (TPersonliable.getText().length() == 0) {
                GuiVerification.FieldVerification(TPersonliable.getText(), LPersonliable.getText());
                return;
            }
            if (TTheme.getText().length() == 0) {
                GuiVerification.FieldVerification(TTheme.getText(), LTheme.getText());
                return;
            }
            if (TDocumentType.getSelectedItem().toString().length() == 0) {
                GuiVerification.FieldVerification(TDocumentType.getSelectedItem().toString(), LDocumentType.getText());
                return;
            }
            if (TThenumberofpages.getText().length() == 0) {
                GuiVerification.FieldVerification(TThenumberofpages.getText(), LThenumberofpages.getText());
                return;
            }
            if (TStorageposition.getText().length() == 0) {
                GuiVerification.FieldVerification(TStorageposition.getText(), LStorageposition.getText());
                return;
            }
            if (TRemarks.getText().length() == 0) {
                GuiVerification.FieldVerification(TRemarks.getText(), LRemarks.getText());
                return;
            }
            if (TDocumentType.getSelectedItem().toString().equals("模板编码")) {
                JOptionPane.showMessageDialog(null, "该模块不支持模板编码方式录入，请重新选择");
                return;
            }
            int isSave = JOptionPane.showConfirmDialog(null, "确认保存", "提示", JOptionPane.YES_NO_OPTION);
            if (isSave == JOptionPane.YES_NO_OPTION) {
                DocumentManagement DM = new DocumentManagement();
                DM.setDocumentcoding(TDocumentcoding.getText());
                DM.setPersonliable(TPersonliable.getText());
                DM.setTheme(TTheme.getText());
                DM.setDocumentType(TDocumentType.getSelectedItem().toString());
                DM.setThenumberofpages(TThenumberofpages.getText());
                DM.setArchivalyear(TArchivalyear.getText());
                DM.setStorageposition(TStorageposition.getText());
                DM.setRemarks(TRemarks.getText());
                DM.setCreatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()));
                DocumentBusiness.insertDcoument(DM);
                JOptionPane.showMessageDialog(null, "保存成功");
            }

        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, e1.getMessage());
        }
    }

    private void ResetActionPerformed(ActionEvent e) {
        // TODO add your code here
        TPersonliable.setText("");
        TTheme.setText("");
        TThenumberofpages.setText("");
        TStorageposition.setText("");
        TRemarks.setText("");
    }

    private void TDocumentTypeItemStateChanged(ItemEvent e) {
        // TODO add your code here
        TDocumentcoding.setText(DADocumentTypeBusiness.queryCode(TDocumentType.getSelectedItem().toString()));
    }


    public void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        Submit = new JButton();
        Reset = new JButton();
        LDocumentcoding = new JLabel();
        TDocumentcoding = new JTextField();
        LPersonliable = new JLabel();
        TPersonliable = new JTextField();
        LTheme = new JLabel();
        TTheme = new JTextField();
        LDocumentType = new JLabel();
        TDocumentType = new JComboBox();
        LThenumberofpages = new JLabel();
        TThenumberofpages = new JTextField();
        LArchivalyear = new JLabel();
        TArchivalyear = new JTextField();
        LStorageposition = new JLabel();
        TStorageposition = new JTextField();
        LCreatetime = new JLabel();
        TCreatetime = new JTextField();
        LRemarks = new JLabel();
        scrollPane1 = new JScrollPane();
        TRemarks = new JTextArea();
        GridBagConstraints gbc;

        setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 20)); //NON-NLS
        setLayout(new GridBagLayout());
        ((GridBagLayout) getLayout()).columnWidths = new int[]{0, 55, 98, 55, 41, 212, 40, 99, 327, 62, 0};
        ((GridBagLayout) getLayout()).rowHeights = new int[]{42, 49, 41, 40, 14, 35, 17, 40, 18, 42, 18, 187, 34, 0};
        ((GridBagLayout) getLayout()).columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0E-4};
        ((GridBagLayout) getLayout()).rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

        Submit.setText("\u786e\u8ba4"); //NON-NLS
        Submit.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 20)); //NON-NLS
        Submit.addActionListener(e -> SubmitActionPerformed(e));
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets.bottom = 5;
        gbc.insets.right = 5;
        add(Submit, gbc);

        Reset.setText("\u91cd\u7f6e"); //NON-NLS
        Reset.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 20)); //NON-NLS
        Reset.addActionListener(e -> ResetActionPerformed(e));
        gbc = new GridBagConstraints();
        gbc.gridx = 7;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets.bottom = 5;
        gbc.insets.right = 5;
        add(Reset, gbc);

        LDocumentcoding.setText("\u6587\u6863\u7f16\u7801"); //NON-NLS
        LDocumentcoding.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 20)); //NON-NLS
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets.bottom = 5;
        gbc.insets.right = 5;
        add(LDocumentcoding, gbc);

        TDocumentcoding.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 20)); //NON-NLS
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets.bottom = 5;
        gbc.insets.right = 5;
        add(TDocumentcoding, gbc);

        LPersonliable.setText("\u8d23\u4efb\u4eba"); //NON-NLS
        LPersonliable.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 20)); //NON-NLS
        gbc = new GridBagConstraints();
        gbc.gridx = 7;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets.bottom = 5;
        gbc.insets.right = 5;
        add(LPersonliable, gbc);

        TPersonliable.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 20)); //NON-NLS
        gbc = new GridBagConstraints();
        gbc.gridx = 8;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets.bottom = 5;
        gbc.insets.right = 5;
        add(TPersonliable, gbc);

        LTheme.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 20)); //NON-NLS
        LTheme.setText("\u4e3b\u9898"); //NON-NLS
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets.bottom = 5;
        gbc.insets.right = 5;
        add(LTheme, gbc);

        TTheme.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 20)); //NON-NLS
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 5;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets.bottom = 5;
        gbc.insets.right = 5;
        add(TTheme, gbc);

        LDocumentType.setText("\u6863\u6848\u7c7b\u522b"); //NON-NLS
        LDocumentType.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 20)); //NON-NLS
        gbc = new GridBagConstraints();
        gbc.gridx = 7;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets.bottom = 5;
        gbc.insets.right = 5;
        add(LDocumentType, gbc);

        TDocumentType.addItemListener(e -> TDocumentTypeItemStateChanged(e));
        gbc = new GridBagConstraints();
        gbc.gridx = 8;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets.bottom = 5;
        gbc.insets.right = 5;
        add(TDocumentType, gbc);

        LThenumberofpages.setText("\u9875\u6570"); //NON-NLS
        LThenumberofpages.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 20)); //NON-NLS
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets.bottom = 5;
        gbc.insets.right = 5;
        add(LThenumberofpages, gbc);

        TThenumberofpages.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 20)); //NON-NLS
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 7;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets.bottom = 5;
        gbc.insets.right = 5;
        add(TThenumberofpages, gbc);

        LArchivalyear.setText("\u5f52\u6863\u5e74"); //NON-NLS
        LArchivalyear.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 20)); //NON-NLS
        gbc = new GridBagConstraints();
        gbc.gridx = 7;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets.bottom = 5;
        gbc.insets.right = 5;
        add(LArchivalyear, gbc);

        TArchivalyear.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 20)); //NON-NLS
        gbc = new GridBagConstraints();
        gbc.gridx = 8;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets.bottom = 5;
        gbc.insets.right = 5;
        add(TArchivalyear, gbc);

        LStorageposition.setText("\u5b58\u653e\u4f4d\u7f6e"); //NON-NLS
        LStorageposition.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 20)); //NON-NLS
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 9;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets.bottom = 5;
        gbc.insets.right = 5;
        add(LStorageposition, gbc);

        TStorageposition.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 20)); //NON-NLS
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 9;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets.bottom = 5;
        gbc.insets.right = 5;
        add(TStorageposition, gbc);

        LCreatetime.setText("\u521b\u5efa\u65f6\u95f4"); //NON-NLS
        LCreatetime.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 20)); //NON-NLS
        gbc = new GridBagConstraints();
        gbc.gridx = 7;
        gbc.gridy = 9;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets.bottom = 5;
        gbc.insets.right = 5;
        add(LCreatetime, gbc);

        TCreatetime.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 20)); //NON-NLS
        gbc = new GridBagConstraints();
        gbc.gridx = 8;
        gbc.gridy = 9;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets.bottom = 5;
        gbc.insets.right = 5;
        add(TCreatetime, gbc);

        LRemarks.setText("\u5907\u6ce8"); //NON-NLS
        LRemarks.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 20)); //NON-NLS
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 11;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets.bottom = 5;
        gbc.insets.right = 5;
        add(LRemarks, gbc);


        TRemarks.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 20)); //NON-NLS
        scrollPane1.setViewportView(TRemarks);
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 11;
        gbc.gridwidth = 6;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets.bottom = 5;
        gbc.insets.right = 5;
        add(scrollPane1, gbc);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        this.setFont(new Font("宋体", Font.PLAIN, 20)); //NON-NLS
        Submit.setFont(new Font("宋体", Font.PLAIN, 20)); //NON-NLS
        Reset.setFont(new Font("宋体", Font.PLAIN, 20)); //NON-NLS
        LDocumentcoding.setFont(new Font("宋体", Font.PLAIN, 20)); //NON-NLS
        TDocumentcoding.setFont(new Font("宋体", Font.PLAIN, 20)); //NON-NLS
        TDocumentcoding.setEditable(false);
        LPersonliable.setFont(new Font("宋体", Font.PLAIN, 20)); //NON-NLS
        TPersonliable.setFont(new Font("宋体", Font.PLAIN, 20)); //NON-NLS
        LTheme.setFont(new Font("宋体", Font.PLAIN, 20)); //NON-NLS
        TTheme.setFont(new Font("宋体", Font.PLAIN, 20)); //NON-NLS
        LDocumentType.setFont(new Font("宋体", Font.PLAIN, 20)); //NON-NLS
        TDocumentType.setFont(new Font("宋体", Font.PLAIN, 20)); //NON-NLS
        LThenumberofpages.setFont(new Font("宋体", Font.PLAIN, 20)); //NON-NLS
        LCreatetime.setFont(new Font("宋体", Font.PLAIN, 20)); //NON-NLS
        LStorageposition.setFont(new Font("宋体", Font.PLAIN, 20)); //NON-NLS
        TThenumberofpages.setFont(new Font("宋体", Font.PLAIN, 20)); //NON-NLS
        LArchivalyear.setFont(new Font("宋体", Font.PLAIN, 20)); //NON-NLS
        TArchivalyear.setFont(new Font("宋体", Font.PLAIN, 20)); //NON-NLS
        TArchivalyear.setEditable(false);
        TArchivalyear.setText(new SimpleDateFormat("yyyy").format(Calendar.getInstance().getTime()));
        TCreatetime.setFont(new Font("宋体", Font.PLAIN, 20)); //NON-NLS
        TCreatetime.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()));
        TCreatetime.setEditable(false);
        TStorageposition.setFont(new Font("宋体", Font.PLAIN, 20)); //NON-NLS
        LRemarks.setFont(new Font("宋体", Font.PLAIN, 20)); //NON-NLS
        TRemarks.setFont(new Font("宋体", Font.PLAIN, 20)); //NON-NLS
        TDocumentType.setModel(DADocumentTypeBusiness.QueryTypeNameEnglish());
        this.setName("新增");
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JButton Submit;
    private JButton Reset;
    private JLabel LDocumentcoding;
    private JTextField TDocumentcoding;
    private JLabel LPersonliable;
    private JTextField TPersonliable;
    private JLabel LTheme;
    private JTextField TTheme;
    private JLabel LDocumentType;
    private JComboBox TDocumentType;
    private JLabel LThenumberofpages;
    private JTextField TThenumberofpages;
    private JLabel LArchivalyear;
    private JTextField TArchivalyear;
    private JLabel LStorageposition;
    private JTextField TStorageposition;
    private JLabel LCreatetime;
    private JTextField TCreatetime;
    private JLabel LRemarks;
    private JScrollPane scrollPane1;
    private JTextArea TRemarks;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private static Documentadd instance;
}
