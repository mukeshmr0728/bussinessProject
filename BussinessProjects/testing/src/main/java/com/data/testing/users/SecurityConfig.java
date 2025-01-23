package com.data.testing.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SecurityConfig {

    @Autowired
    private UserService userService;

    public PasswordEncoder passwordEncoder(){
        return passwordEncoder();
    }
}
