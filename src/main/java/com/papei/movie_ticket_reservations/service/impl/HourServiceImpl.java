package com.papei.movie_ticket_reservations.service.impl;

import com.papei.movie_ticket_reservations.model.Hour;
import com.papei.movie_ticket_reservations.repository.HourRepository;
import com.papei.movie_ticket_reservations.service.HourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HourServiceImpl implements HourService {
    @Autowired
    private HourRepository hourRepository;

    public List<Hour> getAllHours() {
        return hourRepository.findAll();
    }
}
