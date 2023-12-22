package com.testSSE.SSE.exception;

import org.springframework.http.HttpStatus;

public class ResponseDTO {
    private String message;
    private HttpStatus status;
    private ErrorCode errorCode;

    public ResponseDTO(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    public ResponseDTO(String message, HttpStatus status, ErrorCode errorCode) {
        this.message = message;
        this.status = status;
        this.errorCode = errorCode;
    }
}
