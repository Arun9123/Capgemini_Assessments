package com.lms.app.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.app.model.User;
import com.lms.app.repository.UserRepo;
import com.lms.app.exception.*; 

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User registerUser(User user) {
        if (userRepo.findByEmail(user.getEmail()).isPresent()) {
            throw new DuplicateEmailException("User with this email already exists.");
        }
        if (userRepo.findByUsername(user.getUsername()).isPresent()) {
            throw new DuplicateUsernameException("Username already taken. Please choose another.");
        }
        if (!isValidPassword(user.getPassword())) {
            throw new WeakPasswordException("Password must have 6 characters, including uppercase, lowercase, number, and symbol.");
        }
        return userRepo.save(user);
    }

    public User loginUser(String identifier, String password, String loginType) {
        Optional<User> userOptional;
        if ("email".equalsIgnoreCase(loginType)) {
            userOptional = userRepo.findByEmail(identifier);
        } else {
            userOptional = userRepo.findByUsername(identifier);
        }
        if (userOptional.isEmpty()) {
            throw new InvalidCredentialsException("No user found with that " + loginType);
        }

        User user = userOptional.get();
        if (!user.getPassword().equals(password)) {
            throw new InvalidCredentialsException("Wrong password.");
        }
        return user;
    }

    private boolean isValidPassword(String password) {
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{6,}$";
        return password != null && password.matches(regex);
    }
}