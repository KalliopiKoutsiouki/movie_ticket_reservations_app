package com.papei.movie_ticket_reservations.model.mapper.impl;

import com.papei.movie_ticket_reservations.model.User;
import com.papei.movie_ticket_reservations.model.mapper.ModelMapper;
import com.papei.movie_ticket_reservations.pojo.dto.UserDto;

public class UserDtoMapper implements ModelMapper<UserDto, User> {

    @Override
    public User mapModel(UserDto userDto) {
        User user = new User();
        user.setUserName(userDto.getUsername());
        user.setFirstName(userDto.getFirstName());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setLastName(userDto.getLastName());
        return user;
    }




}
