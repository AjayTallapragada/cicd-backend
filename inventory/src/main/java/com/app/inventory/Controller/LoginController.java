package com.app.inventory.Controller;

import com.app.inventory.Model.User;
import com.app.inventory.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5174") // allow React frontend
public class LoginController {

    @Autowired
    private LoginService loginService;

    // Register endpoint
    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody User user) {
        Map<String, Object> response = new HashMap<>();
        User savedUser = loginService.registerUser(user);
        if (savedUser == null) {
            response.put("success", false);
            response.put("message", "Email already exists!");
        } else {
            response.put("success", true);
            response.put("message", "User registered successfully!");
        }
        return response;
    }

    // Login endpoint
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody User user) {
        Map<String, Object> response = new HashMap<>();
        boolean success = loginService.loginUser(user.getEmail(), user.getPassword());
        response.put("success", success);
        response.put("message", success ? "Login successful!" : "Invalid email or password!");
        return response;
    }
}
