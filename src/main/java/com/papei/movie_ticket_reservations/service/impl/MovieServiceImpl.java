package com.papei.movie_ticket_reservations.service.impl;

import com.papei.movie_ticket_reservations.model.Movie;
import com.papei.movie_ticket_reservations.repository.MovieRepository;
import com.papei.movie_ticket_reservations.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public List<Movie> getCurrentMovies() {
        Date currentDate = new Date();
        return movieRepository.findCurrentMovies(currentDate);
    }

    @Override
    public List<Movie> getUpcomingMovies() {
        Date currentDate = new Date();
        return movieRepository.findUpcomingMovies(currentDate);
    }


}