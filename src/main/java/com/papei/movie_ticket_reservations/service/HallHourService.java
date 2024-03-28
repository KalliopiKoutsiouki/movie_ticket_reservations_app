package com.papei.movie_ticket_reservations.service;

import com.papei.movie_ticket_reservations.model.Hour;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HallHourService {

    List<Hour> getHoursByHallId(Long id);
}
