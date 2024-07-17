package com.papei.movie_ticket_reservations.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "MOVIE")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "PICTURE_URL")
    private String pictureUrl;

    @ManyToOne
    @JoinColumn(name = "HALL_ID", referencedColumnName = "id")
    private Hall hall;

    @ManyToOne
    @JoinColumn(name = "DATERANGE_ID", referencedColumnName = "id")
    private DateRange dateRange;

    @JsonIgnore
    @OneToMany(mappedBy = "movie")
    private Set<HallHour> hallHours;


    //    @OneToOne
//    @JoinColumn(name = "DATERANGE_ID", referencedColumnName = "id")
//    private DateRange dateRange;
    @ElementCollection(targetClass = Genre.class)
    @CollectionTable(name = "MOVIE_GENRE", joinColumns = @JoinColumn(name = "MOVIE_ID"))
    @Enumerated(EnumType.STRING)
    @Column(name = "GENRE")
    private Set<Genre> genre;
    @Column(name = "POPULARITY")
    private double popularity;
    @Column(name = "AGE_RATING")
    private int ageRating;
    @Column(name = "RELEASE_YEAR")
    private int releaseYear;
    //    @OneToMany(mappedBy = "movie")
//    private List<Reservation> reservations;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
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

    public Set<HallHour> getHallHours() {
        return hallHours;
    }

    public void setHallHours(Set<HallHour> hallHours) {
        this.hallHours = hallHours;
    }

    public Set<Genre> getGenre() {
        return genre;
    }

    public void setGenre(Set<Genre> genre) {
        this.genre = genre;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public int getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(int age_rating) {
        this.ageRating = age_rating;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
}
