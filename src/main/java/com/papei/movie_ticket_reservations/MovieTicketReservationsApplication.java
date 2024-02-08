package com.papei.movie_ticket_reservations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude = { SecurityAutoConfiguration.class })
@EntityScan(basePackages = "com.papei.movie_ticket_reservations")
public class MovieTicketReservationsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieTicketReservationsApplication.class, args);
    }

}
