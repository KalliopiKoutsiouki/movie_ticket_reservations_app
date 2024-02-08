package com.papei.movie_ticket_reservations.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "DATERANGE")
public class DateRange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FROM_DATE")
    private Date fromDate;

    @Column(name = "TO_DATE")
    private Date toDate;

    @OneToOne(mappedBy = "dateRange")
    private Movie movie;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
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
                ", from=" + fromDate +
                ", to=" + toDate +
                ", movie=" + movie +
                '}';
    }
}
