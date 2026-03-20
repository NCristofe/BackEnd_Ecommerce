package com.projeto.ecommerce.controllers;

import com.projeto.ecommerce.entities.UserEntity;
import com.projeto.ecommerce.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<UserEntity> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public UserEntity findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @PostMapping
    public UserEntity create(@RequestBody UserEntity user) {
        return service.create(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}