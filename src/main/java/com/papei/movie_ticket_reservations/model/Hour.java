package com.papei.movie_ticket_reservations.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "HOURS")
public class Hour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FROM_HOUR")
    private String fromHour;

    @Column(name = "TO_HOUR")
    private String toHour;

    @ManyToMany(mappedBy = "hours")
    @JsonIgnore
    private List<Hall> halls;


    @OneToMany(mappedBy = "hour")
    @JsonIgnore
    private List<Reservation> reservations;


    // Default (no-argument) constructor
    public Hour() {
        // Default constructor is needed for JPA
    }

    // Constructor with essential fields
    public Hour(String fromHour, String toHour) {
        this.fromHour = fromHour;
        this.toHour = toHour;
    }

    public List<Hall> getHalls() {
        return halls;
    }

    public void setHalls(List<Hall> halls) {
        this.halls = halls;
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

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }


}
