package com.papei.movie_ticket_reservations.service.impl;

import com.papei.movie_ticket_reservations.model.Movie;
import com.papei.movie_ticket_reservations.repository.HourRepository;
import com.papei.movie_ticket_reservations.repository.MovieRepository;
import com.papei.movie_ticket_reservations.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private HourRepository hourRepository;

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
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1); // Add 1 day to the current date
        Date tomorrow = calendar.getTime();
        LocalTime currentHour = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");
        String currentHourString = currentHour.format(formatter);
        Long hourId = hourRepository.findHourIdByCurrentHour(currentHourString);
        return movieRepository.findNowMovies(tomorrow, hourId);
    }




}