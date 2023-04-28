package com.videostore.api.controller;


import com.videostore.api.dto.LoginRequest;
import com.videostore.api.dto.LoginResponse;
import com.videostore.api.dto.response.ResponseDto;
import com.videostore.domain.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.Future;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthService authService;


    @PostMapping("/login")
    public ResponseEntity<ResponseDto> login(@RequestBody LoginRequest loginRequest) {
       return ResponseEntity.ok(this.authService.login(loginRequest.getUsername(), loginRequest.getPassword()));
    }

}
