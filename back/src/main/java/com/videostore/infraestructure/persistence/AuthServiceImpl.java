package com.videostore.infraestructure.persistence;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.videostore.api.dto.LoginResponse;
import com.videostore.api.dto.response.ResponseDto;
import com.videostore.domain.model.User;
import com.videostore.domain.repository.UserRepository;
import com.videostore.domain.service.AuthService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public ResponseDto login(String username, String password) {

        ResponseDto response = new ResponseDto(false, null, null);

        try{
            User user = userRepository.findByUsername(username);

            if (user != null && password.equals(user.getPassword())) {
                Algorithm algorithm = Algorithm.HMAC256("secretKey");
                String jwtToken = JWT.create()
                        .withSubject(username)
                        .withClaim("role", user.getRole())
                        .sign(algorithm);

                response = new ResponseDto(true, new LoginResponse(username, jwtToken, user.getRole()), null);
                return response;
            }
        }catch (Exception e){
            response.setErrorMessage(e.getMessage());
            return response;
        }

        response.setErrorMessage("Error desconocido, hable con el administrador");
        return response;
    }

    @Override
    public User register(@NotNull User user) {

        User existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser != null) {

            throw new RuntimeException("A user with this username already exists.");
        }


        return userRepository.save(user);
    }

    public void verifyToken(String jwtToken) {
        try {

            Algorithm algorithm = Algorithm.HMAC256("secretKey");
            DecodedJWT jwt = JWT.require(algorithm)
                    .build()
                    .verify(jwtToken);

            String username = jwt.getSubject();
            String role = jwt.getClaim("role").asString();

        } catch (JWTVerificationException e) {

        }
    }
}
