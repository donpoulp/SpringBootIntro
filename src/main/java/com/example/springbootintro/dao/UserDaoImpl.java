package com.example.springbootintro.dao;

import com.example.springbootintro.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{
    public static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "Jean", "KIKI", "des1235fj", 98, 12, 28));
        users.add(new User(2, "Momo", "HAMED", "hytf21sct5", 39, 02, 15));
        users.add(new User(3, "Adolfi", "TLAIR", "12cdrt8z5", 39, 45, 39));
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
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:9192/licenses/{u.getCode()}";
        ResponseEntity<Boolean> response = restTemplate.getForEntity(url, Boolean.class, u.getCode());
        if (response.getBody() == true){
            users.add(u);
            return users;
        }else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Your code is not valid");
        }
    }

    @Override
    public List<User> update(User u, int id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:9192/licenses/{u.getCode()}";
        ResponseEntity<Boolean> response = restTemplate.getForEntity(url, Boolean.class, u.getCode());
        if (response.getBody() == true) {
            for (User user : users) {
                if (user.getId() == id) {
                    user.setId(u.getId());
                    user.setFirstName(u.getFirstName());
                    user.setLastName(u.getLastName());
                    user.setBirthDate(u.getBirthDate());
                    user.setCode(user.getCode());
                    return users;
                }
            }
        }else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Your code is not valid");
        }
        return null;
    }

    @Override
    public List<User> delete(int id) {
        users.removeIf(user -> user.getId() == id);
        return users;
    }
}
