package com.example.loginapp2_signup_retrofit.api_Controller;

import retrofit2.Retrofit;

public class RetrofitClient {
    private static Retrofit retrofit;
    // input "ipconfig" on cmd and input here IPv4 adresse.
    // "http://IPv4-Adresse:8080/ "
    private String BASE_URL = "http://172.22.243.244:8080/";


    public RetrofitClient() {

    }

}
