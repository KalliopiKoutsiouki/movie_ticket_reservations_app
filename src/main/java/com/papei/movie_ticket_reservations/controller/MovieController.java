package com.papei.movie_ticket_reservations.controller;

import com.papei.movie_ticket_reservations.exception.UserNotFoundException;
import com.papei.movie_ticket_reservations.model.Movie;
import com.papei.movie_ticket_reservations.model.User;
import com.papei.movie_ticket_reservations.model.mapper.ModelMapper;
import com.papei.movie_ticket_reservations.model.mapper.ModelMapperFactory;
import com.papei.movie_ticket_reservations.pojo.dto.MovieDto;
import com.papei.movie_ticket_reservations.service.MovieService;
import com.papei.movie_ticket_reservations.service.UserService;
import com.papei.movie_ticket_reservations.service.fuzzy.FuzzyMovieService;
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

    @Autowired
    FuzzyMovieService fuzzyMovieService;

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
        List<MovieDto> movieDtos = chosenMovieId.map(id -> this.fuzzyMovieService.getMovieRecommendationsSorted(currentMovies, id))
                .orElseGet(() -> currentMovies.stream().map(movie -> (MovieDto) mapper.mapModel(movie)).toList());
        return movieDtos;
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
        List<MovieDto> movieDtos = chosenMovieId.map(id -> this.fuzzyMovieService.getMovieRecommendationsSorted(upcomingMovies, id))
                .orElseGet(() -> upcomingMovies.stream().map(movie -> (MovieDto) mapper.mapModel(movie)).toList());
        return movieDtos;
    }

    @GetMapping({"/forQuestionnaire"})
    public List<MovieDto> getAllMoviesForQuestionnaire() {
        List<Movie> movies = this.movieService.getAllMoviesForQuestionnaire();
        return movies.stream().map(movie -> (MovieDto) mapper.mapModel(movie)).toList();
    }
}
