package com.job_room.annoouncement_service.exception;

import org.springframework.http.HttpStatus;

import java.sql.Timestamp;

public class ErrorMessage<S, S1> {

    private String message;
    private HttpStatus status;
    private Timestamp time;
    private String content1,content2;

    public ErrorMessage() {
    }

    public ErrorMessage(String message, HttpStatus status, Timestamp time) {
        this.message = message;
        this.status = status;
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
    public void setErrorMessage(String content1,String content2){
        this.content1 = content1;
        this.content2 = content2;
    }

    public String getContent1() {
        return content1;
    }

    public String getContent2() {
        return content2;
    }

}
