package com.example.loginapp2_signup_retrofit.API_Controller.impl;

import com.example.loginapp2_signup_retrofit.API_Controller.ResponseController;
import com.google.gson.annotations.SerializedName;

public class ResponseController_impl implements ResponseController {
    @SerializedName("token")
    private String token; // Authentication token
    @SerializedName("message")
    private String message;
    @SerializedName("isSuccess")
    private boolean isSuccess;

    public ResponseController_impl() {

    }

    public ResponseController_impl(String token, String message, boolean isSuccess) {
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
