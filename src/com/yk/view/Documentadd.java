/*
 * Created by JFormDesigner on Mon Nov 26 12:03:45 CST 2018
 */

package com.yk.view;

import com.yk.dao.DocumentManagementDao;
import com.yk.model.DocumentManagement;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.*;
import static com.yk.business.GuiVerification.FieldVerification;

/**
 * @author Brainrain
 */
public class Documentadd extends JPanel {

    private void SubmitActionPerformed(ActionEvent e) {
        // TODO jp.jp.add your code here
        if(FieldVerification(TPersonliable.getText(),LPersonliable.getText())==0&&FieldVerification(TTheme.getText(),LTheme.getText())==0&&FieldVerification(TTitle.getText(),LTitle.getText())==0&&FieldVerification(TThenumberofpages.getText(),LThenumberofpages.getText())==0&&FieldVerification(TStorageposition.getText(),LStorageposition.getText())==0&&FieldVerification(TRemarks.getText(),LRemarks.getText())==0){
            DocumentManagement DM=new DocumentManagement();
            DM.setDocumentcoding(TDocumentcoding.getText());
            DM.setPersonliable(TPersonliable.getText());
            DM.setTheme(TTheme.getText());
            DM.setTitle(TTitle.getText());
            DM.setThenumberofpages(TThenumberofpages.getText());
            DM.setArchivalyear(TArchivalyear.getText());
            DM.setStorageposition(TStorageposition.getText());
            DM.setRemarks(TRemarks.getText());
            DM.setCreatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()));
            new DocumentManagementDao().insert(DM);
        }else{
            return;
        }
    }

    private void ResetActionPerformed(ActionEvent e) {
        // TODO jp.jp.add your code here
        TPersonliable.setText("");
        TTheme.setText("");
        TTitle.setText("");
        TThenumberofpages.setText("");
        TStorageposition.setText("");
        TRemarks.setText("");
    }


    public JPanel initComponents() {
        JPanel jp=new JPanel();
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        Submit = new JButton();
        Reset = new JButton();
        LDocumentcoding = new JLabel();
        TDocumentcoding = new JTextField();
        LPersonliable = new JLabel();
        TPersonliable = new JTextField();
        LTheme = new JLabel();
        TTheme = new JTextField();
        LTitle = new JLabel();
        TTitle = new JTextField();
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

        jp.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 20)); //NON-NLS
        jp.setLayout(new GridBagLayout());
        ((GridBagLayout)jp.getLayout()).columnWidths = new int[] {0, 55, 98, 55, 41, 212, 40, 99, 327, 62, 0};
        ((GridBagLayout)jp.getLayout()).rowHeights = new int[] {42, 49, 41, 40, 14, 35, 17, 40, 18, 42, 18, 187, 34, 0};
        ((GridBagLayout)jp.getLayout()).columnWeights = new double[] {0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0E-4};
        ((GridBagLayout)jp.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

        Submit.setText("\u786e\u8ba4"); //NON-NLS
        Submit.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 20)); //NON-NLS
        Submit.addActionListener(e -> SubmitActionPerformed(e));
        jp.add(Submit, new GridBagConstraints(3, 1, 2, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        Reset.setText("\u91cd\u7f6e"); //NON-NLS
        Reset.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 20)); //NON-NLS
        Reset.addActionListener(e -> ResetActionPerformed(e));
        jp.add(Reset, new GridBagConstraints(7, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        LDocumentcoding.setText("\u6587\u6863\u7f16\u7801"); //NON-NLS
        LDocumentcoding.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 20)); //NON-NLS
        jp.add(LDocumentcoding, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        TDocumentcoding.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 20)); //NON-NLS
        String Code =new DocumentManagementDao().CodeMaxQuery().get(0).getDocumentcoding().toString();
        String Codeleft=Code.substring(0,Code.lastIndexOf("-")+1).trim();
        int Coderight=Integer.valueOf( Code.substring(Code.lastIndexOf("-")+1,Code.length()).trim())+1;
        TDocumentcoding.setText(Codeleft+Coderight);
        TDocumentcoding.setEditable(false);
        jp.add(TDocumentcoding, new GridBagConstraints(3, 3, 3, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        LPersonliable.setText("\u8d23\u4efb\u4eba"); //NON-NLS
        LPersonliable.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 20)); //NON-NLS
        jp.add(LPersonliable, new GridBagConstraints(7, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        TPersonliable.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 20)); //NON-NLS
        jp.add(TPersonliable, new GridBagConstraints(8, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        LTheme.setText("\u9898\u540d"); //NON-NLS
        LTheme.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 20)); //NON-NLS
        jp.add(LTheme, new GridBagConstraints(2, 5, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        TTheme.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 20)); //NON-NLS
        jp.add(TTheme, new GridBagConstraints(3, 5, 3, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        LTitle.setText("\u6587\u4ef6\u540d"); //NON-NLS
        LTitle.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 20)); //NON-NLS
        jp.add(LTitle, new GridBagConstraints(7, 5, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        TTitle.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 20)); //NON-NLS
        jp.add(TTitle, new GridBagConstraints(8, 5, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        LThenumberofpages.setText("\u9875\u6570"); //NON-NLS
        LThenumberofpages.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 20)); //NON-NLS
        jp.add(LThenumberofpages, new GridBagConstraints(2, 7, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        TThenumberofpages.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 20)); //NON-NLS
        jp.add(TThenumberofpages, new GridBagConstraints(3, 7, 3, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        LArchivalyear.setText("\u5f52\u6863\u5e74"); //NON-NLS
        LArchivalyear.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 20)); //NON-NLS
        jp.add(LArchivalyear, new GridBagConstraints(7, 7, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        TArchivalyear.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 20)); //NON-NLS
        TArchivalyear.setEditable(false);
        TArchivalyear.setText(new SimpleDateFormat("yyyy").format(Calendar.getInstance().getTime()));
        jp.add(TArchivalyear, new GridBagConstraints(8, 7, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        LStorageposition.setText("\u5b58\u653e\u4f4d\u7f6e"); //NON-NLS
        LStorageposition.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 20)); //NON-NLS
        jp.add(LStorageposition, new GridBagConstraints(2, 9, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        TStorageposition.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 20)); //NON-NLS
        jp.add(TStorageposition, new GridBagConstraints(3, 9, 3, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        LCreatetime.setText("\u521b\u5efa\u65f6\u95f4"); //NON-NLS
        LCreatetime.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 20)); //NON-NLS
        jp.add(LCreatetime, new GridBagConstraints(7, 9, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        TCreatetime.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 20)); //NON-NLS
        TCreatetime.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()));
        TCreatetime.setEditable(false);
        jp.add(TCreatetime, new GridBagConstraints(8, 9, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        LRemarks.setText("\u5907\u6ce8"); //NON-NLS
        LRemarks.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 20)); //NON-NLS
        jp.add(LRemarks, new GridBagConstraints(2, 11, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));


        TRemarks.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 20)); //NON-NLS
        scrollPane1.setViewportView(TRemarks);
        jp.add(scrollPane1, new GridBagConstraints(3, 11, 6, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        jp.setName("新增");
        return jp;
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
    private JLabel LTitle;
    private JTextField TTitle;
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
}
