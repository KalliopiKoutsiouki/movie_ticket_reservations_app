package com.papei.movie_ticket_reservations.service.fuzzy;

import com.google.common.collect.Sets;
import com.papei.movie_ticket_reservations.model.Genre;
import com.papei.movie_ticket_reservations.model.Movie;
import com.papei.movie_ticket_reservations.model.fuzzy.FuzzyMovie;
import com.papei.movie_ticket_reservations.repository.MovieRepository;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FuzzyMovieService {

    private static final String FUZZY_RULES_FILE = "src/main/resources/movie_recommendation.fcl";
    private static final String FUNCTION_BLOCK_FUNCTION= "movie_recommendation";
    private static final String GENRE_SIMILARITY = "genreSimilarity";
    private static final String POPULARITY_SIMILARITY = "popularitySimilarity";
    private static final String RELEASE_YEAR_SIMILARITY = "releaseYearSimilarity";
    private static final String RECOMMENDATION_CONFIDENCE = "recommendationConfidence";
    private static final int MAX_YEAR_DIFFERENCE = 5;
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
        List<FuzzyMovie> sorted = fuzzyMovies.stream()
                .sorted(Comparator.comparingDouble(FuzzyMovie::getRecommendationConfidence).reversed()).toList();
        return  sorted.stream()
                .map(FuzzyMovie::getMovie)
                .limit(10)
                .toList();
    }

    private void evaluateFuzzyRules(FuzzyMovie fuzzyMovie) {
        String filename = FUZZY_RULES_FILE;
        FIS fis = FIS.load(filename, true);
        if (fis == null) {
            System.err.println("Can't load file: " + filename);
            return;
        }
        FunctionBlock fb = fis.getFunctionBlock(FUNCTION_BLOCK_FUNCTION);

        fb.setVariable(GENRE_SIMILARITY, fuzzyMovie.getGenreSimilarity());
        fb.setVariable(POPULARITY_SIMILARITY, fuzzyMovie.getPopularitySimilarity());
        fb.setVariable(RELEASE_YEAR_SIMILARITY, fuzzyMovie.getReleaseYearSimilarity());

        // Evaluate
        fb.evaluate();

        double recommendationConfidence = fb.getVariable(RECOMMENDATION_CONFIDENCE).getValue();
        fuzzyMovie.setRecommendationConfidence(recommendationConfidence);
    }

    private FuzzyMovie calculateFuzzyVariables(Movie selectedMovie, Movie movie) {
        FuzzyMovie fuzzyMovie = new FuzzyMovie();
        fuzzyMovie.setMovie(movie);
        fuzzyMovie.setGenreSimilarity(calculateGenreSimilarity(selectedMovie, movie));
        fuzzyMovie.setPopularitySimilarity(calculatePopularitySimilarity(selectedMovie, movie));
        fuzzyMovie.setReleaseYearSimilarity(calculateReleaseYearSimilarity(selectedMovie,movie));

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

    private double calculateReleaseYearSimilarity(Movie selectedMovie, Movie movie) {
        // Maximum difference for similarity
        int yearDifference = Math.abs(selectedMovie.getReleaseYear() - movie.getReleaseYear());
        double normalizedDifference = (double) yearDifference / MAX_YEAR_DIFFERENCE;
        double similarity = 10 - normalizedDifference * 10;
        return Math.max(0, similarity);
    }
}