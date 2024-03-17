package com.papei.movie_ticket_reservations.service;

import com.papei.movie_ticket_reservations.model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {
    public List<Movie> getAllMovies();

    public String testMethod();
}
