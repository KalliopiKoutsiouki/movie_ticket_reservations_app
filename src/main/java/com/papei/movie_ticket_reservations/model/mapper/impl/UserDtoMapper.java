package com.papei.movie_ticket_reservations.model.mapper.impl;

import com.papei.movie_ticket_reservations.model.Movie;
import com.papei.movie_ticket_reservations.model.User;
import com.papei.movie_ticket_reservations.model.mapper.ModelMapper;
import com.papei.movie_ticket_reservations.model.mapper.ModelMapperFactory;
import com.papei.movie_ticket_reservations.pojo.dto.MovieDto;
import com.papei.movie_ticket_reservations.pojo.dto.UserDto;

public class UserDtoMapper implements ModelMapper<UserDto, User> {

    private final ModelMapper mapper = ModelMapperFactory.createMapper(MovieDto.class);

    @Override
    public User mapModel(UserDto userDto) {
        User user = new User();
        user.setUserName(userDto.getUserName());
        user.setFirstName(userDto.getFirstName());
        user.setMobilePhone(userDto.getMobilePhone());
        user.setEmail(userDto.getEmail());
        user.setLastName(userDto.getLastName());
        if (userDto.getChosenMovie() != null) {
            user.setChosenMovie((Movie) mapper.mapDtoToEntity(userDto.getChosenMovie()));
        }
        user.setHasKids(userDto.getHasKids());
        return user;
    }

    @Override
    public UserDto mapDtoToEntity(User dto) {
        return null;
    }


}
