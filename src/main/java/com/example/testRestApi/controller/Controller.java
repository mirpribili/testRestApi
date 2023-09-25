package com.example.testRestApi.controller;

import com.example.testRestApi.model.Users;
import com.example.testRestApi.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class Controller {

    UserService userService;

    @GetMapping
    public Users getUserTestController() {
        return new Users(1l, "name", "surname", "email", "imageUrl", "offline");
        // http://localhost:8080/user
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Object> getUser(@PathVariable String userId) {
        return userService.findById(Integer.parseInt(userId));
    }

    @PostMapping
    public ResponseEntity<Object> addUser(@RequestBody Users user) {
        return userService.save(user);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Object> updateUserStatus(@PathVariable String userId){
        return userService.updateUser(Integer.parseInt(userId));
    }
}
