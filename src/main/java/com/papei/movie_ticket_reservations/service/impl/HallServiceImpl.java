package com.papei.movie_ticket_reservations.service.impl;

import com.papei.movie_ticket_reservations.exception.HallNotFoundException;
import com.papei.movie_ticket_reservations.model.Hall;
import com.papei.movie_ticket_reservations.model.Movie;
import com.papei.movie_ticket_reservations.repository.HallHourRepository;
import com.papei.movie_ticket_reservations.repository.HallRepository;
import com.papei.movie_ticket_reservations.repository.MovieRepository;
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
        Hall existingHall = hallRepository.findById(hallId)
                .orElseThrow(() -> new HallNotFoundException("Hall with ID " + hallId + " not found"));

        existingHall.setName(updatedHall.getName());
//        existingHall.setPicture(updatedHall.getPicture());
        existingHall.setMovie(updatedHall.getMovie());
        existingHall.setHours(updatedHall.getHours());

        return hallRepository.save(existingHall);
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
}