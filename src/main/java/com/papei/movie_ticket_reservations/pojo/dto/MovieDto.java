package com.papei.movie_ticket_reservations.pojo.dto;

import com.papei.movie_ticket_reservations.model.DateRange;
import com.papei.movie_ticket_reservations.model.Hall;

public class MovieDto {

    private Long id;
    private String name;
    private String description;
    private String picture;
    private Hall hall;
    private DateRange dateRange;

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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
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
}
