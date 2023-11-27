package com.postgres2.demo.controller;

import com.postgres2.demo.entity.User;
import com.postgres2.demo.server.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable String id) {
        return service.getUserById(id);
    }
    @GetMapping
    public List<User> getAll() {
        return service.getAllUsers();
    }
}
