package com.papei.movie_ticket_reservations.controller;

import com.papei.movie_ticket_reservations.exception.HallHourNotFoundException;
import com.papei.movie_ticket_reservations.exception.UserNotFoundException;
import com.papei.movie_ticket_reservations.model.Hall;
import com.papei.movie_ticket_reservations.model.HallHour;
import com.papei.movie_ticket_reservations.model.Hour;
import com.papei.movie_ticket_reservations.model.User;
import com.papei.movie_ticket_reservations.model.mapper.ModelMapper;
import com.papei.movie_ticket_reservations.model.mapper.ModelMapperFactory;
import com.papei.movie_ticket_reservations.pojo.dto.UserDto;
import com.papei.movie_ticket_reservations.service.HallHourService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SecurityRequirement(name = "Authorization")
@RequestMapping({"/hall-hour"})
public class HallHourController {

    @Autowired
    private HallHourService hallHourService;

    @GetMapping({"/all/{hallId}"})
    public List<HallHour> getHoursByHallId(@PathVariable Long hallId) {
        return this.hallHourService.getHoursByHallId(hallId);
    }

    @PutMapping("/update/{hallHourId}")
    public ResponseEntity<String> updateHallHour(@PathVariable Long hallHourId, @RequestBody HallHour updatedHallHour) {
        try {
            HallHour hallHour = hallHourService.updateHallHour(hallHourId, updatedHallHour);
            return ResponseEntity.ok("HallHour updated successfully");
        } catch (HallHourNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
