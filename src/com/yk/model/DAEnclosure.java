package com.yk.model;

/**
 * 文档管理-附件管理
 * EnclosureID 附件id
 * EnclosureCode 附件编码为文件编码
 * EnclosureName 附件名称
 * EnclosureContent 附件二进制存储
 * Createtime 创建时间
 */
public class DAEnclosure {
    private Object EnclosureID;
    private Object EnclosureCode;
    private Object EnclosureName;
    private byte[] EnclosureContent;
    private Object Createtime;

    public Object getEnclosureID() {
        return EnclosureID;
    }

    public void setEnclosureID(Object enclosureID) {
        EnclosureID = enclosureID;
    }

    public Object getEnclosureCode() {
        return EnclosureCode;
    }

    public void setEnclosureCode(Object enclosureCode) {
        EnclosureCode = enclosureCode;
    }

    public Object getEnclosureName() {
        return EnclosureName;
    }

    public void setEnclosureName(Object enclosureName) {
        EnclosureName = enclosureName;
    }

    public byte[] getEnclosureContent() {
        return EnclosureContent;
    }

    public void setEnclosureContent(byte[] enclosureContent) {
        EnclosureContent = enclosureContent;
    }

    public Object getCreatetime() {
        return Createtime;
    }

    public void setCreatetime(Object createtime) {
        Createtime = createtime;
    }

    @Override
    public String toString() {
        return "DAEnclosure{" +
                "EnclosureID=" + EnclosureID +
                ", EnclosureCode=" + EnclosureCode +
                ", EnclosureName=" + EnclosureName +
                ", EnclosureContent=" + EnclosureContent +
                ", Createtime=" + Createtime +
                '}';
    }
}
