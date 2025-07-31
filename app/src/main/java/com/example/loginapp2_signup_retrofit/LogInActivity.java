package com.example.loginapp2_signup_retrofit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LogInActivity extends AppCompatActivity {
    private Button b_in_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in_main);

        b_in_back = findViewById(R.id.b_in_back);
        setUpBackButton();
    }

    private void setUpBackButton() {
        b_in_back.setOnClickListener(new View.OnClickListener() {
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
