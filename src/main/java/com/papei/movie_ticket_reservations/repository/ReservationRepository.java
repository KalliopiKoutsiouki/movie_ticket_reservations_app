package com.papei.movie_ticket_reservations.repository;

import com.papei.movie_ticket_reservations.model.Reservation;
import com.papei.movie_ticket_reservations.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    public List<Reservation> findBySelectedDateBetween(Date fromDate, Date toDate);

    @Query("SELECT r.user FROM Reservation r WHERE r.hour.id = :hourId " +
            "AND r.movie.id = :movieId " +
            "AND YEAR(r.selectedDate) = YEAR(:today) " +
            "AND MONTH(r.selectedDate) = MONTH(:today) " +
            "AND DAY(r.selectedDate) = DAY(:today)")
    List<User> findUsersByHourIdAndMovieIdAndSelectedDate(
            @Param("hourId") Long hourId,
            @Param("movieId") Long movieId,
            @Param("today") Date today
    );
}
