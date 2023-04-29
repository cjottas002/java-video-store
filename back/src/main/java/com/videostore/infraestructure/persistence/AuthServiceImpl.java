package com.videostore.infraestructure.persistence;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.videostore.api.dto.request.RegisterRequest;
import com.videostore.api.dto.response.LoginResponse;
import com.videostore.api.dto.response.ResponseDto;
import com.videostore.domain.model.User;
import com.videostore.domain.repository.UserRepository;
import com.videostore.domain.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public ResponseDto<LoginResponse> login(String username, String password) {

        ResponseDto<LoginResponse> response = new ResponseDto<>(false, null, null);

        try {
            User user = userRepository.findByUsername(username);

            if (user != null && password.equals(user.getPassword())) {
                Algorithm algorithm = Algorithm.HMAC256("secretKey");
                String jwtToken = JWT.create()
                        .withSubject(username)
                        .withClaim("role", user.getRole())
                        .sign(algorithm);

                response = new ResponseDto<>(true, new LoginResponse(username, jwtToken, user.getRole()), null);
                return response;
            }

        }catch (Exception e) {
            response.setErrorMessage(e.getMessage());
        }

        response.setErrorMessage("Usuario o contraseña no validos");
        return response;
    }

    @Override
    public ResponseDto<User> register(RegisterRequest request) {

        ResponseDto<User> response = new ResponseDto<>(false, null, null);
        try {

            User existingUser = userRepository.findByUsername(request.getUsername());

            if (existingUser != null) {
                response.setErrorMessage("A user with this username already exists.");
                return response;
            }

            User user = new User(request.getUsername(), request.getPassword());
            response.setResult(true);
            response.setData(user);
            userRepository.save(user);

        }catch (Exception ex) {
            response.setErrorMessage(ex.getMessage());
        }

        return response;
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
