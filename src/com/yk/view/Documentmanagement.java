/*
 * Created by JFormDesigner on Mon Nov 26 21:29:55 CST 2018
 */

package com.yk.view;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.awt.*;
import java.awt.event.*;
import java.util.Map;
import javax.swing.*;

/**
 * @author 晏堃
 * @version V1
 */
public class Documentmanagement extends JFrame {
    public Documentmanagement() {
        initComponents();
    }

    public static void main(String[] args) {
        Documentmanagement DT=new Documentmanagement();
        //按屏幕分辨率最大化
        //DT.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        //屏幕最大化，显示windows任务栏
        DT.setExtendedState(JFrame.MAXIMIZED_BOTH);
        DT.setDefaultCloseOperation(3);
        DT.setLocationRelativeTo(null);
        DT.setVisible(true);
    }
    //退出
    private void SignoutActionPerformed(ActionEvent e) {
        // TODO add your code here
        //关闭窗口释放资源
        this.dispose();
    }

    //新增
    private void DnewaddActionPerformed(ActionEvent e) {
        // TODO add your code here
           JPanel JL= new Documentadd().initComponents();

            for (int i=0;i<tablePanemail.getTabCount();i++){
                if (tablePanemail.getComponentAt(i).getName().equals(
                        JL.getName())) {
                    tablePanemail.setSelectedIndex(i);
                    return;
                }
            }
        tablePanemail.addTab(JL.getName(), JL);
        tablePanemail.setSelectedComponent(JL);

    }

