package com.job_room.schedule_service.configuration;

import com.job_room.schedule_service.rest.message.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class ConfigException {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> errorMessage(Exception ex, WebRequest request){
        ErrorMessage errorMessage=new ErrorMessage(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR,new Date());
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
