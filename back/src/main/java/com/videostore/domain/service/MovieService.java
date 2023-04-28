package com.videostore.domain.service;

import com.videostore.domain.model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface MovieService {
    List<Movie> findAll();
    Optional<Movie> findById(UUID id);
    Movie save(Movie movie);
    void deleteById(UUID id);
    boolean isAvailable(UUID movieId);

}

