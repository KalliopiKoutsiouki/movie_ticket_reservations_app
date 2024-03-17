package com.papei.movie_ticket_reservations.service.impl;

import com.papei.movie_ticket_reservations.model.Movie;
import com.papei.movie_ticket_reservations.repository.MovieRepository;
import com.papei.movie_ticket_reservations.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public String testMethod() {
        Movie movie = new Movie();
        movie.setId(50L);
        movie.setName("testMovie");
        this.movieRepository.save(movie);
        return "Movie added";
    }

}