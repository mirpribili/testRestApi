package com.example.testRestApi.controller;

import com.example.testRestApi.model.Users;
import com.example.testRestApi.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class Controller {
    UserService userService;
    @GetMapping
    public Users getUser(){
        return new Users(1l,"name","surname","email","imageUrl","offline");
        // http://localhost:8080/user
    }

    @PostMapping
    public long addUser(@RequestBody Users user){
        return userService.save(user);
    }
}
