package dev.ayush.movies.service;

import dev.ayush.movies.models.Movies;
import dev.ayush.movies.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {


    MovieRepository movieRepository;
    @Autowired
    MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    public List<Movies> allMovies(){
      return movieRepository.findAll();

    }

//    public Optional<Movies> getSingleMovie(ObjectId id){
//
//        return movieRepository.findById(id);
//
//    }

    public Optional<Movies> getSingleMovie(String imdbId){

        return movieRepository.findMoviesByImdbId(imdbId);

    }
}
