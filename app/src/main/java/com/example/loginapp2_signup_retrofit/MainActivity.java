package com.example.loginapp2_signup_retrofit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button b_logIn, b_singUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_logIn = findViewById(R.id.b_login);
        b_singUp = findViewById(R.id.b_singUp);

        setUpLogInButton();
        setUpSingUpButton();
    }

    private void setUpLogInButton() {
        b_logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        MainActivity.this, LogInActivity.class
                );
                startActivity(intent);
                finish();
            }
        });
    }

    private void setUpSingUpButton() {
        b_singUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        MainActivity.this, SingUpActivity.class
                );
                startActivity(intent);
                finish();
            }
        });
    }

}