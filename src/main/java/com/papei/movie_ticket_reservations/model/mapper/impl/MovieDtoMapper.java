package com.papei.movie_ticket_reservations.model.mapper.impl;

import com.papei.movie_ticket_reservations.model.Movie;
import com.papei.movie_ticket_reservations.model.mapper.ModelMapper;
import com.papei.movie_ticket_reservations.pojo.dto.MovieDto;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.util.Base64;


public class MovieDtoMapper implements ModelMapper<Movie,MovieDto > {


    @Override
    public MovieDto mapModel(Movie model) {
        MovieDto movieDto = new MovieDto();
        movieDto.setDescription(model.getDescription());
        movieDto.setId(model.getId());
        movieDto.setName(model.getName());
        movieDto.setHall(model.getHall());
        movieDto.setDateRange(model.getDateRange());
        movieDto.setGenre(model.getGenre());
        setPictureByteArray(model, movieDto);
        return movieDto;
    }


    public Movie mapDtoToEntity(MovieDto dto) {
        Movie movie = new Movie();
        movie.setDescription(dto.getDescription());
        movie.setId(dto.getId());
        movie.setName(dto.getName());
        movie.setHall(dto.getHall());
        movie.setDateRange(dto.getDateRange());
        movie.setGenre(dto.getGenre());
        return movie;
    }

    private void setPictureByteArray(Movie model, MovieDto movieDto) {
        String imagePath = "pictures/" + model.getPictureUrl();
        ClassLoader classLoader = MovieDtoMapper.class.getClassLoader();
        Path path = null;
        try {
            URL url = classLoader.getResource(imagePath);
            File file = new File(url.getFile());
            byte[] imageData = convertFileToByteArray(file);
            String encoded = "data:image/png;base64," + Base64.getEncoder().encodeToString(imageData);
            movieDto.setPicture(encoded);
        } catch ( IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static byte[] convertFileToByteArray(File file) throws IOException {
        byte[] imageData;
        try (FileInputStream fis = new FileInputStream(file)) {
            imageData = new byte[(int) file.length()];
            fis.read(imageData);
        }
        return imageData;
    }
}
