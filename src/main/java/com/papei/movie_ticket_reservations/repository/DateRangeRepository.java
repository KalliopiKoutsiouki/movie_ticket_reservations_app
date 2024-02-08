package com.papei.movie_ticket_reservations.repository;

import com.papei.movie_ticket_reservations.model.DateRange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DateRangeRepository extends JpaRepository<DateRange, Long> {
}
