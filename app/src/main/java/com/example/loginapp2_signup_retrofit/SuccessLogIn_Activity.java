package com.example.loginapp2_signup_retrofit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SuccessLogIn_Activity extends AppCompatActivity {
    private Button b_logOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.succcess_log_in);

        b_logOut = findViewById(R.id.b_logOut);
        setUpLogOut();

    }

    private void setUpLogOut() {
        b_logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SuccessLogIn_Activity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
