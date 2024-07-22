package com.papei.movie_ticket_reservations.service.impl;

import com.papei.movie_ticket_reservations.model.Genre;
import com.papei.movie_ticket_reservations.model.Movie;
import com.papei.movie_ticket_reservations.model.User;
import com.papei.movie_ticket_reservations.model.mapper.ModelMapper;
import com.papei.movie_ticket_reservations.model.mapper.ModelMapperFactory;
import com.papei.movie_ticket_reservations.pojo.dto.MovieDto;
import com.papei.movie_ticket_reservations.repository.HourRepository;
import com.papei.movie_ticket_reservations.repository.MovieRepository;
import com.papei.movie_ticket_reservations.service.MovieService;
import com.papei.movie_ticket_reservations.service.fuzzy.FuzzyMovieService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private HourRepository hourRepository;

    @Autowired
    private FuzzyMovieService fuzzyMovieService;

    private final ModelMapper mapper = ModelMapperFactory.createMapper(MovieDto.class);

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getMovieById(Long movieId) {
        return movieRepository.findById(movieId).orElseThrow(EntityNotFoundException::new);
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

    @Override
    public List<Movie> getPlayingNowMovies() {
        Date currentDate = new Date();
        LocalTime currentHour = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");
        String currentHourString = currentHour.format(formatter);
        Long hourId = hourRepository.findHourIdByCurrentHour(currentHourString);
        return movieRepository.findNowMovies(currentDate, hourId);
    }

    @Override
    public List<Movie> getAllMoviesForQuestionnaire() {
        return movieRepository.findMoviesForQuestionnaire();
    }

    @Override
    public List<MovieDto> getSortedMovies(List<Movie> movies, User user, Optional<Long> chosenMovieId) {
        List<MovieDto> movieDtos;
        if (chosenMovieId.isPresent()) {
            movieDtos = this.fuzzyMovieService.getMovieRecommendationsSorted(movies, chosenMovieId.get());
            // If the user has kids, set the recommendation rate to 11 for movies with the ANIMATION genre
            if (user.getHasKids()==1) {
                movieDtos.forEach(movieDto -> {
                    if (movieDto.getGenre().contains(Genre.ANIMATION)) {
                        movieDto.setRecommendationRateForUser(11.0);
                    }
                });
            }
            // Resort the movie DTOs by recommendation rate
            movieDtos = movieDtos.stream()
                    .sorted(Comparator.comparingDouble(MovieDto::getRecommendationRateForUser).reversed())
                    .collect(Collectors.toList());
        } else {
            movieDtos = movies.stream()
                    .map(movie -> (MovieDto) mapper.mapModel(movie))
                    .toList();
        }
        return movieDtos;
    }


}