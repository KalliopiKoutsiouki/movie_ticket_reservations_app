package com.papei.movie_ticket_reservations.service;

import com.papei.movie_ticket_reservations.model.HallHour;
import com.papei.movie_ticket_reservations.model.Hour;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HallHourService {

    List<HallHour> getHoursByHallId(Long id);

    HallHour updateHallHour(Long hallHourId, HallHour updatedHallHour);
}
