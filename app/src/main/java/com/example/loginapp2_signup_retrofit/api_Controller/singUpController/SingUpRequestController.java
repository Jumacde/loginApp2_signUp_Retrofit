package com.example.loginapp2_signup_retrofit.api_Controller.singUpController;

import com.example.loginapp2_signup_retrofit.api_Controller.logInController.LogInRequestController;

public interface SingUpRequestController extends LogInRequestController {
    // getter
    String getUsername();

    // setter
    void setUsername(String username);
}
