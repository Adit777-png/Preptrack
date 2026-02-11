package com.preptrack.service;

import com.preptrack.model.User;
import com.preptrack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) throws Exception {
        if (userRepository.findByEmail(user.getEmail()).isPresent())
            throw new Exception("Email already registered");
        if (userRepository.findByUsername(user.getUsername()).isPresent())
            throw new Exception("Username already taken");
        return userRepository.save(user);
    }

    public User loginUser(String email, String password) throws Exception {
        Optional<User> userOpt = userRepository.findByEmail(email);
        if (userOpt.isEmpty())
            throw new Exception("User not found");
        if (!userOpt.get().getPassword().equals(password))
            throw new Exception("Invalid credentials");
        return userOpt.get();
    }
}
