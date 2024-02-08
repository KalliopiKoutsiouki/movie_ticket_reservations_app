package com.papei.movie_ticket_reservations.service;

import com.papei.movie_ticket_reservations.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public List<User> getAllUsers();
}
