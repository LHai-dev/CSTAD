package com.job_room.schedule_service.rest.message;

import org.springframework.http.HttpStatus;

import java.sql.Timestamp;

public class BaseApiResponseWithPagination <T>{
    private String message;
    private T data;
    private Pagination pagination;
    private HttpStatus status;
    private Timestamp time;

    public BaseApiResponseWithPagination() {
    }

    public BaseApiResponseWithPagination(Pagination pagination, String message, T data, HttpStatus status, Timestamp time) {
        this.pagination = pagination;
        this.message = message;
        this.data = data;
        this.status = status;
        this.time = time;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
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
        return "BaseApiResponseWithPagination{" +
                "pagination=" + pagination +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", status=" + status +
                ", time=" + time +
                '}';
    }

}
