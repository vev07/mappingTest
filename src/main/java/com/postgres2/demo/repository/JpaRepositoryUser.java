package com.postgres2.demo.repository;

import com.postgres2.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaRepositoryUser extends JpaRepository<User, UUID> {
}
