package com.papei.movie_ticket_reservations.controller;

import com.papei.movie_ticket_reservations.model.Hour;
import com.papei.movie_ticket_reservations.service.HourService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SecurityRequirement(name = "Authorization")
@RequestMapping({"/hour"})
public class HourController {

    @Autowired
    private HourService hourService;

    @GetMapping({"/all"})
    public List<Hour> getHours() {
        return this.hourService.getAllHours();
    }



}
