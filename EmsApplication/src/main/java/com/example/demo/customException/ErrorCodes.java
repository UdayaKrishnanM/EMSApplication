package com.example.demo.customException;

import java.util.Date;

public class ErrorCodes {

    private Date timeStamp;
    private String message;
    private int http;
    private int status;

    @Override
    public String toString() {
        return "ErrorCodes{" +
                "timeStamp='" + timeStamp + '\'' +
                ", message='" + message + '\'' +
                ", http=" + http +
                ", status=" + status +
                '}';
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getHttp() {
        return http;
    }

    public void setHttp(int http) {
        this.http = http;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
