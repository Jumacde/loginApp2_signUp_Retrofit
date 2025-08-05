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
                    LogInResponseController loginResponse = response.body();
                    if (loginResponse.getIsSuccess()) {
                        Toast.makeText(
                                LogInActivity.this,
                                "Login Successful! Token: "
                                        + loginResponse.getToken(),
                                Toast.LENGTH_LONG).show();
                        Log.d("MainActivity", "Login successful, Token: "
                                + loginResponse.getToken());

                        Intent intent = new Intent(LogInActivity.this, SuccessLogIn_Activity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(LogInActivity.this, "Login Failed: " + loginResponse.getMessage(), Toast.LENGTH_LONG).show();
                        Log.e("MainActivity", "Login failed: " + loginResponse.getMessage());
                        Intent intent = new Intent(LogInActivity.this, FailedLogIn_Activity.class);
                        startActivity(intent);
                        finish();
                    }
                } else {
                    try {
                        String error = response.errorBody() != null ? response.errorBody().string() : "Unknown error";
                        Toast.makeText(LogInActivity.this, "Error: " + response.code() + " - " + error, Toast.LENGTH_LONG).show();
                        Log.e("LogInActivity", "API Error: " + response.code() + " - " + error);
                        Intent intent = new Intent(LogInActivity.this, FailedLogIn_Activity.class);
                        startActivity(intent);
                        finish();
                    } catch (Exception e) {
                        Toast.makeText(LogInActivity.this, "Error parsing error response", Toast.LENGTH_SHORT).show();
                        Log.e("LogInActivity", "Error parsing error response", e);
                        Intent intent = new Intent(LogInActivity.this, FailedLogIn_Activity.class);
                        startActivity(intent);
                        finish();
                    }

                }
            }

            @Override
            public void onFailure(Call<LogInResponseController> call, Throwable throwable) {
                Toast.makeText(LogInActivity.this, "Network error: " + throwable.getMessage(), Toast.LENGTH_LONG).show();
                Log.e("LogInActivity", "Network error during login", throwable);
                Intent intent = new Intent(LogInActivity.this, FailedLogIn_Activity.class);
                startActivity(intent);
                finish();
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
