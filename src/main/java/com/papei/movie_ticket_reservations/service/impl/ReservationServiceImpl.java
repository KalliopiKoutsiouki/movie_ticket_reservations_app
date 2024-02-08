package com.papei.movie_ticket_reservations.service.impl;

import com.papei.movie_ticket_reservations.model.Reservation;
import com.papei.movie_ticket_reservations.repository.ReservationRepository;
import com.papei.movie_ticket_reservations.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }
}
