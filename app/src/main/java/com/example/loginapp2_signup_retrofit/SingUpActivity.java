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
import com.example.loginapp2_signup_retrofit.api_Controller.logInController.LogInResponseController;
import com.example.loginapp2_signup_retrofit.api_Controller.singUpController.SingUpRequestController;
import com.example.loginapp2_signup_retrofit.api_Controller.singUpController.impl.SingUpRequestController_impl;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SingUpActivity extends AppCompatActivity {
    private Button b_up_back, b_up_submit;
    private EditText eT_Up_name, et_Up_email, et_Up_password;

    private AuthService authService;

    private SingUpRequestController singUpRequestController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sing_up_main);

        eT_Up_name = findViewById(R.id.et_Up_name);
        et_Up_email = findViewById(R.id.et_Up_email);
        et_Up_password = findViewById(R.id.et_Up_password);

        b_up_submit = findViewById(R.id.b_up_SingUp);

        authService = RetrofitClient.getAuthService();

        b_up_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process_SingUp();
            }
        });

        b_up_back = findViewById(R.id.b_up_back);
        setUpBackButton();
    }

    private void process_SingUp() {
        String name = eT_Up_name.getText().toString().trim();
        String email = et_Up_email.getText().toString().trim();
        String password = et_Up_password.getText().toString().trim();

        if(name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Name, Email and password cannot be empty", Toast.LENGTH_SHORT).show();
            return;
        }

        singUpRequestController = new SingUpRequestController_impl();
        singUpRequestController.setUsername(name);
        singUpRequestController.setEmail(email);
        singUpRequestController.setPassword(password);

        Call<LogInResponseController> call = authService.singUpUser(singUpRequestController);
        call.enqueue(new Callback<LogInResponseController>() {
            @Override
            public void onResponse(Call<LogInResponseController> call,
                                   Response<LogInResponseController> response) {
                if (response.isSuccessful() && response.body() != null) {
                    LogInResponseController logInResponse = response.body();
                    if (logInResponse.getIsSuccess()) {
                        Toast.makeText(
                                SingUpActivity.this,
                                "Login Successful! Token: "
                                        + logInResponse.getToken(),
                                Toast.LENGTH_LONG).show();
                        Log.d("SingUpActivity", "Login successful, Token: "
                                + logInResponse.getToken());

                        Intent intent = new Intent(SingUpActivity.this, SuccessSingUp_Activity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(SingUpActivity.this, "Login Failed: " + logInResponse.getMessage(), Toast.LENGTH_LONG).show();
                        Log.e("MainActivity", "Login failed: " + logInResponse.getMessage());
                        Intent intent = new Intent(SingUpActivity.this, FailedSingUp_Activity.class);
                        startActivity(intent);
                        finish();
                    }
                } else {
                    try {
                        String error = response.errorBody() != null ? response.errorBody().string() : "Unknown error";
                        Toast.makeText(SingUpActivity.this, "Error: " + response.code() + " - " + error, Toast.LENGTH_LONG).show();
                        Log.e("SingUpActivity", "API Error: " + response.code() + " - " + error);
                        Intent intent = new Intent(SingUpActivity.this, FailedSingUp_Activity.class);
                        startActivity(intent);
                        finish();
                    } catch (Exception e) {
                        Toast.makeText(SingUpActivity.this, "Error parsing error response", Toast.LENGTH_SHORT).show();
                        Log.e("SingUpActivity", "Error parsing error response", e);
                        Intent intent = new Intent(SingUpActivity.this, FailedSingUp_Activity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            }

            @Override
            public void onFailure(Call<LogInResponseController> call, Throwable throwable) {
                Toast.makeText(SingUpActivity.this, "Network error: " + throwable.getMessage(), Toast.LENGTH_LONG).show();
                Log.e("SingUpActivity", "Network error during login", throwable);
                Intent intent = new Intent(SingUpActivity.this, FailedSingUp_Activity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void setUpBackButton() {
        b_up_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SingUpActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
