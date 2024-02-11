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
@RequestMapping({"/api/users"})
public class UserController {
    @Autowired
    private UserService userService = new UserServiceImpl();

    @CrossOrigin(
            origins = {"http://localhost:4200"}
    )
    @GetMapping({"/all"})
    public ResponseEntity<List<User>> getUsers() {
        List<User> ratings = this.userService.getAllUsers();
        return new ResponseEntity<>(ratings, HttpStatus.OK);
    }

}
