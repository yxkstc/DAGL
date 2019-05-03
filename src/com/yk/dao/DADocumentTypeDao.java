package com.yk.dao;

import com.yk.model.DADocumentType;
import com.yk.model.TypeNameJComboBox;

import java.util.List;

public class DADocumentTypeDao extends BaseDao {
    // 删除
    public void delete(String typenamechinese) {
        String sql = "delete from DADocumentType where TypeNameChinese=?";
        Object[] paramsValue = {typenamechinese};
        super.update(sql, paramsValue);
    }

    // 新增
    public void insert(DADocumentType de) {
        String sql = "insert into DADocumentType (TypeNameEnglish,TypeNameChinese,State,Createtime) values (?,?,?,?)";
        Object[] paramsValue = {de.getTypeNameEnglish(), de.getTypeNameChinese(), de.getState(), de.getCreatetime()};
        super.update(sql, paramsValue);
    }

    // 查询全部
    public List<DADocumentType> getQueryAll() {
        String sql = "select TypeID,TypeNameEnglish,TypeNameChinese,State,Createtime from DADocumentType order by TypeID";
        List<DADocumentType> list = super.query(sql, null, DADocumentType.class);
        return list;
    }

    // 查询文档类别单据状态为1(启用)的
    public List<DADocumentType> getQueryStateQiYong() {
        String sql = "select TypeID,TypeNameEnglish,TypeNameChinese,State,Createtime from DADocumentType where State='1' order by TypeID";
        List<DADocumentType> list = super.query(sql, null, DADocumentType.class);
        return list;
    }

    // 查询文档类别单据状态为2(禁用的)的
    public List<DADocumentType> getQueryStatePerformed() {
        String sql = "select TypeID,TypeNameEnglish,TypeNameChinese,State,Createtime from DADocumentType where State='2' order by TypeID";
        List<DADocumentType> list = super.query(sql, null, DADocumentType.class);
        return list;
    }

    // 查询状态值
    public List<DADocumentType> getQueryStateValue() {
        String sql = "SELECT DISTINCT State from DADocumentType";
        List<DADocumentType> list = super.query(sql, null, DADocumentType.class);
        return list;
    }

    // 查询文档编码
    public List<TypeNameJComboBox> getQueryTypeNameEnglish() {
        String sql = "SELECT DISTINCT TypeNameEnglish,TypeNameChinese from DADocumentType where State=1";
        List<TypeNameJComboBox> list = super.query(sql, null, TypeNameJComboBox.class);
        return list;
    }

    // 修改单据状态为禁用
    public void updateStateProhiBituse(DADocumentType dt) {
        String sql = "update DADocumentType set State=? where TypeID=?";
        Object[] paramsValue = {dt.getState(), dt.getTypeID()};
        super.update(sql, paramsValue);
    }

    // 修改单据状态为启用
    public void updateStateQiYong(DADocumentType dt) {
        String sql = "update DADocumentType set State=? where TypeID=?";
        Object[] paramsValue = {dt.getState(), dt.getTypeID()};
        super.update(sql, paramsValue);
    }

    // 批量修改文档类别
    public void update(DADocumentType dt) {
        String sql = "update DADocumentType set TypeNameEnglish=?,TypeNameChinese=?,State=?,Createtime=? where TypeID=?";
        Object[] paramsValue = {dt.getTypeNameEnglish(), dt.getTypeNameChinese(), dt.getState(), dt.getCreatetime(), dt.getTypeID()};
        super.update(sql, paramsValue);
    }

}
