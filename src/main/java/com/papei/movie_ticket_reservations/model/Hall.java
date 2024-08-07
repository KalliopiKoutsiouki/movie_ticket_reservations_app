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

    @Column(name = "NAME")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "hall")
    private Set<Movie> movies;

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

    public String getName() {
        return name;
    }

    public void setName(String code) {
        this.name = code;
    }

//    public Movie getMovie() {
//        return movie;
//    }
//
//    public void setMovie(Movie movie) {
//        this.movie = movie;
//    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    public Set<Hour> getHours() {
        return hours;
    }

    public void setHours(Set<Hour> hours) {
        this.hours = hours;
    }


}
