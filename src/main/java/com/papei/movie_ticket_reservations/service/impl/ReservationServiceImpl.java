package com.papei.movie_ticket_reservations.service.impl;

import com.papei.movie_ticket_reservations.exception.ReservationNotFoundException;
import com.papei.movie_ticket_reservations.exception.UnavailableReservationTimeException;
import com.papei.movie_ticket_reservations.model.Reservation;
import com.papei.movie_ticket_reservations.repository.ReservationRepository;
import com.papei.movie_ticket_reservations.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Optional<Reservation> getReservationById(Long reservationId) {
        return Optional.ofNullable(reservationRepository.findById(reservationId)
                .orElseThrow(() -> new ReservationNotFoundException("Reservation with ID " + reservationId + " not found")));
    }

    @Override
    public Reservation addReservation(Reservation reservationInfo) {
        return reservationRepository.save(reservationInfo);
    }

    @Override
    public Reservation updateReservation(Long reservationId, Reservation updatedReservation) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new ReservationNotFoundException("Reservation with ID " + reservationId + " not found"));

        // Check if the new reservation time is available
        if (!isReservationTimeAvailable(updatedReservation)) {
            throw new UnavailableReservationTimeException("The new reservation time is not available");
        }

        // Update reservation fields
        reservation.setUser(updatedReservation.getUser());
        reservation.setMovie(updatedReservation.getMovie());
        reservation.setTimestamp(updatedReservation.getTimestamp());
        reservation.setEmailSent(updatedReservation.isEmailSent());
        reservation.setHour(updatedReservation.getHour());

        return reservationRepository.save(reservation);
    }

    @Override
    public void deleteReservation(Long reservationId) {
        if (!reservationRepository.existsById(reservationId)) {
            throw new ReservationNotFoundException("Reservation with ID " + reservationId + " not found");
        }
        reservationRepository.deleteById(reservationId);
    }

    public boolean isReservationTimeAvailable(Reservation updatedReservation) {
       //Implement this
        return true;
    }
}
