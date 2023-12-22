package com.job_room.schedule_service.rest.message;

import org.springframework.http.HttpStatus;

import java.sql.Timestamp;
import java.util.List;

public class ErrorResponse {

    private String message;
    private List<Object> error;
    private HttpStatus status;
    private Timestamp time;

    public ErrorResponse() {

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Object> getError() {
        return error;
    }

    public void setError(List<Object> error) {
        this.error = error;
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
        return "ErrorResponse{" +
                "message='" + message + '\'' +
                ", error=" + error +
                ", status=" + status +
                ", time=" + time +
                '}';
    }

}
