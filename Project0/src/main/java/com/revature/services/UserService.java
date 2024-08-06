package com.revature.services;

import com.revature.models.User;

public interface UserService {

    // Method to register a new user
    User register(User user);

    // Method to log in a user
    User login(String username, String password);
}
