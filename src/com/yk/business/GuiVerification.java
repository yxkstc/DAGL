package com.yk.business;


import com.yk.model.Column;
import com.yk.model.DocumentManagement;
import com.yk.model.XmlTableModel;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import javax.swing.*;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


public class GuiVerification {
    public static void FieldVerification(String txt, String lable) {
        JOptionPane.showMessageDialog(null, "请输入" + lable, "错误", JOptionPane.ERROR_MESSAGE);

    }

    //文档管理list封装
    public List<DocumentManagement> GetModel(JTable table) {
        List<DocumentManagement> list = new ArrayList<>();
        for (int i = 0; i < table.getRowCount(); i++) {
            DocumentManagement DM = new DocumentManagement();
            DM.setDocumentcoding(table.getValueAt(i, 0));
            DM.setPersonliable(table.getValueAt(i, 1));
            DM.setTheme(table.getValueAt(i, 2));
            DM.setDocumentType(table.getValueAt(i, 3));
            DM.setThenumberofpages(table.getValueAt(i, 4));
            DM.setArchivalyear(table.getValueAt(i, 5));
            DM.setStorageposition(table.getValueAt(i, 6));
            DM.setRemarks(table.getValueAt(i, 7));
            DM.setCreatetime(table.getValueAt(i, 8));
            list.add(DM);
        }
        return list;
    }


    //获取当前时间yyyyMMddHHmmss
    public static String nowtime() {
        Date nowtime = new Date();
        DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(nowtime);
    }

    //获取当前时间year
    public static String nowTimeYear() {
        String time = nowtime();
        return time.substring(0, 4);
    }

    /**
     * 解析指定的xml文件，生成表格数据模型
     *
     * @param name xml文件路径名称
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

}
