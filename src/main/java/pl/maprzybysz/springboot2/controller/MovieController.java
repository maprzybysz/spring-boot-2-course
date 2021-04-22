package pl.maprzybysz.springboot2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.maprzybysz.springboot2.annotation.SendMailAnnotation;
import pl.maprzybysz.springboot2.model.Movie;
import pl.maprzybysz.springboot2.service.EmailService;
import pl.maprzybysz.springboot2.service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private MovieService movieService;


    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getMovies(){
        return new ResponseEntity(movieService.getMovies(), HttpStatus.OK);
    }
    @PostMapping
    @SendMailAnnotation
    public ResponseEntity addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity(HttpStatus.OK);
    }



}
