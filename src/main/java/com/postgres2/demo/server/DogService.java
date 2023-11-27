package com.postgres2.demo.server;

import com.postgres2.demo.dto.DogDTO;
import com.postgres2.demo.entity.Dog;
import com.postgres2.demo.entity.User;
import com.postgres2.demo.mapping.DogMapping;
import com.postgres2.demo.repository.JpaRepositoryDog;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DogService {
    private final JpaRepositoryDog jpaRepositoryDog;
    private final DogMapping dogMapping;

    public Optional<Dog> getDogById(String id) {
        return jpaRepositoryDog.findById(UUID.fromString(id));

    }
    public Optional<DogDTO> getDogDTOById(String id) {
        return Optional.ofNullable(dogMapping.mapToDogDTO(jpaRepositoryDog.findById(UUID.fromString(id))
                        .orElseThrow(RuntimeException::new)));
    }
    public List<Dog> getAllDog() {
        return jpaRepositoryDog.findAll();
    }
    public List<DogDTO> getAllDogDTO() {
        return jpaRepositoryDog.findAll().stream()
                .map(x -> dogMapping.mapToDogDTO(x))
                .toList();
    }
    public void addDog(DogDTO dogDTO) {
        Dog dog = dogMapping.mapToDog(dogDTO);
            jpaRepositoryDog.save(dog);
    }
}
