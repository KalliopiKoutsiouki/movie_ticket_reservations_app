package com.papei.movie_ticket_reservations.controller;

import com.papei.movie_ticket_reservations.exception.ReservationNotFoundException;
import com.papei.movie_ticket_reservations.model.Reservation;
import com.papei.movie_ticket_reservations.service.ReservationService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SecurityRequirement(name = "Authorization")
@RequestMapping({"/reservation"})
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping({"/all"})
    public List<Reservation> getReservations() {
        return this.reservationService.getAllReservations();
    }

    @GetMapping({"/{reservationId}"})
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long reservationId) {
        try {
            Reservation reservation = reservationService.getReservationById(reservationId).orElse(null);
            if (reservation != null) {
                return ResponseEntity.ok(reservation);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (ReservationNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/new")
    public Reservation createReservation(@RequestBody Reservation reservationInfo) {
        return reservationService.addReservation(reservationInfo);
    }

    @PutMapping("/update/{reservationId}")
    public ResponseEntity<String> updateReservation(@PathVariable Long reservationId, @RequestBody Reservation updatedReservation) {
        try {
            Reservation reservation = reservationService.updateReservation(reservationId, updatedReservation);
            return ResponseEntity.ok("Reservation updated successfully");
        } catch (ReservationNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{reservationId}")
    public ResponseEntity<String> deleteReservation(@PathVariable Long reservationId) {
        try {
            reservationService.deleteReservation(reservationId);
            return ResponseEntity.ok("Reservation deleted successfully");
        } catch (ReservationNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
