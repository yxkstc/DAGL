package com.yk.business;

import com.yk.dao.DocumentManagementDao;
import com.yk.model.Column;
import com.yk.model.DocumentManagement;
import com.yk.model.XmlTableModel;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


public class GuiVerification {
    public static int FieldVerification(String txt, String lable) {
        int count = 0;
        if (txt.equals("")) {
            JOptionPane.showMessageDialog(null, "请输入" + lable, "错误", JOptionPane.ERROR_MESSAGE);
            count = 1;
        }
        return count;
    }


    public static DefaultTableModel queryTableModel(List table) {
        Object[][] data=null;
        List<DocumentManagement> list=table;
        data=new Object[list.size()][9];
        for(int i=0;i<list.size();i++){
            data[i][0]=list.get(i).getDocumentcoding();
            data[i][1]=list.get(i).getPersonliable();
            data[i][2]=list.get(i).getTheme();
            data[i][3]=list.get(i).getTitle();
            data[i][4]=list.get(i).getThenumberofpages();
            data[i][5]=list.get(i).getArchivalyear();
            data[i][6]=list.get(i).getStorageposition();
            data[i][7]=list.get(i).getRemarks();
            data[i][8]=list.get(i).getCreatetime();
        }
        DefaultTableModel tableModel=new DefaultTableModel(data,getHead()){//设置第一列不能编辑
            @Override
            public boolean isCellEditable(int row,int column){
                if (column == 0) {
                    return false;
                }else {
                    return true;
                }

            }
        };
        return tableModel;
    }

    public  List<DocumentManagement>  GetModel(JTable table){
        List<DocumentManagement> list = new ArrayList<>();
        for (int i=0;i<table.getRowCount();i++){
            DocumentManagement DM=new DocumentManagement();
            DM.setDocumentcoding(table.getValueAt(i,0));
            DM.setPersonliable(table.getValueAt(i,1));
            DM.setTheme(table.getValueAt(i,2));
            DM.setTitle(table.getValueAt(i,3));
            DM.setThenumberofpages(table.getValueAt(i,4));
            DM.setArchivalyear(table.getValueAt(i,5));
            DM.setStorageposition(table.getValueAt(i,6));
            DM.setRemarks(table.getValueAt(i,7));
            DM.setCreatetime(table.getValueAt(i,8));
            list.add(DM);
        }
        return list;
    }
    //批量修改
    public DocumentManagement updateData(JTable table,int i){
        DocumentManagement DM=new DocumentManagement();
        DM.setDocumentcoding(table.getValueAt(i,0));
        DM.setPersonliable(table.getValueAt(i,1));
        DM.setTheme(table.getValueAt(i,2));
        DM.setTitle(table.getValueAt(i,3));
        DM.setThenumberofpages(table.getValueAt(i,4));
        DM.setArchivalyear(table.getValueAt(i,5));
        DM.setStorageposition(table.getValueAt(i,6));
        DM.setRemarks(table.getValueAt(i,7));
        DM.setCreatetime(table.getValueAt(i,8));
        return DM;
    }

    //获取当前时间
    public String nowtime(){
        Date nowtime=new Date();
        DateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(nowtime);
    }

    /**
     * 解析指定的xml文件，生成表格数据模型
     *
     * @param name
     *            xml文件路径名称
     * @return XmlTableModel
     */
    public XmlTableModel getModel(String name) {
        Document doc = getDocument(name);
        List<Column> columns = getComumns(doc);
        Vector<Object[]> vector = getRows(doc, columns);
        Object[] names = columns.toArray(new Column[columns.size()]);
        return new XmlTableModel(names, vector);

    }

    /**
     * 解析指定的xml文件，返回其文档对象
     *
     * @param file
     * @return
     */
    public Document getDocument(String file) {
        SAXReader reader = new SAXReader();
        Document document = null;
        try {
            document = reader.read(new File(file));
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return document;
    }

    /**
     * 解析xml Dom中的列
     *
     * @param doc
     * @return
     */
    private List<Column> getComumns(Document doc) {
        ArrayList<Column> list = new ArrayList<Column>();
        Element root = doc.getRootElement();
        Iterator<Element> el = root.element("columns")
                .elementIterator("column");
        while (el.hasNext()) {
            Element e = (Element) el.next();
            Column c = new Column(e.attributeValue("name"), e
                    .attributeValue("type"));
            list.add(c);
        }
        return list;
    }

    /**
     * 解析xml Dom中的行
     *
     * @param doc
     * @param columns
     * @return
     */
    private Vector<Object[]> getRows(Document doc, List<Column> columns) {
        Vector<Object[]> vector = new Vector<Object[]>();
        Element root = doc.getRootElement();
        List<Node> trList = root.elements("tr");
        for (int i = 0; i < trList.size(); i++) {
            Element tr = (Element) trList.get(i);
            List<Object> list2 = new ArrayList<Object>();
            List<Node> tdList = tr.elements("td");
            for (int j = 0; j < tdList.size(); j++) {
                Element td = (Element) tdList.get(j);
                list2
                        .add(getTDValue(columns.get(j).getType(), td
                                .getTextTrim()));
            }
            vector.add(list2.toArray(new Object[list2.size()]));
        }
        return vector;
    }
    /**
     * 根据列定义的类型，对单元格中的数据进行类型转换
     *
     * @param type
     * @param value
     * @return
     */
    private Object getTDValue(String type, String value) {
        if ("java.lang.Integer".equals(type)) {
            return Integer.parseInt(value);
        }
        if ("java.lang.Boolean".equals(type)) {
            return Boolean.parseBoolean(value);
        }
        return value;
    }

    //返回DefaultTableModel

    public DefaultTableModel selectTabel(int[] row, JTable table){
        Object[][] data=new Object[row.length][9];
        for (int i=0;i<row.length;i++){
            data[i][0]=table.getValueAt(row[i],0);
            data[i][1]=table.getValueAt(row[i],1);
            data[i][2]=table.getValueAt(row[i],2);
            data[i][3]=table.getValueAt(row[i],3);
            data[i][4]=table.getValueAt(row[i],4);
            data[i][5]=table.getValueAt(row[i],5);
            data[i][6]=table.getValueAt(row[i],6);
            data[i][7]=table.getValueAt(row[i],7);
            data[i][8]=table.getValueAt(row[i],8);
        }
        DefaultTableModel tableModel=new DefaultTableModel(data,getHead());
        return tableModel;
    }

    //档案表头
    public static  final String[] getHead(){
        return new String[]{"档案号","责任人","主题","题名","页数","日期","存储位置","备注","创建时间"};
    }

}
