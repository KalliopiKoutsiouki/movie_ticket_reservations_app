package com.papei.movie_ticket_reservations.service;

import com.papei.movie_ticket_reservations.model.Reservation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReservationService {
    public List<Reservation> getAllReservations();
}
