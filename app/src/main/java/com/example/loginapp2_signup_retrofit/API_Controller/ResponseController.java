package com.example.loginapp2_signup_retrofit.API_Controller;

public interface ResponseController {
    // getter
    String getToken();
    String getMessage();
    boolean getIsSuccess();

    // setter
    void setToken(String token);
    void setMessage(String message);
    void setIsSuccess(boolean isSuccess);

}
