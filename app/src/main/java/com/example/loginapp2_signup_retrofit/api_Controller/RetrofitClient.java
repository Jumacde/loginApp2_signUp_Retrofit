package com.example.loginapp2_signup_retrofit.api_Controller;

import com.example.loginapp2_signup_retrofit.api_Controller.logInController.LogInRequestController;
import com.example.loginapp2_signup_retrofit.api_Controller.logInController.LogInResponseController;
import com.example.loginapp2_signup_retrofit.api_Controller.logInController.typeAdapter.LogInRequest_TypeAdapter;
import com.example.loginapp2_signup_retrofit.api_Controller.logInController.typeAdapter.LogInResponse_TypeAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit;
    // input "ipconfig" on cmd and input here IPv4 adresse.
    // "http://IPv4-Adresse:8080/ "
    private static String BASE_URL = "http://172.22.242.97:8080/";


    public RetrofitClient() {

    }



    public static AuthService getAuthService() {
        if (retrofit == null) {
            System.out.println("Base URL: " + BASE_URL);
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(LogInRequestController.class, new LogInRequest_TypeAdapter());
            gsonBuilder.registerTypeAdapter(LogInResponseController.class, new LogInResponse_TypeAdapter());
            Gson gson =  gsonBuilder.create();

            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
                    GsonConverterFactory.create(gson)
            ).build();
        }
        return retrofit.create(AuthService.class);
    }

}
