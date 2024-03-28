package com.papei.movie_ticket_reservations.repository;

import com.papei.movie_ticket_reservations.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT m FROM Movie m WHERE m.dateRange.fromDate <= :currentDate AND m.dateRange.toDate >= :currentDate")
    List<Movie> findCurrentMovies(@Param("currentDate") Date currentDate);


    @Query("SELECT m FROM Movie m WHERE m.dateRange.fromDate > :currentDate")
    List<Movie> findUpcomingMovies(@Param("currentDate") Date currentDate);
}
