package com.example.loginapp2_signup_retrofit.API_Controller.impl;

import com.example.loginapp2_signup_retrofit.API_Controller.LogInResponseController;
import com.google.gson.annotations.SerializedName;

public class LogInLogInResponseController_impl implements LogInResponseController {
    @SerializedName("token")
    private String token; // Authentication token
    @SerializedName("message")
    private String message;
    @SerializedName("isSuccess")
    private boolean isSuccess;

    public LogInLogInResponseController_impl() {

    }

    public LogInLogInResponseController_impl(String token, String message, boolean isSuccess) {
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
