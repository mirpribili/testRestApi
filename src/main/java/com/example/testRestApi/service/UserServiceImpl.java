package com.example.testRestApi.service;

import com.example.testRestApi.model.Users;
import com.example.testRestApi.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
@AllArgsConstructor
public class UserServiceImpl implements  UserService{
    UserRepo userRepo; // for connect to DB
    @Override
    public Long save(Users user) {
        long id = userRepo.save(user).getId();
        return id;
    }

    @Override
    public Users findById(long id) {
        return null;
    }

    @Override
    public Map<String, String> updateUser(long id) {
        return null;
    }
}
