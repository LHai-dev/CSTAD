package com.job_room.auth_service.utils.CustomException;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;

public class ForeignKeyException extends RuntimeException{
    private static final long serialVersionUID = 2223401815627927627L;
    @JsonProperty("MESSAGE")
    private String message;
    private HttpStatus status;
    public ForeignKeyException(String message,HttpStatus status) {
        super(message);
        this.message=message;
        this.status=status;
    }

    @Override
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

}
