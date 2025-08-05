package com.example.loginapp2_signup_retrofit;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.loginapp2_signup_retrofit.api_Controller.AuthService;
import com.example.loginapp2_signup_retrofit.api_Controller.RetrofitClient;
import com.example.loginapp2_signup_retrofit.api_Controller.logInController.LogInRequestController;
import com.example.loginapp2_signup_retrofit.api_Controller.logInController.LogInResponseController;
import com.example.loginapp2_signup_retrofit.api_Controller.logInController.impl.LogInRequestController_impl;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LogInActivity extends AppCompatActivity {
    private Button b_back, b_submit;
    private EditText et_email, et_password;

    private LogInRequestController logInRequestController;

    private AuthService authService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in_main);

        et_email = findViewById(R.id.et_In_email);
        et_password = findViewById(R.id.et_In_password);

        b_submit = findViewById(R.id.b_in_submit);
        authService = RetrofitClient.getAuthService();

        b_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processLogIn();
            }
        });

        b_back = findViewById(R.id.b_in_back);
        setUpBackButton();
    }

    private void processLogIn() {
        String email = et_email.getText().toString().trim();
        String password = et_password.getText().toString().trim();

        if(email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Email and password cannot be empty", Toast.LENGTH_SHORT).show();
            return;
        }

        logInRequestController = new LogInRequestController_impl();
        logInRequestController.setEmail(email);
        logInRequestController.setPassword(password);

        Call<LogInResponseController> call = authService.logInUser(logInRequestController);
        call.enqueue(new Callback<LogInResponseController>() {
            @Override
            public void onResponse(Call<LogInResponseController> call, Response<LogInResponseController> response) {
                if (response.isSuccessful() && response.body() != null) {
                    LogInResponseController logInRequestController = response.body();
                    if (logInRequestController.getIsSuccess()) {
                        Toast.makeText(
                                LogInActivity.this,
                                "Login Successful! Token: "
                                        + logInRequestController.getToken(),
                                Toast.LENGTH_LONG).show();
                        Log.d("MainActivity", "Login successful, Token: "
                                + logInRequestController.getToken());

                        Intent intent = new Intent(LogInActivity.this, );
                    }

                }
            }

            @Override
            public void onFailure(Call<LogInResponseController> call, Throwable throwable) {

            }
        });

    }

    private void setUpBackButton() {
        b_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        LogInActivity.this, MainActivity.class
                );
                startActivity(intent);
                finish();
            }
        });

    }
}
