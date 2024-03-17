package com.papei.movie_ticket_reservations.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Arrays;
import java.util.Set;

@Entity
@Table(name = "HALL")
public class Hall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CODE")
    private String code;

//    @Lob
//    private byte[] picture;
    @JsonIgnore
    @OneToOne(mappedBy = "hall")
    private Movie movie;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "HALL_HOUR",
            joinColumns = @JoinColumn(name = "HALL_ID"),
            inverseJoinColumns = @JoinColumn(name = "HOUR_ID")
    )
    private Set<Hour> hours;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

//    public byte[] getPicture() {
//        return picture;
//    }
//
//    public void setPicture(byte[] picture) {
//        this.picture = picture;
//    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Set<Hour> getHours() {
        return hours;
    }

    public void setHours(Set<Hour> hours) {
        this.hours = hours;
    }


}
