package com.papei.movie_ticket_reservations.exception;

public class HallHourNotFoundException extends RuntimeException {

    public HallHourNotFoundException(String message) {
        super(message);
    }
}