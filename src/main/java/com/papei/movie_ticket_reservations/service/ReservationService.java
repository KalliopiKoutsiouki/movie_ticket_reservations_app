package com.papei.movie_ticket_reservations.service;

import com.papei.movie_ticket_reservations.model.Hall;
import com.papei.movie_ticket_reservations.model.Reservation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ReservationService {
    List<Reservation> getAllReservations();

    Optional<Reservation> getReservationById(Long reservationId);

    Reservation addReservation(Reservation reservationInfo);

    Reservation updateReservation(Reservation reservationInfo);

//    Reservation updateReservation(Long reservationId, Reservation updatedReservation);

    public void deleteReservation(Long reservationId);
}
