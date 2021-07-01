package com.accessor.backendtest.service;

import com.accessor.backendtest.error.UserNotFoundException;
import com.accessor.backendtest.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> getUsers();
    User getUserById(Long id) throws UserNotFoundException;
    String deleteUserById(Long id);
    User updateUser(Long id, User user);
}
