package com.example.spring4mbankingapisasu.exception;

import com.example.spring4mbankingapisasu.base.BaseError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class ApiException {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseError<?> handleValidationException(MethodArgumentNotValidException e){
        List<Map<String , String> > errors = new ArrayList<>();
        for (FieldError fieldError: e.getFieldErrors()) {
            Map<String , String> error = new HashMap<>();
            error.put("field" , fieldError.getField());
            error.put("Detail" , fieldError.getDefaultMessage());
            errors.add(error);
        }
        return BaseError.builder()
                .status(false)
                .code(HttpStatus.BAD_REQUEST.value())
                .message("SomeThing went wrong , please check in error detail!")
                .timestamp(LocalDateTime.now())
                .error(errors)
                .build();
    }


    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ResponseStatusException.class)
    public BaseError<?> handleServiceException(ResponseStatusException e) {
        return BaseError.builder()
                .status(false)
                .code(e.getStatusCode().value())
                .message("Something went wrong, please check in error detail!")
                .timestamp(LocalDateTime.now())
                .error(e.getReason())
                .build();
    }
}
