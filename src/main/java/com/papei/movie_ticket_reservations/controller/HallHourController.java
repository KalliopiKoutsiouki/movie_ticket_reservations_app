package com.papei.movie_ticket_reservations.controller;

import com.papei.movie_ticket_reservations.model.Hour;
import com.papei.movie_ticket_reservations.service.HallHourService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SecurityRequirement(name = "Authorization")
@RequestMapping({"/hall-hour"})
public class HallHourController {

    @Autowired
    private HallHourService hallHourService;

    @GetMapping({"/all/{hallId}"})
    public List<Hour> getHoursByHallId(@PathVariable Long hallId) {
        return this.hallHourService.getHoursByHallId(hallId);
    }


}
