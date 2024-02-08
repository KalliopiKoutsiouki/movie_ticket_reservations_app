package com.papei.movie_ticket_reservations.service;

import com.papei.movie_ticket_reservations.model.Hall;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HallService {
    public List<Hall> getAllHalls();
}
