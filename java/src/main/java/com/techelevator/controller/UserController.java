package com.techelevator.controller;


import com.techelevator.dao.UserDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping(path = "/users")
    public List<User> getAllUsers() {
        List<User> allUsersList;
        try{
            allUsersList = userDao.getUsers();
        }catch(DaoException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not Found.");
        }
        return allUsersList;
    }

    @GetMapping(path = "/users/{id}")
    public User getUserByUserId(@PathVariable int id) {
        try {
            return userDao.getUserById(id);
        }catch (DaoException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/users/{username}")
    public User getUserByUsername(@PathVariable String username) {
        try {
            return userDao.getUserByUsername(username);
        }catch (DaoException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
