package com.videostore.api.controller;


import com.videostore.api.dto.request.LoginRequest;
import com.videostore.api.dto.request.RegisterRequest;
import com.videostore.api.dto.response.LoginResponse;
import com.videostore.api.dto.response.ResponseDto;
import com.videostore.domain.model.User;
import com.videostore.domain.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "https://localhost:4200")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequest loginRequest) {
       return ResponseEntity.ok(this.authService.login(loginRequest.getUsername(), loginRequest.getPassword()));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(this.authService.register(request));
    }

}
