package com.lms.app.controller;

import com.lms.app.model.User;
import com.lms.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*") 
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        try {
            User savedUser = userService.registerUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
        } catch (RuntimeException e) {
            String msg = e.getMessage();
            
            if (msg.contains("email already exists")) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(msg); // 409
            } else if (msg.contains("Username already taken")) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg); // 400
            } else if (msg.contains("Password must")) {
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(msg); // 406
            }
            
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(msg);
        }
    }

    @GetMapping("/login")
    public ResponseEntity<?> login(
            @RequestParam("identifier") String identifier, 
            @RequestParam("password") String password, 
            @RequestParam("type") String type) {
        
        try {
            User user = userService.loginUser(identifier, password, type);
            return ResponseEntity.ok(user);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}