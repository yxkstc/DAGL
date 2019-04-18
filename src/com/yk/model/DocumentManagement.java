package com.yk.model;
/**
 * 文档管理
 * Documentcoding 文档编码
 * Personliable 责任人
 * Theme 主题
 * Title 文件类别
 * Thenumberofpages 创建时间
 * Archivalyear 年限
 * Storageposition 页数
 * Remarks 备注
 * Createtime 创建时间
 * */
public class DocumentManagement {

  private Object Documentcoding;
  private Object Personliable;
  private Object Theme;
  private Object DocumentType;
  private Object Thenumberofpages;
  private Object Archivalyear;
  private Object Storageposition;
  private Object Remarks;
  private Object Createtime;

  public Object getDocumentcoding() {
    return Documentcoding;
  }

  public void setDocumentcoding(Object documentcoding) {
    Documentcoding = documentcoding;
  }

  public Object getPersonliable() {
    return Personliable;
  }

  public void setPersonliable(Object personliable) {
    Personliable = personliable;
  }

  public Object getTheme() {
    return Theme;
  }

  public void setTheme(Object theme) {
    Theme = theme;
  }

  public Object getDocumentType() {
    return DocumentType;
  }

  public void setDocumentType(Object documentType) {
    DocumentType = documentType;
  }

  public Object getThenumberofpages() {
    return Thenumberofpages;
  }

  public void setThenumberofpages(Object thenumberofpages) {
    Thenumberofpages = thenumberofpages;
  }

  public Object getArchivalyear() {
    return Archivalyear;
  }

  public void setArchivalyear(Object archivalyear) {
    Archivalyear = archivalyear;
  }

  public Object getStorageposition() {
    return Storageposition;
  }

  public void setStorageposition(Object storageposition) {
    Storageposition = storageposition;
  }

  public Object getRemarks() {
    return Remarks;
  }

  public void setRemarks(Object remarks) {
    Remarks = remarks;
  }

  public Object getCreatetime() {
    return Createtime;
  }

  public void setCreatetime(Object createtime) {
    Createtime = createtime;
  }

  @Override
  public String toString() {
    return "DocumentManagement{" +
            "Documentcoding=" + Documentcoding +
            ", Personliable=" + Personliable +
            ", Theme=" + Theme +
            ", DocumentType=" + DocumentType +
            ", Thenumberofpages=" + Thenumberofpages +
            ", Archivalyear=" + Archivalyear +
            ", Storageposition=" + Storageposition +
            ", Remarks=" + Remarks +
            ", Createtime=" + Createtime +
            '}';
  }
}


