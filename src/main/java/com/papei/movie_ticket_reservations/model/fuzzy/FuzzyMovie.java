package com.papei.movie_ticket_reservations.model.fuzzy;

import com.papei.movie_ticket_reservations.model.Movie;
import com.papei.movie_ticket_reservations.pojo.dto.MovieDto;

public class FuzzyMovie {
    private MovieDto movieDto;
    private double genreSimilarity;
    private double popularitySimilarity;
    private double releaseYearSimilarity;
    private double recommendationConfidence;

    public MovieDto getMovieDto() {
        return movieDto;
    }

    public void setMovieDto(MovieDto movie) {
        this.movieDto = movie;
    }

    public double getGenreSimilarity() {
        return genreSimilarity;
    }

    public void setGenreSimilarity(double genreSimilarity) {
        this.genreSimilarity = genreSimilarity;
    }

    public double getPopularitySimilarity() {
        return popularitySimilarity;
    }

    public void setPopularitySimilarity(double popularitySimilarity) {
        this.popularitySimilarity = popularitySimilarity;
    }

    public double getReleaseYearSimilarity() {
        return releaseYearSimilarity;
    }

    public void setReleaseYearSimilarity(double releaseYearSimilarity) {
        this.releaseYearSimilarity = releaseYearSimilarity;
    }

    public double getRecommendationConfidence() {
        return recommendationConfidence;
    }

    public void setRecommendationConfidence(double recommendationCondidence) {
        this.recommendationConfidence = recommendationCondidence;
    }

}
