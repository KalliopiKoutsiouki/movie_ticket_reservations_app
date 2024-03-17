package com.papei.movie_ticket_reservations.service;

import com.papei.movie_ticket_reservations.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    public List<User> getAllUsers();

    User addUser(User userInfo);

    Optional<User> getUserById(Long userId);

    User updateUser(Long userId, User updatedUser);

    boolean deleteUser(Long userId);

    Optional<User> getUserByUserName(String userName);
}
