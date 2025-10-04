package com.example.emailverification.controller;

import com.example.emailverification.model.User;
import com.example.emailverification.service.EmailService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class UserController {

    private Map<String, User> users = new HashMap<>();
    private Map<String, String> verificationTokens = new HashMap<>();

    private final EmailService emailService;

    public UserController(EmailService emailService) {
        this.emailService = emailService;
    }

    // Use GET for browser testing
    @GetMapping("/register")
    public String register(@RequestParam String email) {
        if (users.containsKey(email)) return "Email already registered!";

        User user = new User(email);
        users.put(email, user);

        String token = UUID.randomUUID().toString();
        verificationTokens.put(token, email);

        emailService.sendVerificationEmail(email, token);
        return "Verification email sent to " + email + "<br>" +
               "Check your email and click the link to verify.";
    }

    @GetMapping("/verify")
    public String verify(@RequestParam String token) {
        if (!verificationTokens.containsKey(token)) return "Invalid token!";
        String email = verificationTokens.get(token);

        User user = users.get(email);
        user.setVerified(true);
        verificationTokens.remove(token);

        return "Email verified successfully for " + email;
    }

    // Optional: Show all users and their status (for testing)
    @GetMapping("/users")
    public String allUsers() {
        StringBuilder sb = new StringBuilder();
        sb.append("<h2>Users:</h2>");
        users.forEach((email, user) -> {
            sb.append(email)
              .append(" - Verified: ")
              .append(user.isVerified())
              .append("<br>");
        });
        return sb.toString();
    }
}
