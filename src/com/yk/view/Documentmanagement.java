/*
 * Created by JFormDesigner on Mon Nov 26 21:29:55 CST 2018
 */

package com.yk.view;

import java.awt.*;
import java.awt.event.*;
import java.util.Map;
import javax.swing.*;

/**
 * @author Brainrain
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
        tablePanemail.addTab(JL.getName(), JL);
        tablePanemail.setSelectedComponent(JL);

    }

    //查询
    private void DqueryActionPerformed(ActionEvent e) {
        // TODO add your code here
        JPanel JL=new Documentquery().initComponents();
            tablePanemail.addTab(JL.getName(), JL);
            tablePanemail.setSelectedComponent(JL);

    }
    //EXECL批量导入
    private void BatchimportActionPerformed(ActionEvent e) {
        // TODO add your code here
        JPanel JL=new Batchimport().initComponents();
        tablePanemail.addTab(JL.getName(), JL);
        tablePanemail.setSelectedComponent(JL);
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
        panel1 = new JPanel();
        tablePanemail = new JTabbedPane();

        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {0, 0, 712, 0};
        ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {0, 0, 0, 295, 0};
        ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0, 1.0E-4};
        ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0, 1.0E-4};


        SystemmenuM.setText("\u7cfb\u7edf\u83dc\u5355"); //NON-NLS
        SystemmenuM.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20)); //NON-NLS

        Signout.setText("\u9000\u51fa"); //NON-NLS
        Signout.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20)); //NON-NLS
        Signout.addActionListener(e -> {
			SignoutActionPerformed(e);
			SignoutActionPerformed(e);
		});
        SystemmenuM.add(Signout);
        SystemmenuKJ.add(SystemmenuM);

        Dmanagement.setText("\u6587\u6863\u7ba1\u7406"); //NON-NLS
        Dmanagement.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20)); //NON-NLS

        Dnewadd.setText("\u65b0\u589e"); //NON-NLS
        Dnewadd.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20)); //NON-NLS
        Dnewadd.addActionListener(e -> DnewaddActionPerformed(e));
        Dmanagement.add(Dnewadd);

        Dquery.setText("\u67e5\u8be2"); //NON-NLS
        Dquery.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20)); //NON-NLS
        Dquery.addActionListener(e -> DqueryActionPerformed(e));
        Dmanagement.add(Dquery);

        Batchimport.setText("EXECL\u5bfc\u5165"); //NON-NLS
        Batchimport.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20)); //NON-NLS
        Batchimport.addActionListener(e -> BatchimportActionPerformed(e));
        Dmanagement.add(Batchimport);
        SystemmenuKJ.add(Dmanagement);
        setJMenuBar(SystemmenuKJ);

        panel1.setLayout(new GridBagLayout());
        ((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {0, 0};
        ((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {0, 0};
        ((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
        ((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {0.0, 1.0E-4};
        contentPane.add(panel1, new GridBagConstraints(0, 0, 3, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));

        tablePanemail.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 20)); //NON-NLS
        contentPane.add(tablePanemail, new GridBagConstraints(0, 1, 3, 3, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar SystemmenuKJ;
    private JMenu SystemmenuM;
    private JMenuItem Signout;
    private JMenu Dmanagement;
    private JMenuItem Dnewadd;
    private JMenuItem Dquery;
    private JMenuItem Batchimport;
    private JPanel panel1;
    private JTabbedPane tablePanemail;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
