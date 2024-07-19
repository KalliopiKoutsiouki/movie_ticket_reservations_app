package com.papei.movie_ticket_reservations.controller;

import com.papei.movie_ticket_reservations.exception.UserNotFoundException;
import com.papei.movie_ticket_reservations.model.Reservation;
import com.papei.movie_ticket_reservations.model.User;
import com.papei.movie_ticket_reservations.model.UserRole;
import com.papei.movie_ticket_reservations.model.mapper.ModelMapper;
import com.papei.movie_ticket_reservations.model.mapper.ModelMapperFactory;
import com.papei.movie_ticket_reservations.pojo.dto.UserDto;
import com.papei.movie_ticket_reservations.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@SecurityRequirement(name = "Authorization")
@RequestMapping({"/users"})
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping({"/all"})
    public List<User> getUsers() {
        return this.userService.getAllUsers();
    }

    @GetMapping({"/{userId}"})
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        try {
            User user = userService.getUserById(userId).orElse(null);
            if (user != null) {
                return ResponseEntity.ok(user);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping({"/reservations/{userName}"})
    public ResponseEntity<List<Reservation>> getUserReservations(@PathVariable String userName) {
        try {
            User user = userService.getUserByUserName(userName).orElse(null);
            if (user == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            } else {
                List<Reservation> reservations = user.getReservations();
                return ResponseEntity.ok(reservations);
            }
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping({"/username/{userName}"})
    public ResponseEntity<User> getUserByUserName(@PathVariable String userName) throws UserNotFoundException {
        try {
            User user = userService.getUserByUserName(userName).orElse(null);
            if (user != null) {
                return ResponseEntity.ok(user);
            }
        } catch (UserNotFoundException e) {
            throw new UserNotFoundException("User not found");
        }
        return null;
    }

    @PostMapping("/new")
    public User addNewUser(@RequestBody User userInfo) {
        setRoleIfUndefined(userInfo);
        return userService.addUser(userInfo);
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<String> updateUser(@PathVariable Long userId, @RequestBody UserDto updatedUser) {

        System.out.println("USERNAME= " + updatedUser.getMobilePhone());
        return update(userId, updatedUser);
    }

    @PostMapping("/answerQuestionnaire/{userId}")
    public ResponseEntity<String> answerQuestionnaire(@PathVariable Long userId, @RequestBody UserDto updatedUserAfterQuestionnaire) {
        return update(userId, updatedUserAfterQuestionnaire);

    }

    private ResponseEntity<String> update(@PathVariable Long userId, @RequestBody UserDto updatedUser) {
        try {
            ModelMapper mapper = ModelMapperFactory.createMapper(UserDto.class);
            User userInfo = (User) mapper.mapModel(updatedUser);
            userService.updateUser(userId,userInfo);
            return ResponseEntity.ok("User updated successfully");
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        try {
            userService.deleteUser(userId);
            return ResponseEntity.ok("User deleted successfully");
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    private void setRoleIfUndefined(User userinfo) {
        Set<UserRole> roles = new HashSet<>();
        if (userinfo.getUserRoles() == null) {
            roles.add(UserRole.ROLE_USER);
            userinfo.setUserRoles(roles);
        }
    }


}
