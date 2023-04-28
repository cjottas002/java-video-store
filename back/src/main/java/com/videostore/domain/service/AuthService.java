package com.videostore.domain.service;

import com.videostore.api.dto.response.ResponseDto;
import com.videostore.domain.model.User;
import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.Future;

public interface AuthService {

    ResponseDto login(String username, String password);
    User register(User user);
    public void verifyToken(String jwtToken);
}

