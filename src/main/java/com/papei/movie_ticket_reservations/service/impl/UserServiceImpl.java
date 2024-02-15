package com.papei.movie_ticket_reservations.service.impl;

import com.papei.movie_ticket_reservations.model.User;
import com.papei.movie_ticket_reservations.repository.UserRepository;
import com.papei.movie_ticket_reservations.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User addUser(User user)  {
        return userRepository.save(user);
    }
}
