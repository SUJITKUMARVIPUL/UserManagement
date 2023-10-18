package com.sujit.UserManagement.controller;

import com.sujit.UserManagement.model.UpdateType;
import com.sujit.UserManagement.model.User;
import com.sujit.UserManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("User")
    public String addUser(@RequestBody List<User> newUser){
        return userService.addUser(newUser);
    }

    @GetMapping("user")
    public Optional<User> getUserById(@RequestParam Integer Id){
        return userService.getUserById(Id);
    }

    @GetMapping("allUser")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @DeleteMapping("removeUser")
    public String deleteById(@RequestParam Integer id){
        return userService.deleteById(id);
    }

    @PutMapping("update")
    public String updateUser(@RequestParam Integer Id,@RequestParam UpdateType type,@RequestParam String newValue){
        return userService.updateUser(Id,type,newValue);
    }

}
