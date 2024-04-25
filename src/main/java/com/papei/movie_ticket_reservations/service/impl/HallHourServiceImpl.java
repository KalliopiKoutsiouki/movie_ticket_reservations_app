package com.papei.movie_ticket_reservations.service.impl;

import com.papei.movie_ticket_reservations.exception.HallHourNotFoundException;
import com.papei.movie_ticket_reservations.exception.UserNotFoundException;
import com.papei.movie_ticket_reservations.model.HallHour;
import com.papei.movie_ticket_reservations.model.Hour;
import com.papei.movie_ticket_reservations.model.User;
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

    @Override
    public HallHour updateHallHour(Long hallHourId, HallHour updatedHallHour) {
        HallHour existingHallHour = hallHourRepository.findById(hallHourId)
                .orElseThrow(() -> new HallHourNotFoundException("HallHour with ID " + hallHourId + " not found"));

        existingHallHour.setHall(updatedHallHour.getHall());
        existingHallHour.setHour(updatedHallHour.getHour());
        existingHallHour.setCapacity(updatedHallHour.getCapacity());

        return hallHourRepository.save(existingHallHour);
    }
}
