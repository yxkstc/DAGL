/*
 * Created by JFormDesigner on Thu Apr 18 16:10:50 CST 2019
 */

package com.yk.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author Brainrain
 */
public class DADocumentTypeadd extends JFrame {
    public DADocumentTypeadd() {
        initComponents();
    }

    private void BsaveActionPerformed(ActionEvent e) {
        // TODO add your code here
        //if (tfTypeNameChinese.getText().length())
    }

    private void BCloseActionPerformed(ActionEvent e) {
        // TODO add your code here
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        Bsave = new JButton();
        BClose = new JButton();
        lbTypeNameEnglish = new JLabel();
        tfTypeNameEnglish = new JTextField();
        lbTypeNameChinese = new JLabel();
        tfTypeNameChinese = new JTextField();
        lbState = new JLabel();
        tfState = new JTextField();
        lbCreatetime = new JLabel();
        tfCreatetime = new JTextField();
        GridBagConstraints gbc;

        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {0, 0, 43, 90, 0, 125, 0};
        ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0};
        ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
        ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

        Bsave.setText("\u4fdd\u5b58"); //NON-NLS
        Bsave.addActionListener(e -> BsaveActionPerformed(e));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets.bottom = 5;
        gbc.insets.right = 5;
        contentPane.add(Bsave, gbc);

        BClose.setText("\u5173\u95ed"); //NON-NLS
        BClose.addActionListener(e -> BCloseActionPerformed(e));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets.bottom = 5;
        gbc.insets.right = 5;
        contentPane.add(BClose, gbc);

        lbTypeNameEnglish.setText("\u82f1\u6587\u540d"); //NON-NLS
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets.bottom = 5;
        gbc.insets.right = 5;
        contentPane.add(lbTypeNameEnglish, gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets.bottom = 5;
        gbc.insets.right = 5;
        contentPane.add(tfTypeNameEnglish, gbc);

        lbTypeNameChinese.setText("\u4e2d\u6587\u540d"); //NON-NLS
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets.bottom = 5;
        gbc.insets.right = 5;
        contentPane.add(lbTypeNameChinese, gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets.bottom = 5;
        contentPane.add(tfTypeNameChinese, gbc);

        lbState.setText("\u72b6\u6001"); //NON-NLS
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets.bottom = 5;
        gbc.insets.right = 5;
        contentPane.add(lbState, gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets.bottom = 5;
        gbc.insets.right = 5;
        contentPane.add(tfState, gbc);

        lbCreatetime.setText("\u521b\u5efa\u65f6\u95f4"); //NON-NLS
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets.bottom = 5;
        gbc.insets.right = 5;
        contentPane.add(lbCreatetime, gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets.bottom = 5;
        contentPane.add(tfCreatetime, gbc);

        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        tfTypeNameEnglish.setEditable(false);
        tfState.setEditable(false);
        tfCreatetime.setEditable(false);
        lbTypeNameEnglish.setFont(new Font("宋体", Font.PLAIN, 15));
        tfTypeNameEnglish.setFont(new Font("宋体", Font.PLAIN, 15));
        lbTypeNameChinese.setFont(new Font("宋体", Font.PLAIN, 15));
        tfTypeNameChinese.setFont(new Font("宋体", Font.PLAIN, 15));
        lbState.setFont(new Font("宋体", Font.PLAIN, 15));
        tfState.setFont(new Font("宋体", Font.PLAIN, 15));
        lbCreatetime.setFont(new Font("宋体", Font.PLAIN, 15));
        tfCreatetime.setFont(new Font("宋体", Font.PLAIN, 15));
        Color c = new Color(0,0,0,255);//背影颜色随便设任意值,只起占位作用。
        Bsave.setBackground(c);
        Bsave.setOpaque(false);//设置透明
        Bsave.setBorderPainted(false);//不绘制边框
        BClose.setBackground(c);
        BClose.setOpaque(false);//设置透明
        BClose.setBorderPainted(false);//不绘制边框
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JButton Bsave;
    private JButton BClose;
    private JLabel lbTypeNameEnglish;
    private JTextField tfTypeNameEnglish;
    private JLabel lbTypeNameChinese;
    private JTextField tfTypeNameChinese;
    private JLabel lbState;
    private JTextField tfState;
    private JLabel lbCreatetime;
    private JTextField tfCreatetime;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
