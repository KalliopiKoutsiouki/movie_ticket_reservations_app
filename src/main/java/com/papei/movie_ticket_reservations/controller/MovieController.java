package com.papei.movie_ticket_reservations.controller;

import com.papei.movie_ticket_reservations.model.DateRange;
import com.papei.movie_ticket_reservations.model.Movie;
import com.papei.movie_ticket_reservations.model.User;
import com.papei.movie_ticket_reservations.model.mapper.ModelMapper;
import com.papei.movie_ticket_reservations.model.mapper.ModelMapperFactory;
import com.papei.movie_ticket_reservations.model.mapper.impl.MovieDtoMapper;
import com.papei.movie_ticket_reservations.pojo.dto.MovieDto;
import com.papei.movie_ticket_reservations.service.MovieService;
import com.papei.movie_ticket_reservations.service.impl.MovieServiceImpl;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@SecurityRequirement(name = "Authorization")
@RequestMapping({"/movies"})
public class MovieController {

    @Autowired
    MovieService movieService;

    private ModelMapper mapper = ModelMapperFactory.createMapper(MovieDto.class);



    @GetMapping({"/all"})
    public List<MovieDto> getAllMovies() {
        List<Movie> movies = this.movieService.getAllMovies();
        List<MovieDto> movieDtosList = movies.stream().map(movie -> (MovieDto) mapper.mapModel(movie)).toList();
        return movieDtosList;
    }

    @GetMapping({"/currentMovies"})
    public List<MovieDto> getCurrentMovies() {
        List<Movie> currentMovies = this.movieService.getCurrentMovies();
        List<MovieDto> currentMovieDtosList = currentMovies.stream().map(movie -> (MovieDto) mapper.mapModel(movie)).toList();
        return currentMovieDtosList;
    }

    @GetMapping({"/playing-now"})
    public List<MovieDto> getPlayingNowMovies() {
        List<Movie> nowMovies = this.movieService.getPlayingNowMovies();
        List<MovieDto> nowMoviesDto = nowMovies.stream().map(movie -> (MovieDto) mapper.mapModel(movie)).toList();
        return nowMoviesDto;
    }


    @GetMapping({"/upcomingMovies"})
    public List<MovieDto> getUpcomingMovies() {
        List<Movie> upcomingMovies = this.movieService.getUpcomingMovies();
        List<MovieDto> upcomingMoviesDtoList = upcomingMovies.stream().map(movie -> (MovieDto) mapper.mapModel(movie)).toList();
        System.out.println(upcomingMoviesDtoList);
        return upcomingMoviesDtoList;
    }
}
