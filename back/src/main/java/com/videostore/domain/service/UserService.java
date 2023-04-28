package com.videostore.domain.service;

import com.videostore.domain.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public  interface UserService {
    List<User> findAll();
    Optional<User> findById(UUID id);
    User save(User user);
    void deleteById(UUID id);

}

