package com.papei.movie_ticket_reservations.exception;

public class UnavailableReservationTimeException extends RuntimeException {

    public UnavailableReservationTimeException(String message) {
        super(message);
    }
}