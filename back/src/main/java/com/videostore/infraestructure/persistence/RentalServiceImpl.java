package com.videostore.infraestructure.persistence;

import com.videostore.domain.model.Rental;
import com.videostore.domain.repository.RentalRepository;
import com.videostore.domain.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class RentalServiceImpl implements RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    @Override
    public List<Rental> findAll() {
        return this.rentalRepository.findAll();
    }

    @Override
    public Optional<Rental> findById(UUID id) {
        return this.rentalRepository.findById(id);
    }

    @Override
    public Rental save(Rental rental) {
        return this.rentalRepository.save(rental);
    }

    @Override
    public void deleteById(UUID id) {
        this.rentalRepository.deleteById(id);
    }

    @Override
    public Rental rentMovie(UUID userId, UUID movieId) {
        return null;
    }

    @Override
    public Rental returnMovie(UUID rentalId) {
        return null;
    }

    @Override
    public List<Rental> findByUserId(UUID userId) {
        return null;
    }
}
