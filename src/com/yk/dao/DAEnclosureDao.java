package com.yk.dao;

import com.yk.model.DAEnclosure;

import java.util.List;

public class DAEnclosureDao extends BaseDao {
    // 删除
    public void delete(String enclosureID) {
        String sql = "delete from DAEnclosure where EnclosureID=?";
        Object[] paramsValue = {enclosureID};
        super.update(sql, paramsValue);
    }

    // 新增附件信息（除附件文件）
    public void insert(DAEnclosure de) {
        String sql = "insert into DAEnclosure (EnclosureCode,EnclosureName,Createtime) values (?,?,?)";
        Object[] paramsValue = {de.getEnclosureCode(), de.getEnclosureName(), de.getCreatetime()};
        super.update(sql, paramsValue);
    }

    // 新增附件内容（二进制）
    public void update(byte[] paramsValue, String EnclosureID) {
        String sql = "update DAEnclosure set EnclosureContent=? where EnclosureID="+EnclosureID+"";
        super.update(sql, paramsValue);
    }

    // 查询附件名称
    public String getQueryEnclosureName(String EnclosureID) {
        String sql = "select EnclosureName from DAEnclosure where EnclosureID=?";
        return super.queryEnclosureName(sql, EnclosureID);
    }

    // 查询附件内容
    public byte[] getQueryEnclosure(String EnclosureID) {
        String sql = "select EnclosureContent from DAEnclosure where EnclosureID=?";
        byte[] Enclosure = super.queryEnclosure(sql, EnclosureID);
        return Enclosure;
    }

    // 查询全部
    public List<DAEnclosure> getQuery(String enclosureCode) {
        String sql = "select EnclosureID,EnclosureCode,EnclosureName,Createtime from DAEnclosure where EnclosureCode=? order by Createtime desc";
        List<DAEnclosure> list = super.query(sql, new Object[]{enclosureCode}, DAEnclosure.class);
        return list;
    }

    // 查询全部
    public int getEnclosureID(String enclosureCode) {
        String sql = "select top 1 EnclosureID from DAEnclosure where EnclosureCode=? order by Createtime desc";
        return super.queryEnclosureID(sql,enclosureCode);
    }

}
