package com.papei.movie_ticket_reservations.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "DATERANGE")
public class DateRange {

    @Id
    private Long id;

    @Column(name = "FROM")
    private Date from;

    @Column(name = "TO")
    private Date to;

    @OneToOne(mappedBy = "dateRange")
    private Movie movie;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "DateRange{" +
                "id=" + id +
                ", from=" + from +
                ", to=" + to +
                ", movie=" + movie +
                '}';
    }
}
