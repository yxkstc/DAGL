package com.yk.model;

public class BatchImportOfAttachmentsModel {
    private Object Documentcoding;
    private Object Path;
    private Object State;
    private Object ErrorMessage;

    public Object getErrorMessage() {
        return ErrorMessage;
    }

    public void setErrorMessage(Object errorMessage) {
        ErrorMessage = errorMessage;
    }

    public Object getDocumentcoding() {
        return Documentcoding;
    }

    public void setDocumentcoding(Object documentcoding) {
        Documentcoding = documentcoding;
    }

    public Object getPath() {
        return Path;
    }

    public void setPath(Object path) {
        Path = path;
    }

    public Object getState() {
        return State;
    }

    public void setState(Object state) {
        this.State = state;
    }

    @Override
    public String toString() {
        return "BatchImportOfAttachmentsModel{" +
                "Documentcoding=" + Documentcoding +
                ", Path=" + Path +
                ", State=" + State +
                ", ErrorMessage=" + ErrorMessage +
                '}';
    }
}
