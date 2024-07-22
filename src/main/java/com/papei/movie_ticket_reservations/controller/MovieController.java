package com.papei.movie_ticket_reservations.controller;

import com.papei.movie_ticket_reservations.exception.UserNotFoundException;
import com.papei.movie_ticket_reservations.model.Movie;
import com.papei.movie_ticket_reservations.model.User;
import com.papei.movie_ticket_reservations.model.mapper.ModelMapper;
import com.papei.movie_ticket_reservations.model.mapper.ModelMapperFactory;
import com.papei.movie_ticket_reservations.pojo.dto.MovieDto;
import com.papei.movie_ticket_reservations.service.MovieService;
import com.papei.movie_ticket_reservations.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@SecurityRequirement(name = "Authorization")
@RequestMapping({"/movies"})
public class MovieController {

    @Autowired
    MovieService movieService;

    @Autowired
    UserService userService;

    private final ModelMapper mapper = ModelMapperFactory.createMapper(MovieDto.class);

    @GetMapping({"/all"})
    public List<MovieDto> getAllMovies() {
        List<Movie> movies = this.movieService.getAllMovies();
        return movies.stream().map(movie -> (MovieDto) mapper.mapModel(movie)).toList();
    }

    @GetMapping("/{movieId}")
    public MovieDto getMovieById(@PathVariable Long movieId) {
        Movie movie = movieService.getMovieById(movieId);
        return (MovieDto) mapper.mapModel(movie);
    }

    @GetMapping({"/currentMovies/{userId}"})
    public List<MovieDto> getCurrentMovies(@PathVariable Long userId) throws UserNotFoundException {
        User user = userService.getUserById(userId).get();
        Optional<Long> chosenMovieId = Optional.ofNullable(user.getChosenMovie()).map(Movie::getId);
        List<Movie> currentMovies = this.movieService.getCurrentMovies();
        return this.movieService.getSortedMovies(currentMovies, user, chosenMovieId);
    }

    @GetMapping({"/playing-now"})
    public List<MovieDto> getPlayingNowMovies() {
        List<Movie> nowMovies = this.movieService.getPlayingNowMovies();
        return nowMovies.stream().map(movie -> (MovieDto) mapper.mapModel(movie)).toList();
    }

    @GetMapping({"/upcomingMovies/{userId}"})
    public List<MovieDto> getUpcomingMovies(@PathVariable Long userId) throws UserNotFoundException {
        User user = userService.getUserById(userId).get();
        Optional<Long> chosenMovieId = Optional.ofNullable(user.getChosenMovie()).map(Movie::getId);
        List<Movie> upcomingMovies = this.movieService.getUpcomingMovies();
        return this.movieService.getSortedMovies(upcomingMovies, user, chosenMovieId);
    }

    @GetMapping({"/forQuestionnaire"})
    public List<MovieDto> getAllMoviesForQuestionnaire() {
        List<Movie> movies = this.movieService.getAllMoviesForQuestionnaire();
        return movies.stream().map(movie -> (MovieDto) mapper.mapModel(movie)).toList();
    }
}
