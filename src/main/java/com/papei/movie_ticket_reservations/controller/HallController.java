package com.papei.movie_ticket_reservations.controller;

import com.papei.movie_ticket_reservations.exception.HallNotFoundException;
import com.papei.movie_ticket_reservations.model.DateRange;
import com.papei.movie_ticket_reservations.model.Hall;
import com.papei.movie_ticket_reservations.model.Movie;
import com.papei.movie_ticket_reservations.pojo.dto.MovieDto;
import com.papei.movie_ticket_reservations.service.HallService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SecurityRequirement(name = "Authorization")
@RequestMapping({"/hall"})
public class HallController {

    @Autowired
    private HallService hallService;

    @GetMapping({"/all"})
    public List<Hall> getHalls() {
        return this.hallService.getAllHalls();
    }

    @GetMapping({"/{hallId}"})
    public ResponseEntity<Hall> getHallById(@PathVariable Long hallId) {
        try {
            Hall hall = hallService.getHallById(hallId).orElse(null);
            if (hall != null) {
                return ResponseEntity.ok(hall);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (HallNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/new")
    public Hall createHall(@RequestBody Hall hallInfo) {
        return hallService.addHall(hallInfo);
    }

    @PutMapping("/update/{hallId}")
    public ResponseEntity<String> updateHall(@PathVariable Long hallId, @RequestBody Hall updatedHall) {
        try {
            Hall hall = hallService.updateHall(hallId, updatedHall);
            return ResponseEntity.ok("Hall updated successfully");
        } catch (HallNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{hallId}")
    public ResponseEntity<String> deleteHall(@PathVariable Long hallId) {
        try {
            hallService.deleteHall(hallId);
            return ResponseEntity.ok("Hall deleted successfully");
        } catch (HallNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping({"/dateRanges/{hallId}"})
    public List<DateRange> getDateRangesPerHall(@PathVariable Long hallId) {
        List<DateRange> dateRanges = this.hallService.getDateRangesPerHall(hallId);
        return dateRanges;
    }

}
