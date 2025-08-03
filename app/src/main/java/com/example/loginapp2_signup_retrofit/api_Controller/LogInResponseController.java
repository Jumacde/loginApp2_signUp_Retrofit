package com.example.loginapp2_signup_retrofit.api_Controller;

public interface LogInResponseController {
    // getter
    String getToken();
    String getMessage();
    boolean getIsSuccess();

    // setter
    void setToken(String token);
    void setMessage(String message);
    void setIsSuccess(boolean isSuccess);

}
