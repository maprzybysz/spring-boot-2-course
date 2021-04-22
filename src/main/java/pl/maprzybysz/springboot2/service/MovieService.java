package pl.maprzybysz.springboot2.service;

import org.springframework.stereotype.Service;
import pl.maprzybysz.springboot2.model.Movie;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    private List<Movie> movieList;

    public MovieService() {
        this.movieList = new ArrayList<>();
        movieList.add(new Movie("Bad boys for life", "Bilall Fallah", LocalDate.of(2020, 1, 24)));
    }
    public List<Movie> getMovies(){
        return movieList;
    }
    public void addMovie(Movie movie){
        movieList.add(movie);
    }
}
