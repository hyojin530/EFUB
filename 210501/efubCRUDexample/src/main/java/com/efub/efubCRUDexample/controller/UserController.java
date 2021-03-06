package com.efub.efubCRUDexample.controller;

import com.efub.efubCRUDexample.model.User;
import com.efub.efubCRUDexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userid}")
    public User getUserByUserId(@PathVariable String userid) {
        return userService.getUserByUserId(userid);
    }

    @PostMapping("")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/{userid}")
    public void modifyUser(@PathVariable String userid, @RequestBody User user) {
        userService.modifyUser(userid, user);
    }

    @DeleteMapping("/{userid}")
    public void removeUser(@PathVariable String userid) {
        userService.removeUser(userid);
    }
}
