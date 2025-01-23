package com.data.testing.auth;

import com.data.testing.users.User;
import com.data.testing.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenProvider jwtTokenProvider; // Custom utility for JWT handling

    public String login(String username, String password) {

            System.out.println("Login attempt for username: " + username);

        Optional<User> user = userRepository.findByUsername(username);
            System.out.println("User found: " + user);



//            if (!user.getPassword().equals(password)) {
//                System.out.println("Password mismatch!");
//                throw new RuntimeException("Invalid username or password");
//            }
//
//            System.out.println("Password matches! Generating token...");
//            return jwtTokenProvider.generateToken(user.getUsername());
        return "hello";
        }


        public boolean validateToken(String token) {
        return jwtTokenProvider.validateToken(token);
    }

    public String getUsernameFromToken(String token) {
        return jwtTokenProvider.getUsernameFromToken(token);
    }
}
