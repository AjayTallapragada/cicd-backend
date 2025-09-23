package com.app.inventory.Service;

import com.app.inventory.Model.User;
import com.app.inventory.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    // Register user
    public User registerUser(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            return null; // email exists
        }
        return userRepository.save(user);
    }

    // Login user
    public boolean loginUser(String email, String password) {
        User user = userRepository.findByEmailAndPassword(email, password);
        return user != null;
    }
}
