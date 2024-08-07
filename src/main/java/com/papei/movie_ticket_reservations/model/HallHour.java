package com.papei.movie_ticket_reservations.model;

import jakarta.persistence.*;

@Entity
@Table(name = "HALL_HOUR")
public class HallHour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "HALL_ID")
    private Hall hall;

    @ManyToOne
    @JoinColumn(name = "HOUR_ID")
    private Hour hour;

    @ManyToOne
    @JoinColumn(name = "MOVIE_ID", referencedColumnName = "id")
    private Movie movie;
    @Column(name = "CAPACITY")
    private int capacity;

    public HallHour(Long id, Hall hall, Hour hour, int capacity) {
        this.id = id;
        this.hall = hall;
        this.hour = hour;
        this.capacity = capacity;
    }

    public HallHour() {

    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public Hour getHour() {
        return hour;
    }

    public void setHour(Hour hour) {
        this.hour = hour;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
