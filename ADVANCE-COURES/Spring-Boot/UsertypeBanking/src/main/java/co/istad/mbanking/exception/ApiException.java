package co.istad.mbanking.exception;

import co.istad.mbanking.api.base.BaseError;
import co.istad.mbanking.api.base.BaseRest;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ApiException {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ResponseStatusException.class)
    public BaseError<?> handleServiceException(ResponseStatusException e){
        return BaseError.builder()
                .status(false)
                .code(HttpStatus.BAD_REQUEST.value()).
                timestamp(LocalDateTime.now()).
                message("something went wrong...! , please check.")
                .error(e.getReason()).build();
     }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseError<?> handleArgumentNotValidion(MethodArgumentNotValidException e){
        List<Map<String ,String>> errors=new ArrayList<>();
    for (FieldError error : e.getFieldErrors()){
        Map<String,String> errorDetails =new HashMap<>();
        errorDetails.put("name",error.getField());
        errorDetails.put("massage",error.getDefaultMessage());
        errors.add(errorDetails);
    }
        return BaseError.builder()
                .status(false)
                .code(HttpStatus.BAD_REQUEST.value()).
               timestamp(LocalDateTime.now()).
                message("Validation is Error please check detail")
                        .error(errors).build();
    }

}
