package com.hotelReservationAPI.hotelReservationAPI.exceptionHandler;

import com.hotelReservationAPI.hotelReservationAPI.exceptionHandler.exceptions.ConflictException;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleRuntimeException(RuntimeException runtimeException){
        return new ResponseEntity<>(
                new ErrorDetails(runtimeException.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<?> handleConflictException(ConflictException conflictException){
        return new ResponseEntity<>(
                new ErrorDetails(conflictException.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> handleBadRequestException(BadRequestException badRequestException){
        return new ResponseEntity<>(
                new ErrorDetails(badRequestException.getMessage()), HttpStatus.NOT_FOUND);
    }
}
