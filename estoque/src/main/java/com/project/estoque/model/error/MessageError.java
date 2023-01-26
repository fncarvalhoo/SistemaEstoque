package com.project.estoque.model.error;

public class MessageError {

    private String dateTime;

    private Integer status;

    private String tittle;

    private String message;

    public MessageError(String dateTime, Integer status, String tittle, String message) {
        this.dateTime = dateTime;
        this.status = status;
        this.tittle = tittle;
        this.message = message;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
