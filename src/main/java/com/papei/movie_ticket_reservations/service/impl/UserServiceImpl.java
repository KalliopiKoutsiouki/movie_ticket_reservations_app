package com.papei.movie_ticket_reservations.service.impl;

import com.papei.movie_ticket_reservations.exception.UserNotFoundException;
import com.papei.movie_ticket_reservations.model.User;
import com.papei.movie_ticket_reservations.repository.UserRepository;
import com.papei.movie_ticket_reservations.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public User addUser(User userInfo) {
        userInfo.setPassword(encoder.encode(userInfo.getPassword()));
        return repository.save(userInfo);
    }

    @Override
    public Optional<User> getUserById(Long userId) throws UserNotFoundException {
        return Optional.ofNullable(repository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User with ID " + userId + " not found")));
    }

    @Override
    public User updateUser(Long userId, User updatedUser) throws UserNotFoundException {
        User existingUser = repository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User with ID " + userId + " not found"));

        existingUser.setFirstName(updatedUser.getFirstName());
        existingUser.setLastName(updatedUser.getLastName());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setMobilePhone(updatedUser.getMobilePhone());
        existingUser.setUserName(updatedUser.getUserName());
//        if (updatedUser.getPassword() != null) {
//            existingUser.setPassword(encoder.encode(updatedUser.getPassword()));
//        }
        existingUser.setUserRoles(updatedUser.getUserRoles());
        existingUser.setMovies(updatedUser.getMovies());
        existingUser.setReservations(updatedUser.getReservations());
        existingUser.setChosenMovie(updatedUser.getChosenMovie());
        existingUser.setHasKids(updatedUser.getHasKids());


        return repository.save(existingUser);
    }

    @Override
    public boolean deleteUser(Long userId) throws UserNotFoundException {
        Optional<User> user = repository.findById(userId);
        if (user.isPresent()) {
            repository.deleteById(userId);
            return true;
        } else {
            throw new UserNotFoundException("User with ID " + userId + " not found");
        }
    }

    @Override
    public Optional<User> getUserByUserName(String userName) throws UserNotFoundException {
        return Optional.ofNullable(repository.findByUserName(userName)
                .orElseThrow(() -> new UserNotFoundException("User with userName " + userName + " not found")));
    }
}
