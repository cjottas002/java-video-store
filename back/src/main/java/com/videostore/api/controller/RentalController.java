package com.videostore.api.controller;

import com.videostore.domain.model.Rental;
import com.videostore.domain.service.RentalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "https://localhost:4200")
@RestController
@RequestMapping("/api/rentals")
public class RentalController {
    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping
    public ResponseEntity<List<Rental>> findAll() {
        return ResponseEntity.ok(rentalService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rental> findById(@PathVariable UUID id) {
        return rentalService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Rental> create(@RequestBody Rental alquiler) {
        return ResponseEntity.ok(rentalService.save(alquiler));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rental> update(@PathVariable UUID id, @RequestBody Rental alquiler) {
        if (!rentalService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        alquiler.setId(id);
        return ResponseEntity.ok(rentalService.save(alquiler));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        if (!rentalService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        rentalService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
