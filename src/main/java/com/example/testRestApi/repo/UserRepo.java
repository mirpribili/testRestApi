package com.example.testRestApi.repo;

import com.example.testRestApi.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users, Long> {
}
