package com.example.springbootintro.dao;

import com.example.springbootintro.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{
    public static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "Jean", "KIKI", "Jean.KIKI@gmail.com", "123456789"));
        users.add(new User(2, "Momo", "HAMED", "Momo.HAME@gmail.com", "abcdef"));
        users.add(new User(3, "Adolfi", "TLAIR", "Adolfi.TLAIR@gmail.com", "abc123"));
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User findById(int id) {
        for (User user : users) {
            if (user.getId() == id){
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> save(User u) {
        users.add(u);
        return users;
    }

    @Override
    public List<User> update(User u, int id) {
        for (User user : users) {
            if (user.getId() == id){
                user.setId(u.getId());
                user.setFirstName(u.getFirstName());
                user.setLastName(u.getLastName());
                user.setEmail(u.getEmail());
                user.setPassword(u.getPassword());
                return users;
            }
        }
        return null;
    }

    @Override
    public List<User> delete(int id) {
        users.removeIf(user -> user.getId() == id);
        return users;
    }
}
