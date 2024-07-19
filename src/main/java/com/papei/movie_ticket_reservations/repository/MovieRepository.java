package com.papei.movie_ticket_reservations.repository;

import com.papei.movie_ticket_reservations.model.DateRange;
import com.papei.movie_ticket_reservations.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT m FROM Movie m WHERE m.dateRange.fromDate <= :currentDate AND m.dateRange.toDate >= :currentDate")
    List<Movie> findCurrentMovies(@Param("currentDate") Date currentDate);


    @Query("SELECT m FROM Movie m WHERE m.dateRange.fromDate > :currentDate")
    List<Movie> findUpcomingMovies(@Param("currentDate") Date currentDate);


    @Query("SELECT m FROM Movie m WHERE m.hall.id = :hallId")
    List<Movie> findMoviesOfHall(Long hallId);

    @Query("SELECT d FROM DateRange d JOIN d.movies m WHERE m.hall.id = :hallId")
    List<DateRange> getDateRangesPerHall(Long hallId);

    @Query("SELECT m FROM Movie m " +
            "JOIN m.dateRange dr " +
            "JOIN HallHour hh ON hh.hall.id = m.hall.id " +
            "JOIN hh.hour h ON h.id = :hourId " +
            "WHERE :currentDate BETWEEN dr.fromDate AND dr.toDate")
    List<Movie> findNowMovies(@Param("currentDate") Date currentDate,
                              @Param("hourId") Long hourId);

    @Query("SELECT m FROM Movie m WHERE m.id in (5, 9, 12)")
    List<Movie> findMoviesForQuestionnaire();
}
