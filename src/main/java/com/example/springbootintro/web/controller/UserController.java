package com.example.springbootintro.web.controller;

import com.example.springbootintro.dao.UserDao;
import com.example.springbootintro.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {

    private final UserDao userDao;

    public UserController(UserDao userDao){
        this.userDao = userDao;
    }

    @GetMapping("/users")
    public List<User> getUsersList() {
        return userDao.findAll();
    }

    @GetMapping(value ="/user/{id}")
    public User getUser(@PathVariable int id) {
        return userDao.findById(id);
    }

    @PostMapping(value = "/user")
    public List<User> addUser(@RequestBody User user) {
        return userDao.save(user);
    }

    @PutMapping(value = "/user/{id}")
    public List<User> updateUser(@RequestBody User user,@PathVariable int id) {
        return userDao.update(user, id);
    }

    @DeleteMapping(value = "/user/{id}")
    public List<User> deleteUser(@PathVariable int id) {
        return userDao.delete(id);
    }
}
