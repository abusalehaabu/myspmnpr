package com.example.demo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class passwordservice {

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // Hash a password before saving it
    public String hashPassword(String password) {
        return passwordEncoder.encode(password);
    }

    // Compare hashed password with raw password
    public boolean checkPassword(String rawPassword, String hashedPassword) {
        return passwordEncoder.matches(rawPassword, hashedPassword);
    }
}

