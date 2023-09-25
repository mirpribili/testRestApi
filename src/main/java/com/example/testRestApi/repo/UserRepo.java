package com.example.testRestApi.repo;

import com.example.testRestApi.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<Users, Long> {
    Optional<Users> findById(Long id);
    Optional<Users> findByEmail(String email);
}
