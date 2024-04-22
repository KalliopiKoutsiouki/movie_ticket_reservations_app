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

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@SecurityRequirement(name = "Authorization")
@RequestMapping({"/user"})
public class UserRoleController {

    @Autowired
    private UserService userService;

    @PutMapping("/{userId}/role")
    public ResponseEntity<String> addUserRole(@PathVariable Long userId, @RequestParam UserRole role) {
        try{
            User user = userService.getUserById(userId).orElse(null);
            if (user == null) {
                return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
            }

            Set<UserRole> userRoles = user.getUserRoles();
            userRoles.add(role);
            user.setUserRoles(userRoles);
            userService.updateUser(user.getId(), user);

            return ResponseEntity.ok("Role added successfully");
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }

    @DeleteMapping("/{userId}/role")
    public ResponseEntity<String> removeUserRole(@PathVariable Long userId, @RequestParam UserRole role) {
        try {
            User user = userService.getUserById(userId).orElse(null);
            if (user == null) {
                return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
            }

            Set<UserRole> userRoles = user.getUserRoles();
            if (!userRoles.contains(role)) {
                return new ResponseEntity<>("User does not have this role", HttpStatus.BAD_REQUEST);
            }

            userRoles.remove(role);
            user.setUserRoles(userRoles);
            userService.updateUser(user.getId(), user);

            return ResponseEntity.ok("Role removed successfully");
        } catch (UserNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
