package com.job_room.schedule_service.rest.message;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class ErrorMessage {
    private String message;
    private HttpStatus Status;
    private Date Time;
    public ErrorMessage(){}
    public ErrorMessage(String message, HttpStatus status, Date time) {
        this.message = message;
        Status = status;
        Time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return Status;
    }

    public void setStatus(HttpStatus status) {
        Status = status;
    }

    public Date getTime() {
        return Time;
    }

    public void setTime(Date time) {
        Time = time;
    }
}
