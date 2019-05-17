/*
 * Created by JFormDesigner on Mon Nov 26 21:29:55 CST 2018
 */
package com.yk.view;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author 晏堃
 * @version V1
 */
public class Documentmanagement extends JFrame {
    Documentmanagement() {
        initComponents();
    }
    public static Documentmanagement getInstance(){
        if (instance == null) {
            synchronized (Documentmanagement.class) {
                if (instance == null) {
                    instance = new Documentmanagement();
                }
            }
        }
        return instance;


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
        try {
            JPanel JL = Documentadd.getInstance();

            for (int i = 0; i < tablePanemail.getTabCount(); i++) {
                if (tablePanemail.getComponentAt(i).getName().equals(
                        JL.getName())) {
                    tablePanemail.setSelectedIndex(i);
                    return;
                }
            }
            tablePanemail.addTab(JL.getName(), JL);
            tablePanemail.setSelectedComponent(JL);
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, e1.getMessage());
        }


    }

    //查询
    private void DqueryActionPerformed(ActionEvent e) {
        // TODO add your code here
        try {
            JPanel JL = Documentquery.getInstance();
            for (int i = 0; i < tablePanemail.getTabCount(); i++) {
                if (tablePanemail.getComponentAt(i).getName().equals(
                        JL.getName())) {
                    tablePanemail.setSelectedIndex(i);
                    return;
                }
            }
            tablePanemail.addTab(JL.getName(), JL);
            tablePanemail.setSelectedComponent(JL);
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, e1.getMessage());
        }

    }

    //EXECL批量导入
    private void BatchimportActionPerformed(ActionEvent e) {
        // TODO add your code here
        try {
            JPanel JL = Batchimport.getInstance();
            for (int i = 0; i < tablePanemail.getTabCount(); i++) {
                if (tablePanemail.getComponentAt(i).getName().equals(
                        JL.getName())) {
                    tablePanemail.setSelectedIndex(i);
                    return;
                }
            }
            tablePanemail.addTab(JL.getName(), JL);
            tablePanemail.setSelectedComponent(JL);
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, e1.getMessage());
        }
    }

    //功能-单个关闭
    private void menuItem1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        if (tablePanemail.getTabCount() >= 0) {
            tablePanemail.remove(tablePanemail.getSelectedComponent());
        }
    }

    //全部关闭
    private void menuItem2ActionPerformed(ActionEvent e) {
        // TODO add your code here
        if (tablePanemail.getTabCount() >= 0) {
            tablePanemail.removeAll();
        }
    }

    //图标单个关闭
    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        if (tablePanemail.getTabCount() >= 0) {
            tablePanemail.remove(tablePanemail.getSelectedComponent());
        }
    }

    //借阅
    private void menuItem3ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void menuItem4ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    //档案类别管理
    private void DocumentTypeActionPerformed(ActionEvent e) {
        // TODO add your code here
        try {
            JPanel JL = DADocumentTypeManager.getInstance();

            for (int i = 0; i < tablePanemail.getTabCount(); i++) {
                if (tablePanemail.getComponentAt(i).getName().equals(
                        JL.getName())) {
                    tablePanemail.setSelectedIndex(i);
                    return;
                }
            }
            tablePanemail.addTab(JL.getName(), JL);
            tablePanemail.setSelectedComponent(JL);
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, e1.getMessage());
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        SystemmenuKJ = new JMenuBar();
        SystemmenuM = new JMenu();
        Signout = new JMenuItem();
        menu3 = new JMenu();
        DocumentType = new JMenuItem();
        Dmanagement = new JMenu();
        Dnewadd = new JMenuItem();
        Dquery = new JMenuItem();
        JBatchimport = new JMenuItem();
        menu2 = new JMenu();
        menuItem3 = new JMenuItem();
        menuBar1 = new JMenuBar();
        hSpacer1 = new JPanel(null);
        menu1 = new JMenu();
        menuItem1 = new JMenuItem();
        menuItem2 = new JMenuItem();
        menuItem4 = new JMenuItem();
        button1 = new JButton();
        tablePanemail = new JTabbedPane();

        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout) contentPane.getLayout()).columnWidths = new int[]{0, 0, 712, 0};
        ((GridBagLayout) contentPane.getLayout()).rowHeights = new int[]{22, 0, 0, 300, 0, 0};
        ((GridBagLayout) contentPane.getLayout()).columnWeights = new double[]{0.0, 0.0, 1.0, 1.0E-4};
        ((GridBagLayout) contentPane.getLayout()).rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 1.0E-4};


        SystemmenuM.setText("\u7cfb\u7edf\u83dc\u5355"); //NON-NLS
        SystemmenuM.setFont(new Font("宋体", Font.PLAIN, 20)); //NON-NLS

        Signout.setText("\u9000\u51fa"); //NON-NLS
        Signout.setFont(new Font("宋体", Font.PLAIN, 20)); //NON-NLS
        Signout.addActionListener(e -> {
            SignoutActionPerformed(e);
        });
        SystemmenuM.add(Signout);
        SystemmenuKJ.add(SystemmenuM);

        menu3.setText("\u57fa\u7840\u8d44\u6599"); //NON-NLS
        menu3.setFont(new Font("宋体", Font.PLAIN, 20)); //NON-NLS

        DocumentType.setText("\u6863\u6848\u7c7b\u522b"); //NON-NLS
        DocumentType.setFont(new Font("宋体", Font.PLAIN, 20)); //NON-NLS
        DocumentType.addActionListener(e -> DocumentTypeActionPerformed(e));
        menu3.add(DocumentType);
        SystemmenuKJ.add(menu3);

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

        JBatchimport.setText("EXECL\u5bfc\u5165"); //NON-NLS
        JBatchimport.setFont(new Font("宋体", Font.PLAIN, 20)); //NON-NLS
        JBatchimport.addActionListener(e -> BatchimportActionPerformed(e));
        Dmanagement.add(JBatchimport);
        SystemmenuKJ.add(Dmanagement);

        menu2.setText("\u6587\u6863\u501f\u9605"); //NON-NLS
        menu2.setFont(new Font("宋体", menu2.getFont().getStyle(), menu2.getFont().getSize())); //NON-NLS

        menuItem3.setText("\u501f\u9605\u67e5\u8be2"); //NON-NLS
        menuItem3.addActionListener(e -> menuItem3ActionPerformed(e));
        menu2.add(menuItem3);
        SystemmenuKJ.add(menu2);
        setJMenuBar(SystemmenuKJ);

        menuBar1.add(hSpacer1);

        menu1.setText("\u529f\u80fd"); //NON-NLS

        menuItem1.setText("\u5355\u4e2a\u5173\u95ed"); //NON-NLS
        menuItem1.addActionListener(e -> menuItem1ActionPerformed(e));
        menu1.add(menuItem1);

        menuItem2.setText("\u5168\u90e8\u5173\u95ed"); //NON-NLS
        menuItem2.addActionListener(e -> menuItem2ActionPerformed(e));
        menu1.add(menuItem2);

        menuItem4.setText("\u9644\u4ef6\u7ba1\u7406"); //NON-NLS
        menuItem4.addActionListener(e -> menuItem4ActionPerformed(e));
        menu1.add(menuItem4);
        menuBar1.add(menu1);

        button1.addActionListener(e -> button1ActionPerformed(e));
        menuBar1.add(button1);
        contentPane.add(menuBar1, new GridBagConstraints(0, 0, 3, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

        tablePanemail.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 20)); //NON-NLS
        contentPane.add(tablePanemail, new GridBagConstraints(0, 1, 3, 3, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        SystemmenuM.setFont(new Font("宋体", Font.PLAIN, 20));
        Dmanagement.setFont(new Font("宋体", Font.PLAIN, 20));
        Signout.setFont(new Font("宋体", Font.PLAIN, 20));
        Dnewadd.setFont(new Font("宋体", Font.PLAIN, 20));
        Dquery.setFont(new Font("宋体", Font.PLAIN, 20));
        JBatchimport.setFont(new Font("宋体", Font.PLAIN, 20));
        menu2.setFont(new Font("宋体", Font.PLAIN, 20));
        menuItem3.setFont(new Font("宋体", Font.PLAIN, 20));
        menu1.setFont(new Font("宋体", Font.PLAIN, 15));
        menuItem1.setFont(new Font("宋体", Font.PLAIN, 15));
        menuItem2.setFont(new Font("宋体", Font.PLAIN, 15));
        tablePanemail.setFont(new Font("宋体", Font.PLAIN, 20));
        menu3.setFont(new Font("宋体", Font.PLAIN, 20));
        DocumentType.setFont(new Font("宋体", Font.PLAIN, 20));
        ImageIcon image = new ImageIcon("Icon/close.jpg");
        int width = 20;//设置图标及按钮宽度
        int height = 20;//设置图标及按钮高度
        image.setImage(image.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));//可以用下面三句代码来代替
        button1.setIcon(image);
        button1.setSize(width, height);
        Color c = new Color(0, 0, 0, 255);//背影颜色随便设任意值,只起占位作用。
        button1.setBackground(c);
        button1.setOpaque(false);//设置透明
        //button1.setContentAreaFilled(false);//不绘制按钮区域
        button1.setBorderPainted(false);//不绘制边框
        this.setResizable(false);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar SystemmenuKJ;
    private JMenu SystemmenuM;
    private JMenuItem Signout;
    private JMenu menu3;
    private JMenuItem DocumentType;
    private JMenu Dmanagement;
    private JMenuItem Dnewadd;
    private JMenuItem Dquery;
    private JMenuItem JBatchimport;
    private JMenu menu2;
    private JMenuItem menuItem3;
    private JMenuBar menuBar1;
    private JPanel hSpacer1;
    private JMenu menu1;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private JMenuItem menuItem4;
    private JButton button1;
    private JTabbedPane tablePanemail;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private static Documentmanagement instance;
}
