package com.papei.movie_ticket_reservations.service.impl;

import com.papei.movie_ticket_reservations.model.HallHour;
import com.papei.movie_ticket_reservations.model.Hour;
import com.papei.movie_ticket_reservations.repository.HallHourRepository;
import com.papei.movie_ticket_reservations.service.HallHourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HallHourServiceImpl implements HallHourService {

    @Autowired
    HallHourRepository hallHourRepository;

    @Override
    public List<HallHour> getHoursByHallId(Long id) {
        return this.hallHourRepository.getHoursByHallId(id);
    }
}
