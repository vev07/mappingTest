package com.postgres2.demo.server;

import com.postgres2.demo.entity.User;
import com.postgres2.demo.repository.JpaRepositoryUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private  final JpaRepositoryUser repository;


    public Optional<User> getUserById(String id) {
        return repository.findById(UUID.fromString(id));
    }


    public List<User> getAllUsers() {
        return repository.findAll();
    }

}
