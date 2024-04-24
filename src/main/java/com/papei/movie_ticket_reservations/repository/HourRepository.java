package com.papei.movie_ticket_reservations.repository;

import com.papei.movie_ticket_reservations.model.Hour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HourRepository extends JpaRepository<Hour, Long> {

    @Query("SELECT h.id FROM Hour h " +
            "WHERE h.fromHour <= :currentHour AND h.toHour >= :currentHour")
    Long findHourIdByCurrentHour(@Param("currentHour") String currentHour);
}

