/*
 * Created by JFormDesigner on Fri Nov 23 17:10:41 CST 2018
 */

package com.yk.view;


import com.yk.business.GuiVerification;
import com.yk.dao.DocumentManagementDao;
import com.yk.model.DocumentManagement;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 * @author Brainrain
 */
public class Compositequery extends JFrame {
    public Compositequery() {
        initComponents();
        String [] head={
                "左括号", "过滤条件", "比较符号", "比较值","右括号","逻辑符"
        };
        DefaultTableModel tableModel=new DefaultTableModel(queryTable(),head);
        table1.setModel(tableModel);
        JComboBox c0 = new JComboBox();
        c0.addItem("");
        c0.addItem("(");
        c0.addItem("((");
        c0.addItem("(((");
        c0.addItem("((((");
        c0.addItem("(((((");
        c0.addItem("((((((");
        table1.getColumnModel().getColumn(0)
                .setCellEditor(new DefaultCellEditor(c0));

        JComboBox c1 = new JComboBox();
        c1.addItem("");
        c1.addItem(tree2.getPathForRow(1).getPathComponent(1));
        c1.addItem(tree2.getPathForRow(2).getPathComponent(1));
        c1.addItem(tree2.getPathForRow(3).getPathComponent(1));
        c1.addItem(tree2.getPathForRow(4).getPathComponent(1));
        c1.addItem(tree2.getPathForRow(5).getPathComponent(1));
        c1.addItem(tree2.getPathForRow(6).getPathComponent(1));
        c1.addItem(tree2.getPathForRow(7).getPathComponent(1));
        c1.addItem(tree2.getPathForRow(8).getPathComponent(1));
        table1.getColumnModel().getColumn(1)
                .setCellEditor(new DefaultCellEditor(c1));

        JComboBox c2 = new JComboBox();
        c2.addItem("");
        c2.addItem("等于");
        c2.addItem("不等于");
        c2.addItem("类似");
        c2.addItem("大于");
        c2.addItem("大于等于");
        c2.addItem("小于");
        c2.addItem("小于等于");
        table1.getColumnModel().getColumn(2)
                .setCellEditor(new DefaultCellEditor(c2));

        JComboBox c4 = new JComboBox();
        c4.addItem("");
        c4.addItem(")");
        c4.addItem("))");
        c4.addItem(")))");
        c4.addItem("))))");
        c4.addItem(")))))");
        c4.addItem("))))))");
        table1.getColumnModel().getColumn(4)
                .setCellEditor(new DefaultCellEditor(c4));

        JComboBox c5 = new JComboBox();
        c5.addItem("");
        c5.addItem("且");
        c5.addItem("或");
        table1.getColumnModel().getColumn(5)
                .setCellEditor(new DefaultCellEditor(c5));

    }
    //查询事件
    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here

    }
    //确认事件
    private void ConfirmActionPerformed(ActionEvent e) {
        // TODO add your code here
        String Dlysql;
        if (tableValue().trim().length()>0){
            Dlysql=tableValue();
        }else{
            Dlysql="1=1";
        }
        List<DocumentManagement> list= new com.yk.dao.DocumentManagementDao().CombinationQuery(Dlysql);
        this.dispose();
        Documentquery.setArchivesquery(GuiVerification.queryTableModel(list));

    }
    //取消事件
    private void CancelActionPerformed(ActionEvent e) {
        // TODO add your code here
        this.dispose();
    }

    //双击tree时间
    private void tree2ValueChanged(TreeSelectionEvent e) {
        // TODO add your code here
        if(table1.isCellSelected(table1.getSelectedRow(), table1.getSelectedColumn())){
            table1.setValueAt(e.getPath().getPathComponent(1),table1.getSelectedRow(), table1.getSelectedColumn());
        }

    }






    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        textField6 = new JTextField();
        button1 = new JButton();
        scrollPane2 = new JScrollPane();
        tree2 = new JTree();
        scrollPane3 = new JScrollPane();
        table1 = new JTable();
        Confirm = new JButton();
        Cancel = new JButton();

        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {17, 100, 0, 109, 51, 0, 0};
        ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {0, 0, 201, 0, 0};
        ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0E-4};
        ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {0.0, 0.0, 1.0, 0.0, 1.0E-4};
        contentPane.add(textField6, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

        button1.addActionListener(e -> {
            button1ActionPerformed(e);
            button1ActionPerformed(e);
        });
        contentPane.add(button1, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));


        tree2.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 20)); //NON-NLS
        tree2.setModel(queryTree());
        tree2.addTreeSelectionListener(e -> tree2ValueChanged(e));
        scrollPane2.setViewportView(tree2);
        contentPane.add(scrollPane2, new GridBagConstraints(1, 2, 2, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));


        table1.setColumnSelectionAllowed(true);
        table1.setCellSelectionEnabled(true);
        table1.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 20)); //NON-NLS
        scrollPane3.setViewportView(table1);
        contentPane.add(scrollPane3, new GridBagConstraints(3, 2, 3, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

        Confirm.setText("\u786e\u8ba4"); //NON-NLS
        Confirm.addActionListener(e -> ConfirmActionPerformed(e));
        contentPane.add(Confirm, new GridBagConstraints(4, 3, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));

        Cancel.setText("\u53d6\u6d88"); //NON-NLS
        Cancel.addActionListener(e -> CancelActionPerformed(e));
        contentPane.add(Cancel, new GridBagConstraints(5, 3, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JTextField textField6;
    private JButton button1;
    private JScrollPane scrollPane2;
    private JTree tree2;
    private JScrollPane scrollPane3;
    private JTable table1;
    private JButton Confirm;
    private JButton Cancel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    //初始化查询表
    public Object[][] queryTable(){
        Object[][] table=null;
        table=new Object[][] {
                {"", "", "", "",""},
                {"", "", "", "",""},
                {"", "", "", "",""},
                {"", "", "", "",""},
                {"", "", "", "",""},
                {"", "", "", "",""}
        };

        return table;
    }
    //初始化查询树
    public DefaultTreeModel queryTree(){
        DefaultMutableTreeNode root=new DefaultMutableTreeNode("系统字段");
        DefaultMutableTreeNode Documentcoding=new DefaultMutableTreeNode("文档编码");
        DefaultMutableTreeNode Theme=new DefaultMutableTreeNode("主题");
        DefaultMutableTreeNode Title=new DefaultMutableTreeNode("文件名称");
        DefaultMutableTreeNode Thenumberofpages=new DefaultMutableTreeNode("页数");
        DefaultMutableTreeNode Archivalyear=new DefaultMutableTreeNode("归档年");
        DefaultMutableTreeNode Storageposition=new DefaultMutableTreeNode("存储位置");
        DefaultMutableTreeNode Remarks=new DefaultMutableTreeNode("备注");
        DefaultMutableTreeNode Createtime=new DefaultMutableTreeNode("创建时间");
        DefaultTreeModel treeModel=new DefaultTreeModel(root);
        treeModel.insertNodeInto(Documentcoding,root, root.getChildCount());
        treeModel.insertNodeInto(Theme,root, root.getChildCount());
        treeModel.insertNodeInto(Title,root, root.getChildCount());
        treeModel.insertNodeInto(Thenumberofpages,root, root.getChildCount());
        treeModel.insertNodeInto(Archivalyear,root, root.getChildCount());
        treeModel.insertNodeInto(Storageposition,root, root.getChildCount());
        treeModel.insertNodeInto(Remarks,root, root.getChildCount());
        treeModel.insertNodeInto(Createtime,root, root.getChildCount());



        return treeModel;
    }
    //table第二列字段中文名转换为英文
    public String IsValue(String a){
        String value="";
        value=a;
        switch(value){
            case "文档编码":
                value="Documentcoding";
                break;
            case "主题":
                value="Theme";
                break;
            case "文件名称":
                value="Title";
                break;
            case "页数":
                value="Thenumberofpages";
                break;
            case "归档年":
                value="Archivalyear";
                break;
            case "存储位置":
                value="Storageposition";
                break;
            case "备注":
                value="Remarks";
                break;
            case "等于":
                value="=";
                break;
            case "不等于":
                value="!=";
                break;
            case "类似":
                value="like";
                break;
            case "大于":
                value=">";
                break;
            case "大于等于":
                value=">=";
                break;
            case "小于":
                value="<";
                break;
            case "小于等于":
                value="<=";
                break;
            case "且":
                value="and";
                break;
            case "或":
                value="or";
                break;
            default:
                value=a;
                break;
        }

        return value;
    }
    //拼接table转为字符串
    public  String tableValue(){
        String value="";
        for (int i=0;i<table1.getRowCount();i++){
            for (int j=0;j<table1.getColumnCount();j++){
                if (table1.getValueAt(i,j)!=null) {
                    value +=IsValue(table1.getValueAt(i, j).toString().trim())+" ";
                    if (IsValue(table1.getValueAt(i, j).toString().trim()).equals("=")){
                        value +="'";
                    }else if(((j>1)&&(IsValue(table1.getValueAt(i, j-1).toString().trim()).equals("=")))){
                        value =value.trim()+"'";
                    }
                    else if(IsValue(table1.getValueAt(i, j).toString().trim()).equals("like")){
                        value +="'%";
                    }else if(((j>1)&&(IsValue(table1.getValueAt(i, j-1).toString().trim()).equals("like")))){
                        value =value.trim()+"%'";
                    }

                }
            }
        }

        return value;
    }


}
