package com.example.loginapp2_signup_retrofit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SingUpActivity extends AppCompatActivity {
    private Button b_up_back, b_up_submit;
    private EditText eT_Up_name, et_Up_email, et_Up_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sing_up_main);

        eT_Up_name = findViewById(R.id.et_Up_name);
        et_Up_email = findViewById(R.id.et_Up_email);
        et_Up_password = findViewById(R.id.et_Up_password);

        b_up_submit = findViewById(R.id.b_up_SingUp);

        b_up_back = findViewById(R.id.b_up_back);
        setUpBackButton();
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
