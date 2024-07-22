package com.papei.movie_ticket_reservations.service;

import com.papei.movie_ticket_reservations.model.Movie;
import com.papei.movie_ticket_reservations.model.User;
import com.papei.movie_ticket_reservations.pojo.dto.MovieDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MovieService {
    public List<Movie> getAllMovies();

    public Movie getMovieById(Long movieId);

    public List<Movie> getCurrentMovies();

    public List<Movie> getUpcomingMovies();

    public List<Movie> getPlayingNowMovies();

    public List<Movie> getAllMoviesForQuestionnaire();

    public List<MovieDto> getSortedMovies(List<Movie> movies, User user, Optional<Long> chosenMovieId);

}
