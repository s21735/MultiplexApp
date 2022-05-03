package com.example.toukmultiplex.Reservation.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(value = {ValidationException.class})
    public ResponseEntity<Object> handleToShortTimeToScreeningException(ValidationException ex){
    ApiException apiEx = new ApiException(
                           ex.getMessage(),
                           HttpStatus.BAD_REQUEST,
                           ZonedDateTime.now(ZoneId.of("Z"))
    );


    return new ResponseEntity<>(apiEx, HttpStatus.BAD_REQUEST);
    }
}
