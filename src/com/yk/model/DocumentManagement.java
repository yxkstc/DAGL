package com.yk.model;


public class DocumentManagement {

  private Object Documentcoding;
  private Object Personliable;
  private Object Theme;
  private Object Title;
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

  public Object getTitle() {
    return Title;
  }

  public void setTitle(Object title) {
    Title = title;
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
            ", Title=" + Title +
            ", Thenumberofpages=" + Thenumberofpages +
            ", Archivalyear=" + Archivalyear +
            ", Storageposition=" + Storageposition +
            ", Remarks=" + Remarks +
            ", Createtime=" + Createtime +
            '}';
  }
}


