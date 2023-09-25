package com.example.testRestApi.service;

import com.example.testRestApi.exception.UserExistingEmailException;
import com.example.testRestApi.exception.UserNotFoundException;
import com.example.testRestApi.model.Users;
import com.example.testRestApi.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
@AllArgsConstructor
public class UserServiceImpl implements  UserService{
    UserRepo userRepo; // for connect to DB
    @Override
    public Long save(Users user) {
        if(user.getEmail().equals(userRepo.findByEmail(user.getEmail()).get().getEmail()))
            throw new UserExistingEmailException("there is user with the same email");

        long id = userRepo.save(user).getId();
        return id;
    }

    @Override
    public Users findById(long id) {
        if(!userRepo.findById(id).isPresent())
            throw new UserNotFoundException("User does not exist");
        return userRepo.findById(id).get();
    }

    @Override
    public Map<String, String> updateUser(long id) {

        if(!userRepo.findById(id).isPresent())
            throw new UserNotFoundException("User does not exist");

        Users user = userRepo.findById(id).get();
        Map<String, String> updateResponse = new HashMap<>();
        updateResponse.put("id", "" + user.getId());
        updateResponse.put("previous status", user.getStatus());
        if(user.getStatus().equalsIgnoreCase("offline")){
            user.setStatus("online");
            updateResponse.put("current status", user.getStatus());
        }else{
            user.setStatus("offline");
            updateResponse.put("current status", user.getStatus());
        }
        userRepo.save(user);

        return updateResponse;
    }
}
