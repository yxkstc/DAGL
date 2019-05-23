package com.yk.dao;

import com.yk.model.DocumentManagement;

import java.util.List;

public class DocumentManagementDao extends BaseDao {

    // 删除
    public void delete(String Documentcoding) {
        String sql = "delete from DocumentManagement where Documentcoding=?";
        Object[] paramsValue = {Documentcoding};
        super.update(sql, paramsValue);
    }

    // 新增
    public void insert(DocumentManagement dm) {
        String sql = "insert into DocumentManagement (Documentcoding,Personliable,Theme,DocumentType,Thenumberofpages,Archivalyear,Storageposition,Remarks,Createtime) values (?,?,?,?,?,?,?,?,?)";
        Object[] paramsValue = {dm.getDocumentcoding(), dm.getPersonliable(), dm.getTheme(), dm.getDocumentType(), dm.getThenumberofpages(), dm.getArchivalyear(), dm.getStorageposition(), dm.getRemarks(), dm.getCreatetime()};
        super.update(sql, paramsValue);
    }

    // 查询全部
    public List<DocumentManagement> getAll() {
        String sql = "select * from DocumentManagement";
        List<DocumentManagement> list = super.query(sql, null, DocumentManagement.class);
        return list;
    }

    // 查询类别
    public List<DocumentManagement> getDocumentType() {
        String sql = "select DocumentType from DocumentManagement";
        List<DocumentManagement> list = super.query(sql, null, DocumentManagement.class);
        return list;
    }

    // 根据条件查询(用户名)
    public DocumentManagement findByUserNameAndPwd(String Username) {
        String sql = "select * from DocumentManagement where Username=?";
        List<DocumentManagement> list = super.query(sql, new Object[]{Username}, DocumentManagement.class);
        return (list != null && list.size() > 0) ? list.get(0) : null;
    }

    //查询档案编码最大值
    public List<DocumentManagement> CodeMaxQuery() {
        String sql = "select top 1 Documentcoding from DocumentManagement order by Documentcoding Desc";
        List<DocumentManagement> list = super.query(sql, null, DocumentManagement.class);
        return list;
    }

    //按档案类别查询对应编码最大值
    public String tpyeCodeQuery(String code) {
        String sql = "select top 1 Documentcoding from DocumentManagement where Documentcoding like '"+code+"%' order by Documentcoding Desc";
        List<DocumentManagement> list = super.query(sql, null, DocumentManagement.class);
        return list.size() == 0 ? "0" : list.get(0).getDocumentcoding().toString();
    }

    //组合查询
    public List<DocumentManagement> CombinationQuery(String Dlysql) {
        String sql = "select * from DocumentManagement where " + Dlysql;
        List<DocumentManagement> list = super.query(sql, null, DocumentManagement.class);
        return list;
    }

    //更新
    public void update(DocumentManagement dm) {
        String sql = "update DocumentManagement set Personliable=?,Theme=?,DocumentType=?,Thenumberofpages=?,Archivalyear=?,Storageposition=?,Remarks=?,Createtime=? where Documentcoding=?";
        Object[] paramsValue = {dm.getPersonliable(), dm.getTheme(), dm.getDocumentType(), dm.getThenumberofpages(), dm.getArchivalyear(), dm.getStorageposition(), dm.getRemarks(), dm.getCreatetime(), dm.getDocumentcoding()};
        super.update(sql, paramsValue);
    }

}
