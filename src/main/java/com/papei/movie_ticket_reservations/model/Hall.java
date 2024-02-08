package com.papei.movie_ticket_reservations.model;

import jakarta.persistence.*;

import java.util.Arrays;

@Entity
@Table(name = "HALL")
public class Hall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CODE")
    private String code;

    @Lob
    private byte[] picture;

    @OneToOne(mappedBy = "hall")
    private Movie movie;

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

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "Hall{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", picture=" + Arrays.toString(picture) +
                ", movie=" + movie +
                '}';
    }
}
