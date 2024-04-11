package com.papei.movie_ticket_reservations.service.impl;

import com.papei.movie_ticket_reservations.exception.ReservationNotFoundException;
import com.papei.movie_ticket_reservations.exception.UnavailableReservationTimeException;
import com.papei.movie_ticket_reservations.model.HallHour;
import com.papei.movie_ticket_reservations.model.Hour;
import com.papei.movie_ticket_reservations.model.Reservation;
import com.papei.movie_ticket_reservations.model.User;
import com.papei.movie_ticket_reservations.repository.HallHourRepository;
import com.papei.movie_ticket_reservations.repository.HourRepository;
import com.papei.movie_ticket_reservations.repository.ReservationRepository;
import com.papei.movie_ticket_reservations.repository.UserRepository;
import com.papei.movie_ticket_reservations.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private HourRepository hourRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HallHourRepository hallHourRepository;

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
        updateHoursListOfReservations(reservationInfo);
        updateUserListOfReservationsAndMovie(reservationInfo);
        updateHallCapacity(reservationInfo, false);
        return reservationRepository.save(reservationInfo);
    }

    @Override
    public Reservation updateReservation(Reservation reservationInfo) {
        checkAndRevertHallCapacity(reservationInfo);
        updateHoursListOfReservations(reservationInfo);
        updateUserListOfReservationsAndMovie(reservationInfo);
        updateHallCapacity(reservationInfo, false);
        return reservationRepository.save(reservationInfo);
    }

    private void checkAndRevertHallCapacity(Reservation reservationInfo) {
        Optional<Reservation> oldReservation = reservationRepository.findById(reservationInfo.getId());
        if (oldReservation.isPresent() && oldReservation.get().getHour().getId() != reservationInfo.getHour().getId()) {
            HallHour hallHourRecord = hallHourRepository.getHallHoursByHallAndHour(oldReservation.get().getMovie().getHall(), oldReservation.get().getHour());
            hallHourRecord.setCapacity(hallHourRecord.getCapacity() + oldReservation.get().getNumberOfSeats());
            hallHourRepository.save(hallHourRecord);
        }
    }


    private void updateHallCapacity(Reservation reservationInfo, boolean isCancelation) {
        long hallId = reservationInfo.getMovie().getHall().getId();
        if (isCancelation) {
            this.hallHourRepository.updateCapacityFromCancelation(reservationInfo.getNumberOfSeats(), hallId, reservationInfo.getHour().getId());
        } else {
            this.hallHourRepository.updateCapacityFromReservation(reservationInfo.getNumberOfSeats(), hallId, reservationInfo.getHour().getId());
        }
    }


    private void updateHoursListOfReservations(Reservation reservationInfo) {
        Hour hour = hourRepository.findById(reservationInfo.getHour().getId())
                .orElseThrow(() -> new RuntimeException("Hour not found"));
        hour.getReservations().add(reservationInfo);
        hourRepository.save(hour);
    }

    private void updateUserListOfReservationsAndMovie(Reservation reservationInfo) {
        User user = userRepository.findById(reservationInfo.getUser().getId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.getReservations().add(reservationInfo);
        user.getMovies().add(reservationInfo.getMovie());
        userRepository.save(user);
    }

//    @Override
//    public Reservation updateReservation(Long reservationId, Reservation updatedReservation) {
//        Reservation reservation = reservationRepository.findById(reservationId)
//                .orElseThrow(() -> new ReservationNotFoundException("Reservation with ID " + reservationId + " not found"));
//
//        // Check if the new reservation time is available
//        if (!isReservationTimeAvailable(updatedReservation)) {
//            throw new UnavailableReservationTimeException("The new reservation time is not available");
//        }
//
//        // Update reservation fields
//        reservation.setUser(updatedReservation.getUser());
//        reservation.setMovie(updatedReservation.getMovie());
//        reservation.setTimestamp(updatedReservation.getTimestamp());
//        reservation.setEmailSent(updatedReservation.isEmailSent());
//        reservation.setHour(updatedReservation.getHour());
//
//        return reservationRepository.save(reservation);
//    }

    @Override
    public void deleteReservation(Long reservationId) {
        Optional<Reservation> reservation = reservationRepository.findById(reservationId);
        if (!reservation.isPresent()) {
            throw new ReservationNotFoundException("Reservation with ID " + reservationId + " not found");
        }
        deleteMovieAndReservationFromUser(reservation.get());
        updateHallCapacity(reservation.get(), true);
       reservationRepository.deleteById(reservationId);
    }

    private void deleteMovieAndReservationFromUser(Reservation reservation) {
           User user = userRepository.findById(reservation.getUser().getId())
                   .orElseThrow(() -> new RuntimeException("User not found"));
           user.getMovies().remove(reservation.getMovie());
           user.getReservations().remove(reservation);
           userRepository.save(user);

    }

    public boolean isReservationTimeAvailable(Reservation updatedReservation) {
       //Implement this
        return true;
    }
}
