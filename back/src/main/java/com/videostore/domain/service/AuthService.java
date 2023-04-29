package com.videostore.domain.service;

import com.videostore.api.dto.request.RegisterRequest;
import com.videostore.api.dto.response.ResponseDto;
import com.videostore.domain.model.User;
import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.Future;

public interface AuthService {

    ResponseDto login(String username, String password);
    ResponseDto register(RegisterRequest user);
    public void verifyToken(String jwtToken);
}

