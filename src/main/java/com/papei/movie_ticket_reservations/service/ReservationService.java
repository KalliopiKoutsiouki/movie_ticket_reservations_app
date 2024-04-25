package com.papei.movie_ticket_reservations.service;

import com.papei.movie_ticket_reservations.exception.ReservationNotFoundException;
import com.papei.movie_ticket_reservations.model.Hall;
import com.papei.movie_ticket_reservations.model.Reservation;
import com.papei.movie_ticket_reservations.model.User;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public interface ReservationService {
    List<Reservation> getAllReservations();

    Optional<Reservation> getReservationById(Long reservationId) throws ReservationNotFoundException;

    Reservation addReservation(Reservation reservationInfo);

    Reservation updateReservation(Reservation reservationInfo);

    List<Reservation> getTodayReservations(Long movieId);

    void checkinReservation(Reservation reservation);
    public void deleteReservation(Long reservationId) throws ReservationNotFoundException;
}
