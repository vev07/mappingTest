package com.postgres2.demo.repository;

import com.postgres2.demo.entity.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaRepositoryDog extends JpaRepository<Dog, UUID> {
}
