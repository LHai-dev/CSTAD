package co.istad.mbanking.api.base;

import lombok.Builder;

import java.time.LocalDateTime;
@Builder
public record BaseRest <T>(Boolean status,
                           Integer code,
                           String message,
                           LocalDateTime timeStap ,
                           T data) {

}
