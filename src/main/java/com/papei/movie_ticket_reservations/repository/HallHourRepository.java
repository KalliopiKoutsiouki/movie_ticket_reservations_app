package com.papei.movie_ticket_reservations.repository;

import com.papei.movie_ticket_reservations.model.Hall;
import com.papei.movie_ticket_reservations.model.HallHour;
import com.papei.movie_ticket_reservations.model.Hour;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HallHourRepository extends JpaRepository<HallHour, Long> {

    @Query("SELECT hh.hour FROM HallHour hh WHERE hh.hall.id = :hallId")
    List<Hour> getHoursByHallId(@Param("hallId") Long id);

    @Transactional
    void deleteByHallId(Long hallId);
}
