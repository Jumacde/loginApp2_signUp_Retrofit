package com.example.loginapp2_signup_retrofit.API_Controller.impl;

import com.example.loginapp2_signup_retrofit.API_Controller.RequestController;
import com.google.gson.annotations.SerializedName;

public class RequestController_impl implements RequestController {
    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String password;

    public RequestController_impl(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }
}
