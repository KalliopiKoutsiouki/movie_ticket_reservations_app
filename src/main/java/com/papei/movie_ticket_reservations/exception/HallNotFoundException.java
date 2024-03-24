package com.papei.movie_ticket_reservations.exception;

public class HallNotFoundException extends RuntimeException {

    public HallNotFoundException(String message) {
        super(message);
    }
}