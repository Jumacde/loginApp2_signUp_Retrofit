package com.example.loginapp2_signup_retrofit.API_Controller;

public interface LogInRequestController {
    // getter
    String getEmail();
    String getPassword();

    // setter
    void setEmail(String email);
    void setPassword(String password);
}
