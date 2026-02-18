package com.javaApp.App;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestEncoder {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        // Paste ONE password hash from your DB here
        String storedHash = "$2a$10$F8pO6fjCGTLvZg4ZzpsQiOY89EteMQ0a6G5wHfoS/LQfsRWHzey6S";

        // Try passwords you think you used
        String[] candidates = {
                "admin123",
                "admin12",
                "admin",
                "password",
                "Admin123!",
                "admin1234"
        };

        for (String pw : candidates) {
            boolean matches = encoder.matches(pw, storedHash);
            System.out.printf("'%s' matches? %b%n", pw, matches);
        }
    }
}



