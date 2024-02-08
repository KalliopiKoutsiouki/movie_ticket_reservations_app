package com.papei.movie_ticket_reservations.service.impl;

import com.papei.movie_ticket_reservations.model.Hall;
import com.papei.movie_ticket_reservations.repository.HallRepository;
import com.papei.movie_ticket_reservations.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HallServiceImpl implements HallService {
    @Autowired
    private HallRepository hallRepository;

    public List<Hall> getAllHalls() {
        return hallRepository.findAll();
    }
}