    //查询
    private void DqueryActionPerformed(ActionEvent e) {
        // TODO add your code here
        JPanel JL=new Documentquery().initComponents();
            for (int i=0;i<tablePanemail.getTabCount();i++){
                if (tablePanemail.getComponentAt(i).getName().equals(
                        JL.getName())) {
                    tablePanemail.setSelectedIndex(i);
                    return;
                }
            }
        tablePanemail.addTab(JL.getName(), JL);
        tablePanemail.setSelectedComponent(JL);

    }
    //EXECL批量导入
    private void BatchimportActionPerformed(ActionEvent e) {
        // TODO add your code here
        JPanel JL=new Batchimport().initComponents();
            for (int i=0;i<tablePanemail.getTabCount();i++){
                if (tablePanemail.getComponentAt(i).getName().equals(
                        JL.getName())){
                    tablePanemail.setSelectedIndex(i);
                    return;
                }
            }
        tablePanemail.addTab(JL.getName(), JL);
        tablePanemail.setSelectedComponent(JL);
    }
    //功能-单个关闭
    private void menuItem1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        if (tablePanemail.getTabCount()>=0){
            tablePanemail.remove(tablePanemail.getSelectedComponent());
        }
    }
    //全部关闭
    private void menuItem2ActionPerformed(ActionEvent e) {
        // TODO add your code here
        if (tablePanemail.getTabCount()>=0){
            tablePanemail.removeAll();
        }
    }
    //图标单个关闭
    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        if (tablePanemail.getTabCount()>=0){
            tablePanemail.remove(tablePanemail.getSelectedComponent());
        }
    }
    //借阅
    private void menuItem3ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        SystemmenuKJ = new JMenuBar();
        SystemmenuM = new JMenu();
        Signout = new JMenuItem();
        Dmanagement = new JMenu();
        Dnewadd = new JMenuItem();
        Dquery = new JMenuItem();
        Batchimport = new JMenuItem();
        menu2 = new JMenu();
        menuItem3 = new JMenuItem();
        menuBar1 = new JMenuBar();
        hSpacer1 = new JPanel(null);
        menu1 = new JMenu();
        menuItem1 = new JMenuItem();
        menuItem2 = new JMenuItem();
        button1 = new JButton();
        tablePanemail = new JTabbedPane();
        GridBagConstraints gbc;

        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {0, 0, 712, 0};
        ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {22, 0, 0, 300, 0, 0};
        ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0, 1.0E-4};
        ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0, 0.0, 1.0E-4};


        SystemmenuM.setText("\u7cfb\u7edf\u83dc\u5355"); //NON-NLS
        SystemmenuM.setFont(new Font("宋体", Font.PLAIN, 20)); //NON-NLS

        Signout.setText("\u9000\u51fa"); //NON-NLS
        Signout.setFont(new Font("宋体", Font.PLAIN, 20)); //NON-NLS
        Signout.addActionListener(e -> {
			SignoutActionPerformed(e);
			SignoutActionPerformed(e);
		});
        SystemmenuM.add(Signout);
        SystemmenuKJ.add(SystemmenuM);

        Dmanagement.setText("\u6587\u6863\u7ba1\u7406"); //NON-NLS
        Dmanagement.setFont(new Font("宋体", Font.PLAIN, 20)); //NON-NLS

        Dnewadd.setText("\u65b0\u589e"); //NON-NLS
        Dnewadd.setFont(new Font("宋体", Font.PLAIN, 20)); //NON-NLS
        Dnewadd.addActionListener(e -> DnewaddActionPerformed(e));
        Dmanagement.add(Dnewadd);

        Dquery.setText("\u67e5\u8be2"); //NON-NLS
        Dquery.setFont(new Font("宋体", Font.PLAIN, 20)); //NON-NLS
        Dquery.addActionListener(e -> DqueryActionPerformed(e));
        Dmanagement.add(Dquery);

        Batchimport.setText("EXECL\u5bfc\u5165"); //NON-NLS
        Batchimport.setFont(new Font("宋体", Font.PLAIN, 20)); //NON-NLS
        Batchimport.addActionListener(e -> BatchimportActionPerformed(e));
        Dmanagement.add(Batchimport);
        SystemmenuKJ.add(Dmanagement);

        menu2.setText("\u6587\u6863\u501f\u9605"); //NON-NLS
        menu2.setFont(new Font("宋体", Font.PLAIN, 20)); //NON-NLS

        menuItem3.setText("\u501f\u9605\u67e5\u8be2"); //NON-NLS
        menuItem3.setFont(new Font("宋体", Font.PLAIN, 20)); //NON-NLS
        menuItem3.addActionListener(e -> menuItem3ActionPerformed(e));
        menu2.add(menuItem3);
        SystemmenuKJ.add(menu2);
        setJMenuBar(SystemmenuKJ);

        menuBar1.add(hSpacer1);

        menu1.setText("\u529f\u80fd"); //NON-NLS
        menu1.setFont(new Font("宋体", Font.PLAIN, 15));
        menuItem1.setText("\u5355\u4e2a\u5173\u95ed"); //NON-NLS
        menuItem1.setFont(new Font("宋体", Font.PLAIN, 15));
        menuItem1.addActionListener(e -> menuItem1ActionPerformed(e));
        menu1.add(menuItem1);

        menuItem2.setText("\u5168\u90e8\u5173\u95ed"); //NON-NLS
        menuItem2.setFont(new Font("宋体", Font.PLAIN, 15));
        menuItem2.addActionListener(e -> menuItem2ActionPerformed(e));
        menu1.add(menuItem2);
        menuBar1.add(menu1);

        button1.addActionListener(e -> button1ActionPerformed(e));
        menuBar1.add(button1);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets.bottom = 5;
        contentPane.add(menuBar1, gbc);

        tablePanemail.setFont(new Font("宋体", Font.PLAIN, 20)); //NON-NLS
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.gridheight = 3;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets.bottom = 5;
        contentPane.add(tablePanemail, gbc);

        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        ImageIcon image=new ImageIcon("Icon/close.jpg");
        int width=20;//设置图标及按钮宽度
        int height=20;//设置图标及按钮高度
        image.setImage(image.getImage().getScaledInstance(width, height,Image.SCALE_DEFAULT ));//可以用下面三句代码来代替
        button1.setIcon(image);
        button1.setSize(width,height);
        Color c = new Color(0,0,0,255);//背影颜色随便设任意值,只起占位作用。
        button1.setBackground(c);
        button1.setOpaque(false);//设置透明
        //button1.setContentAreaFilled(false);//不绘制按钮区域
        button1.setBorderPainted(false);//不绘制边框
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar SystemmenuKJ;
    private JMenu SystemmenuM;
    private JMenuItem Signout;
    private JMenu Dmanagement;
    private JMenuItem Dnewadd;
    private JMenuItem Dquery;
    private JMenuItem Batchimport;
    private JMenu menu2;
    private JMenuItem menuItem3;
    private JMenuBar menuBar1;
    private JPanel hSpacer1;
    private JMenu menu1;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private JButton button1;
    private JTabbedPane tablePanemail;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
