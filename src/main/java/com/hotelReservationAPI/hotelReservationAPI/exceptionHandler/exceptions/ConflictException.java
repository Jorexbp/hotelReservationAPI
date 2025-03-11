package com.hotelReservationAPI.hotelReservationAPI.exceptionHandler.exceptions;

public class ConflictException extends RuntimeException {
    public ConflictException(String message) {
        super(message);
    }
}
