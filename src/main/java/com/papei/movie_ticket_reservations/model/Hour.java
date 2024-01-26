package com.papei.movie_ticket_reservations.model;

import jakarta.persistence.*;

@Entity
@Table(name = "HOUR")
public class Hour {

    @Id
    private Long id;

    @Column( name = "FROM")
    private String from;

    @Column(name = "TO")
    private String to;

    @OneToOne(mappedBy = "hour")
    private Reservation reservation;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
