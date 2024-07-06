package com.papei.movie_ticket_reservations.model.fuzzy;

import com.papei.movie_ticket_reservations.model.Movie;

public class FuzzyMovie {
    private Movie movie;
    private double genreSimilarity;
    private double popularity;
    private double directorPreference;
    private double releaseYearScore;
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

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public double getDirectorPreference() {
        return directorPreference;
    }

    public void setDirectorPreference(double directorPreference) {
        this.directorPreference = directorPreference;
    }

    public double getReleaseYearScore() {
        return releaseYearScore;
    }

    public void setReleaseYearScore(double releaseYearScore) {
        this.releaseYearScore = releaseYearScore;
    }

    public double getRecommendationConfidence() {
        return recommendationConfidence;
    }

    public void setRecommendationConfidence(double recommendationCondidence) {
        this.recommendationConfidence = recommendationCondidence;
    }

}
