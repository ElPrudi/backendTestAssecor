package com.accessor.backendtest.controller;

import com.accessor.backendtest.error.UserNotFoundException;
import com.accessor.backendtest.model.User;
import com.accessor.backendtest.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController @RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    private final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/")
    public User saveUser(@Valid @RequestBody User user) {
        LOGGER.info("Inside saveUser of UserController");
        return userService.saveUser(user);
    }

    @GetMapping("/")
    public List<User> getUsers() {
        LOGGER.info("Inside getUsers of UserController");
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id) throws UserNotFoundException {
        LOGGER.info("Inside getUserById of UserController");
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable("id") Long id) {
        LOGGER.info("Inside deleteUserById of UserController");
        return userService.deleteUserById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        LOGGER.info("Inside updateUser of UserController");
        return userService.updateUser(id, user);
    }
}
