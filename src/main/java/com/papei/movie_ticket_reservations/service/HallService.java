package com.papei.movie_ticket_reservations.service;

import com.papei.movie_ticket_reservations.model.DateRange;
import com.papei.movie_ticket_reservations.model.Hall;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface HallService {
    public List<Hall> getAllHalls();

    public Hall addHall(Hall hall);

    public Optional<Hall> getHallById(Long hallId);

    public Hall updateHall(Long hallId, Hall updatedHall);

    public boolean deleteHall(Long hallId);

    public List<DateRange> getDateRangesPerHall(Long hallId);
}
