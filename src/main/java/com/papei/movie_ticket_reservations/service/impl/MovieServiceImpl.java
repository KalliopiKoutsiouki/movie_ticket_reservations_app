package com.papei.movie_ticket_reservations.service.impl;

import com.papei.movie_ticket_reservations.model.Movie;
import com.papei.movie_ticket_reservations.model.mapper.ModelMapper;
import com.papei.movie_ticket_reservations.model.mapper.ModelMapperFactory;
import com.papei.movie_ticket_reservations.pojo.dto.MovieDto;
import com.papei.movie_ticket_reservations.repository.HourRepository;
import com.papei.movie_ticket_reservations.repository.MovieRepository;
import com.papei.movie_ticket_reservations.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private HourRepository hourRepository;

    private final ModelMapper mapper = ModelMapperFactory.createMapper(MovieDto.class);

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

    @Override
    public List<Movie> getPlayingNowMovies() {
        Date currentDate = new Date();
        LocalTime currentHour = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");
        String currentHourString = currentHour.format(formatter);
        Long hourId = hourRepository.findHourIdByCurrentHour(currentHourString);
        return movieRepository.findNowMovies(currentDate, hourId);
    }

}