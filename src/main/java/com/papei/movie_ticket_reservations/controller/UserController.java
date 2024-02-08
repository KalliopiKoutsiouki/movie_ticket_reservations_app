package com.papei.movie_ticket_reservations.controller;

import com.papei.movie_ticket_reservations.model.User;
import com.papei.movie_ticket_reservations.service.UserService;
import com.papei.movie_ticket_reservations.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/"})
public class UserController {
    @Autowired
    private UserService userService = new UserServiceImpl();

    public UserController() {
    }

    @CrossOrigin(
            origins = {"http://localhost:4200"}
    )

    @GetMapping({"/users"})
    public ResponseEntity<List<User>> getUsers() {
        List<User> ratings = this.userService.getAllUsers();
        return new ResponseEntity<>(ratings, HttpStatus.OK);
    }

}
