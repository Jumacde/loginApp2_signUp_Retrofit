package com.example.loginapp2_signup_retrofit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SuccessSingUp_Activity extends AppCompatActivity {
    private Button b_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.succcess_sing_up);

        b_back = findViewById(R.id.b_back_to_main);
        setUpBackButton();

    }

    private void setUpBackButton() {
        b_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SuccessSingUp_Activity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
