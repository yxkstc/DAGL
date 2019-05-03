package com.yk.model;

public class TypeNameJComboBox {
    private String TypeNameEnglish;
    private String TypeNameChinese;

    public String getTypeNameEnglish() {
        return TypeNameEnglish;
    }

    public void setTypeNameEnglish(String typeNameEnglish) {
        TypeNameEnglish = typeNameEnglish;
    }

    public String getTypeNameChinese() {
        return TypeNameChinese;
    }

    public void setTypeNameChinese(String typeNameChinese) {
        TypeNameChinese = typeNameChinese;
    }

    @Override
    public String toString() {
        return TypeNameChinese;
    }
}
