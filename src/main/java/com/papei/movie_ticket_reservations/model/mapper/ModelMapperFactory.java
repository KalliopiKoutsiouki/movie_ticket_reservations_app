package com.papei.movie_ticket_reservations.model.mapper;

import com.papei.movie_ticket_reservations.model.Movie;
import com.papei.movie_ticket_reservations.model.mapper.impl.MovieDtoMapper;
import com.papei.movie_ticket_reservations.model.mapper.impl.UserDtoMapper;
import com.papei.movie_ticket_reservations.pojo.dto.MovieDto;
import com.papei.movie_ticket_reservations.pojo.dto.UserDto;

public class ModelMapperFactory {

        public static ModelMapper createMapper(Class<?> importedClass) {
            if (importedClass == UserDto.class) {
                return new UserDtoMapper();
            }
            if (importedClass == MovieDto.class) {
                return new MovieDtoMapper();
            }
            throw new IllegalArgumentException("Unsupported class type");
        }
}

