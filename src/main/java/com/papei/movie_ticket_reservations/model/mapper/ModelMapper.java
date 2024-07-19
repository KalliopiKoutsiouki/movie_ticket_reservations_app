package com.papei.movie_ticket_reservations.model.mapper;

public interface ModelMapper<T,K> {

    K mapModel(T modelClass);

    T mapDtoToEntity(K dto);
}
