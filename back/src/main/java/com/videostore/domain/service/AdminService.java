package com.videostore.domain.service;

import com.videostore.domain.model.Movie;
import com.videostore.domain.model.User;

import java.util.List;
import java.util.UUID;

public interface AdminService {
    List<User> getAllUsers();
    List<Movie> getAllMovies();
    Movie registerMovie(Movie movie);
    void deleteMovie(UUID movieId);
}

