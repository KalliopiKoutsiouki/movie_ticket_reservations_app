package com.papei.movie_ticket_reservations.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table (name = "RESERVATION")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TIMESTAMP")
    private Timestamp timestamp;

    @Column(name = "EMAIL_SENT")
    private boolean email_sent;

    @Column(name = "SELECTED_DATE")
    private String selectedDate;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @Column(name = "NUM_SEATS")
    private int numberOfSeats;

    @OneToOne
    @JoinColumn (name = "MOVIE_ID" , referencedColumnName = "id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "HOUR_ID")
    private Hour hour;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isEmailSent() {
        return email_sent;
    }

    public void setEmailSent(boolean email_sent) {
        this.email_sent = email_sent;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSelectedDate() {
        return selectedDate;
    }

    public void setSelectedDate(String selectedDate) {
        this.selectedDate = selectedDate;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Hour getHour() {
        return hour;
    }

    public void setHour(Hour hour) {
        this.hour = hour;
    }

    public boolean isEmail_sent() {
        return email_sent;
    }

    public void setEmail_sent(boolean email_sent) {
        this.email_sent = email_sent;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }


}
