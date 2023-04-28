package com.videostore.api.controller;

import com.videostore.domain.model.Rental;
import com.videostore.domain.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/rentals")
public class RentalController {
    @Autowired
    private RentalService alquilerService;

    @GetMapping
    public ResponseEntity<List<Rental>> findAll() {
        return ResponseEntity.ok(alquilerService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rental> findById(@PathVariable UUID id) {
        return alquilerService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Rental> create(@RequestBody Rental alquiler) {
        return ResponseEntity.ok(alquilerService.save(alquiler));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rental> update(@PathVariable UUID id, @RequestBody Rental alquiler) {
        if (!alquilerService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        alquiler.setId(id);
        return ResponseEntity.ok(alquilerService.save(alquiler));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        if (!alquilerService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        alquilerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
