package com.nourtabib.app.commandservice.Controller;

import com.nourtabib.app.commandservice.Entity.UserEntity;
import com.nourtabib.app.commandservice.Requests.createUserRequest;
import com.nourtabib.app.commandservice.Requests.updateUserRequest;
import com.nourtabib.app.commandservice.Service.userService;
import com.nourtabib.app.commandservice.UserDomain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class userController {

    userService userService;
    @Autowired
    public userController(userService userService){
        this.userService = userService;
    }
    @PostMapping
    public UserEntity createUser(@RequestBody createUserRequest req){
        User user = new User(req.getFirstName(), req.getLastName(), req.getUsername(), req.getPassword());
        return userService.createUser(user);
    }
    @PostMapping("/update")
    public UserEntity updateUser(@RequestBody updateUserRequest req){
        User user = new User(req.getId(),req.getFirstName(), req.getLastName(), req.getUsername(), req.getPassword());
        return userService.updateUser(user);
    }
    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ;
    }



}
