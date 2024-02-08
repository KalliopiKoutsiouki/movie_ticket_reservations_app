package com.papei.movie_ticket_reservations.model;

import jakarta.persistence.*;

@Entity
@Table(name = "`HOUR`")
public class Hour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FROM_HOUR")
    private String fromHour;

    @Column(name = "TO_HOUR")
    private String toHour;

    @OneToOne(mappedBy = "hour")
    private Reservation reservation;

    // Default (no-argument) constructor
    public Hour() {
        // Default constructor is needed for JPA
    }

    // Constructor with essential fields
    public Hour(String fromHour, String toHour) {
        this.fromHour = fromHour;
        this.toHour = toHour;
    }

    // Full constructor with all fields
    public Hour(Long id, String fromHour, String toHour, Reservation reservation) {
        this.id = id;
        this.fromHour = fromHour;
        this.toHour = toHour;
        this.reservation = reservation;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getFromHour() {
        return fromHour;
    }

    public void setFromHour(String fromHour) {
        this.fromHour = fromHour;
    }

    public String getToHour() {
        return toHour;
    }

    public void setToHour(String toHour) {
        this.toHour = toHour;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
