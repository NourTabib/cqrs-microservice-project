package com.nourtabib.app.queryservice.Controller;

import com.nourtabib.app.queryservice.Entity.UserEntity;
import com.nourtabib.app.queryservice.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class userController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<UserEntity> findAllUsers(){
        return userRepository.findAll();
    }
    @GetMapping("{id}")
    public Optional<UserEntity> findUserById(@PathVariable Long id){
        return userRepository.findById(id);
    }
    @GetMapping("/name/{name}")
    public List<UserEntity> findUserByName(@PathVariable String name){
        return userRepository.findByFirstName(name);
    }
}
