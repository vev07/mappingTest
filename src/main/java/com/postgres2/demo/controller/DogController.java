package com.postgres2.demo.controller;

import com.postgres2.demo.dto.DogDTO;
import com.postgres2.demo.entity.Dog;

import com.postgres2.demo.server.DogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dog")
@RequiredArgsConstructor
public class DogController {
    private final DogService dogService;


    @GetMapping("/{id}")
    public Optional<Dog> getDogById(@PathVariable String id) {
        return dogService.getDogById(id);
    }
    @GetMapping("/DTO/{id}")
    public Optional<DogDTO> getDogDTOById(@PathVariable String id) {
        return dogService.getDogDTOById(id);
    }
    @GetMapping
    public List<Dog> getAllDog() {
        return dogService.getAllDog();
    }
    @GetMapping("/DTO")
    public List<DogDTO> getAllDogDTO() {
        return dogService.getAllDogDTO();
    }
    @PostMapping
    public void addDog(DogDTO dogDTO) {
        dogService.addDog(dogDTO);
    }

}
