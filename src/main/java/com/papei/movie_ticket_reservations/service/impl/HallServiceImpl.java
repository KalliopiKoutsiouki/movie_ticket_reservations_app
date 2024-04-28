package com.papei.movie_ticket_reservations.service.impl;

import com.papei.movie_ticket_reservations.exception.HallNotFoundException;
import com.papei.movie_ticket_reservations.model.DateRange;
import com.papei.movie_ticket_reservations.model.Hall;
import com.papei.movie_ticket_reservations.model.Movie;
import com.papei.movie_ticket_reservations.model.Reservation;
import com.papei.movie_ticket_reservations.repository.*;
import com.papei.movie_ticket_reservations.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HallServiceImpl implements HallService {

    @Autowired
    private HallRepository hallRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private DateRangeRepository dateRangeRepository;

    @Autowired
    private HallHourRepository hallHourRepository;

    @Override
    public List<Hall> getAllHalls() {
        return hallRepository.findAll();
    }

    @Override
    public Hall addHall(Hall hall) {
        return hallRepository.save(hall);
    }

    @Override
    public Optional<Hall> getHallById(Long hallId) {
        return Optional.ofNullable(hallRepository.findById(hallId)
                .orElseThrow(() -> new HallNotFoundException("Hall with ID " + hallId + " not found")));
    }

    @Override
    public Hall updateHall(Long hallId, Hall updatedHall) {
        hallRepository.findById(hallId)
                .orElseThrow(() -> new HallNotFoundException("Hall with ID " + hallId + " not found"));

        return hallRepository.save(updatedHall);
    }

    public boolean deleteHall(Long hallId) {
        Hall hall = hallRepository.findById(hallId)
                .orElseThrow(() -> new HallNotFoundException("Hall with ID " + hallId + " not found"));

        List<Movie> hallMovies = movieRepository.findMoviesOfHall(hallId);

//        Set<Hour> hallHours = hall.getHours();
        for (Movie movie : hallMovies) {
            movieRepository.deleteById(movie.getId());
        }

        hallHourRepository.deleteByHallId(hall.getId());
        hallRepository.delete(hall);
        return true;
    }

    @Override
    public List<DateRange> getDateRangesPerHall(Long hallId) {
        return movieRepository.getDateRangesPerHall(hallId);
    }

    @Override
    public DateRange updateDateRangePerHall(Long hallId, DateRange updatedDateRange) {
        DateRange previousDateRange = dateRangeRepository.getReferenceById(updatedDateRange.getId());
        List<Reservation> affectedReservations = reservationRepository.findBySelectedDateBetween(previousDateRange.getFromDate(), previousDateRange.getToDate());

        if (!affectedReservations.isEmpty()) {
            for (Reservation reservation : affectedReservations) {
                reservationRepository.delete(reservation);
            }
        }

        dateRangeRepository.save(updatedDateRange);
        return null;
    }
}