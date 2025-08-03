package com.example.loginapp2_signup_retrofit.api_Controller.logInController.typeAdapter;

import com.example.loginapp2_signup_retrofit.api_Controller.logInController.LogInRequestController;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/*
* convert to Json
* */
public class LogInRequest_TypeAdapter extends TypeAdapter<LogInRequestController> {

    public LogInRequest_TypeAdapter() {

    }

    @Override
    public void write(JsonWriter out, LogInRequestController value) throws IOException {
        if (value == null) {
            out.nullValue();
            return;
        }
        out.beginObject();
        out.name("email").value(value.getEmail());
        out.name("password").value(value.getPassword());
        out.endObject();
    }

    @Override
    public LogInRequestController read(JsonReader in) throws IOException {
         throw new UnsupportedEncodingException("Deserialization of LoginRequest is not supported.");
    }


}
