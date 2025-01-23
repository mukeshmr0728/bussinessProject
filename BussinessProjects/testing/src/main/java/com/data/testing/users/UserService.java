package com.data.testing.users;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;



    public ApiResponse createUser(User user) {

        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            return new ApiResponse(false, "A username is already exists!", null);
        }

        if (!userRepository.findByEmail(user.getEmail()).isEmpty()) {
            return new ApiResponse(false, "A user with this email already exists!", null);
        }

        User savedUser = userRepository.save(user);
        return new ApiResponse(true, "User registered successfully!", savedUser);
    }



    public User authenticateUser(String username, String password) {
        // Fetch the user by username
        Optional<User> user = userRepository.findByUsername(username);

        if (user.isEmpty()) {
            throw new IllegalArgumentException("User not found!");
        }

        // Validate password (in production, use hashed password comparison)
        if (!user.get().getPassword().equals(password)) {
            throw new IllegalArgumentException("Invalid password!");
        }

        return user.get();
    }

    public User readUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User updateUser(Long id, User updatedUser) {
        User existingUser = readUser(id);
        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setEmail(updatedUser.getEmail());
        return userRepository.save(existingUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

