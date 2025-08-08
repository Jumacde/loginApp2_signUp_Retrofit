package com.example.loginapp2_signup_retrofit.api_Controller.logInController.typeAdapter;

import com.example.loginapp2_signup_retrofit.api_Controller.logInController.LogInResponseController;
import com.example.loginapp2_signup_retrofit.api_Controller.logInController.impl.LogInResponseController_impl;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.JsonToken;
import java.io.IOException;

/*
 * convert to Json
 * */
public class LogInResponse_TypeAdapter extends TypeAdapter<LogInResponseController> {

    public LogInResponse_TypeAdapter() {
    }

    @Override
    public void write(JsonWriter out, LogInResponseController value) throws IOException {
        if (value == null) {
            out.nullValue();
            return;
        }
        out.beginObject();
        out.name("token").value(value.getToken());
        out.name("message").value(value.getMessage());
        out.name("isSuccess").value(value.getIsSuccess());
        out.endObject();
    }

    @Override
    public LogInResponseController read(JsonReader in) throws IOException {
        LogInResponseController responseController = new LogInResponseController_impl();

        in.beginObject();
        while (in.hasNext()) {
            String name = in.nextName();
            if (name.equals("token")) {
                if (in.peek() == JsonToken.NULL) {
                    in.nextNull();
                    responseController.setToken(null);
                } else {
                    responseController.setToken(in.nextString());
                }
            } else if (name.equals("message")) {
                if (in.peek() == JsonToken.NULL) {
                    in.nextNull();
                    responseController.setMessage(null);
                } else {
                    responseController.setMessage(in.nextString());
                }
            } else if (name.equals("isSuccess")) {
                if (in.peek() == JsonToken.NULL) {
                    in.nextNull();
                    // isSuccessがnullの場合、booleanのデフォルト値falseを設定
                    responseController.setIsSuccess(false);
                } else {
                    responseController.setIsSuccess(in.nextBoolean());
                }
            } else {
                in.skipValue();
            }
        }
        in.endObject();
        return responseController;
    }
}