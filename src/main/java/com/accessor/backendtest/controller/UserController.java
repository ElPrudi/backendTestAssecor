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

    //Nutzer erstellen
    @PostMapping("/")
    public User saveUser(@Valid @RequestBody User user) {
        LOGGER.info("Inside saveUser of UserController");
        return userService.saveUser(user);
    }

    //Komplette Nutzerliste ausgeben
    @GetMapping("/")
    public List<User> getUsers() {
        LOGGER.info("Inside getUsers of UserController");
        return userService.getUsers();
    }

    //Bestimmten Nutzer ausgeben
    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id) throws UserNotFoundException {
        LOGGER.info("Inside getUserById of UserController");
        return userService.getUserById(id);
    }

    //Bestimmten Nutzer löschen
    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable("id") Long id) {
        LOGGER.info("Inside deleteUserById of UserController");
        return userService.deleteUserById(id);
    }

    //Bestimmten Nutzer aktualisieren
    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        LOGGER.info("Inside updateUser of UserController");
        return userService.updateUser(id, user);
    }
}
