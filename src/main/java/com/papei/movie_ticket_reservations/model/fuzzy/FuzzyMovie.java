package com.papei.movie_ticket_reservations.model.fuzzy;

import com.papei.movie_ticket_reservations.model.Movie;

public class FuzzyMovie {
    private Movie movie;
    private double genreSimilarity;
    private double popularitySimilarity;
    private double releaseYearSimilarity;
    private double recommendationConfidence;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
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
