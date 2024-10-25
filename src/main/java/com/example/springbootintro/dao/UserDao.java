package com.example.springbootintro.dao;

import com.example.springbootintro.model.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    User findById(int id);
    List<User> save(User u);
    List<User> update(User u, int id);
    List<User> delete(int id);
}
