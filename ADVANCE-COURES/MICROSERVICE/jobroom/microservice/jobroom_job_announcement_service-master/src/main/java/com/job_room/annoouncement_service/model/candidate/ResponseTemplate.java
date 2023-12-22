package com.job_room.annoouncement_service.model.candidate;

import org.springframework.http.HttpStatus;

import java.sql.Timestamp;

public class ResponseTemplate {
    private String message;
    private CandidateEmployee data;
    private HttpStatus status;
    private Timestamp time;
    public ResponseTemplate(){}
    public ResponseTemplate(String message, CandidateEmployee data, HttpStatus status, Timestamp time) {
        this.message = message;
        this.data = data;
        this.status = status;
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CandidateEmployee getData() {
        return data;
    }

    public void setData(CandidateEmployee data) {
        this.data = data;
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

    @Override
    public String toString() {
        return "ResponseTemplate{" +
                "message='" + message + '\'' +
                ", data=" + data +
                ", status=" + status +
                ", timestamp=" + time +
                '}';
    }
}
