package com.videostore.domain.service;

import com.videostore.domain.model.Rental;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface RentalService {

    List<Rental> findAll();
    Optional<Rental> findById(UUID id);
    Rental save(Rental alquiler);
    void deleteById(UUID id);
    Rental rentMovie(UUID userId, UUID movieId);
    Rental returnMovie(UUID rentalId);
    List<Rental> findByUserId(UUID userId);
}

