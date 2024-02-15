package com.papei.movie_ticket_reservations.model.mapper;

import com.papei.movie_ticket_reservations.model.mapper.impl.UserDtoMapper;
import com.papei.movie_ticket_reservations.pojo.dto.UserDto;

public class ModelMapperFactory {

        public static ModelMapper createMapper(Class<?> importedClass) {
            if (importedClass == UserDto.class) {
                return new UserDtoMapper();
            }
            throw new IllegalArgumentException("Unsupported class type");
        }
}

