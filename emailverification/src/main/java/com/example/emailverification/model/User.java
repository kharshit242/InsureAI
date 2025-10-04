package com.example.emailverification.model;

public class User {
    private String email;
    private boolean verified;

    public User(String email) {
        this.email = email;
        this.verified = false;
    }

    public String getEmail() { return email; }
    public boolean isVerified() { return verified; }
    public void setVerified(boolean verified) { this.verified = verified; }
}
