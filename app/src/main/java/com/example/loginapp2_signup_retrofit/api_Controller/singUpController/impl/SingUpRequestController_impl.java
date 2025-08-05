package com.example.loginapp2_signup_retrofit.api_Controller.singUpController.impl;

import com.example.loginapp2_signup_retrofit.api_Controller.logInController.impl.LogInRequestController_impl;
import com.example.loginapp2_signup_retrofit.api_Controller.singUpController.SingUpRequestController;
import com.google.gson.annotations.SerializedName;

public class SingUpRequestController_impl
        extends LogInRequestController_impl
        implements SingUpRequestController {

    @SerializedName("username")
    private String username;

    public SingUpRequestController_impl() {
        super();
    }

    public SingUpRequestController_impl(String email, String password, String username) {
        super(email, password);
        this.username = username;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }
}
