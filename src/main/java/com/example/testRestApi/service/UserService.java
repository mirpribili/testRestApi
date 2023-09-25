package com.example.testRestApi.service;

import com.example.testRestApi.model.Users;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface UserService {
    ResponseEntity<Object> save(Users user);
    ResponseEntity<Object> findById(long id);
    ResponseEntity<Object> updateUser(long id);
}
