package com.papei.movie_ticket_reservations.model;

import jakarta.persistence.*;

@Entity
@Table(name = "MOVIE")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @OneToOne
    @JoinColumn(name = "HALL_ID", referencedColumnName = "id")
    private Hall hall;

    @OneToOne
    @JoinColumn(name = "DATERANGE_ID", referencedColumnName = "id")
    private DateRange dateRange;

    @OneToOne (mappedBy = "movie")
    private Reservation reservation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public DateRange getDateRange() {
        return dateRange;
    }

    public void setDateRange(DateRange dateRange) {
        this.dateRange = dateRange;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hall=" + hall +
                ", dateRange=" + dateRange +
                '}';
    }
}
