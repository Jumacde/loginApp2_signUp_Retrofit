package com.example.loginapp2_signup_retrofit.API_Controller;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthService {
    @POST("/api/auth/logIn")
    Call<LogInResponseController> logInUser(@Body LogInRequestController logInRequestController);
    @POST("api/auth/singUp")
    Call<LogInResponseController> singUpUser(@Body LogInRequestController logInRequestController);
}
