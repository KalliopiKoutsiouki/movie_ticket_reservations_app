package com.papei.movie_ticket_reservations.repository;

import com.papei.movie_ticket_reservations.model.Hall;
import com.papei.movie_ticket_reservations.model.HallHour;
import com.papei.movie_ticket_reservations.model.Hour;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HallHourRepository extends JpaRepository<HallHour, Long> {

    @Query("SELECT hh FROM HallHour hh WHERE hh.hall.id = :hallId")
    List<HallHour> getHoursByHallId(@Param("hallId") Long id);

    @Query("SELECT hh FROM HallHour hh WHERE hh.hall.id = :hallId and hh.movie.id = :movieId")
    List<HallHour> getHoursByHallIdAndMovieId(@Param("hallId") Long hallId, @Param("movieId") Long movieId );

    HallHour getHallHoursByHallAndHour(Hall hall, Hour hour);

    @Transactional
    void deleteByHallId(Long hallId);

    @Transactional
    @Modifying
    @Query("UPDATE HallHour hc SET hc.capacity = hc.capacity - :seatsReserved WHERE hc.hall.id = :hallId AND hc.hour.id = :hourId")
    void updateCapacityFromReservation(@Param("seatsReserved") int seatsReserved, @Param("hallId") Long hallId, @Param("hourId") Long hourId);

    @Transactional
    @Modifying
    @Query("UPDATE HallHour hc SET hc.capacity = hc.capacity + :seatsReserved WHERE hc.hall.id = :hallId AND hc.hour.id = :hourId")
    void updateCapacityFromCancelation(@Param("seatsReserved") int seatsReserved, @Param("hallId") Long hallId, @Param("hourId") Long hourId);
}
