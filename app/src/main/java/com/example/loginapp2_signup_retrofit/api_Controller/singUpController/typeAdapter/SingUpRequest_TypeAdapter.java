package com.example.loginapp2_signup_retrofit.api_Controller.singUpController.typeAdapter;

import com.example.loginapp2_signup_retrofit.api_Controller.singUpController.SingUpRequestController;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class SingUpRequest_TypeAdapter extends TypeAdapter<SingUpRequestController> {

    public SingUpRequest_TypeAdapter() {

    }

    @Override
    public void write(JsonWriter out, SingUpRequestController value) throws IOException {
        if (value == null) {
            out.nullValue();
            return;
        }
        out.beginObject();
        out.name("username").value(value.getUsername());
        out.name("email").value(value.getEmail());
        out.name("password").value(value.getPassword());
        out.endObject();
    }

    @Override
    public SingUpRequestController read(JsonReader in) throws IOException {
        throw new UnsupportedEncodingException("Deserialization of LoginRequest is not supported.");
    }


}
