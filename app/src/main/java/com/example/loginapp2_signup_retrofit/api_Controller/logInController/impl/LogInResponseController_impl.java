package com.example.loginapp2_signup_retrofit.api_Controller.logInController.impl;

import com.example.loginapp2_signup_retrofit.api_Controller.logInController.LogInResponseController;
import com.google.gson.annotations.SerializedName;

public class LogInResponseController_impl implements LogInResponseController {
    @SerializedName("token")
    private String token; // Authentication token
    @SerializedName("message")
    private String message;
    @SerializedName("isSuccess")
    private boolean isSuccess;

    public LogInResponseController_impl() {

    }

    public LogInResponseController_impl(String token, String message, boolean isSuccess) {
        this.token = token;
        this.message = message;
        this.isSuccess = isSuccess;
    }

    @Override
    public String getToken() {
        return token;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public boolean getIsSuccess() {
        return isSuccess;
    }

    @Override
    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }


}
