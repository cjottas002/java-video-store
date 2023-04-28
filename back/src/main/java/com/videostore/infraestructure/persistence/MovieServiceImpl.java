package com.videostore.infraestructure.persistence;

import com.videostore.domain.model.Movie;
import com.videostore.domain.model.Rental;
import com.videostore.domain.repository.MovieRepository;
import com.videostore.domain.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movie> findAll() {
       return this.movieRepository.findAll();
    }

    @Override
    public Optional<Movie> findById(UUID id) {
        return this.movieRepository.findById(id);
    }

    @Override
    public Movie save(Movie movie) {
        return this.movieRepository.save(movie);
    }

    @Override
    public void deleteById(UUID id) {
        this.movieRepository.deleteById(id);
    }

    @Override
    public boolean isAvailable(UUID movieId) {
        return false;
    }


}
