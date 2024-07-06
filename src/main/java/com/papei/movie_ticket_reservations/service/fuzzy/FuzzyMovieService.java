package com.papei.movie_ticket_reservations.service.fuzzy;

import com.google.common.collect.Sets;
import com.papei.movie_ticket_reservations.model.Genre;
import com.papei.movie_ticket_reservations.model.Movie;
import com.papei.movie_ticket_reservations.model.fuzzy.FuzzyMovie;
import com.papei.movie_ticket_reservations.repository.MovieRepository;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.*;

@Service
public class FuzzyMovieService {

    private final MovieRepository movieRepository;

    public FuzzyMovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getMovieRecommendationsSorted(Long movieId) {
        Movie selectedMovie = movieRepository.findById(movieId).orElse(null);
        if (selectedMovie == null) {
            return Collections.emptyList();
        }
        List<Movie> allMovies = movieRepository.findAll();

        List<FuzzyMovie> fuzzyMovies = allMovies.stream()
                .map(movie -> calculateFuzzyVariables(selectedMovie, movie))
                .toList();

        fuzzyMovies.forEach(this::evaluateFuzzyRules);

        List<Movie> sortedMovies = fuzzyMovies.stream()
                .sorted(Comparator.comparingDouble(FuzzyMovie::getRecommendationConfidence).reversed())
                .map(FuzzyMovie::getMovie)
                .limit(10)
                .toList();

        return sortedMovies;
    }

    private void evaluateFuzzyRules(FuzzyMovie fuzzyMovie) {
        String filename = "src/main/resources/movie_recommendation.fcl";
        FIS fis = FIS.load(filename, true);
        if (fis == null) {
            System.err.println("Can't load file: " + filename);
            return;
        }
        FunctionBlock fb = fis.getFunctionBlock("movie_recommendation");

        fb.setVariable("genreSimilarity", fuzzyMovie.getGenreSimilarity());
        fb.setVariable("popularitySimilarity", fuzzyMovie.getPopularity());
        fb.setVariable("directorSimilarity", fuzzyMovie.getDirectorPreference());
        fb.setVariable("releaseYearSimilarity", fuzzyMovie.getReleaseYearScore());

        // Evaluate
        fb.evaluate();

        double recommendationConfidence = fb.getVariable("recommendationConfidence").getValue();
        fuzzyMovie.setRecommendationConfidence(recommendationConfidence);
    }

    private FuzzyMovie calculateFuzzyVariables(Movie selectedMovie, Movie movie) {
        FuzzyMovie fuzzyMovie = new FuzzyMovie();
        fuzzyMovie.setMovie(movie);
        fuzzyMovie.setGenreSimilarity(calculateGenreSimilarity(selectedMovie, movie));
        fuzzyMovie.setPopularity(calculatePopularitySimilarity(selectedMovie, movie));
        fuzzyMovie.setDirectorPreference(calculateDirectorSimilarity(selectedMovie, movie));
        fuzzyMovie.setReleaseYearScore(calculateReleaseYearSimilarity(selectedMovie,movie));

        return fuzzyMovie;
    }

    private double calculateGenreSimilarity(Movie selectedMovie, Movie movie) {
        Set<Genre> selectedMovieGenre = selectedMovie.getGenre();
        Set<Genre> movieGenre = movie.getGenre();
        double genreSimilarity = Sets.intersection(selectedMovieGenre, movieGenre).size() / Sets.union(selectedMovieGenre, movieGenre).size();
        return genreSimilarity * 10;
    }

    private double calculatePopularitySimilarity(Movie selectedMovie, Movie movie) {
        double diff = Math.abs(selectedMovie.getPopularity() - movie.getPopularity());
        return 10 - diff;
    }

    private double calculateDirectorSimilarity(Movie selectedMovie, Movie movie) {
        return selectedMovie.getDirector().equals(movie.getDirector()) ? 10 : 0;
    }

    private double calculateReleaseYearSimilarity(Movie selectedMovie, Movie movie) {
        // Maximum difference for similarity
        int maxYearDifference = 5;
        int yearDifference = Math.abs(selectedMovie.getReleaseYear() - movie.getReleaseYear());
        double normalizedDifference = (double) yearDifference / maxYearDifference;
        double similarity = 10 - normalizedDifference * 10;
        return Math.max(0, similarity);
    }
}