package com.example.loginapp2_signup_retrofit;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button b_logIn;
    private TextView tv_singUp;
    private String singUpText;

    private FrameLayout singUpPage;

    private SpannableString spannableString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main),
                (v, insets) -> {
                    Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                    v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                    return insets;
                }

        );

        b_logIn = findViewById(R.id.b_login);

        tv_singUp = findViewById(R.id.tv_singUp);
        singUpText = getString(R.string.sing_up_text);
        singUpPage = findViewById(R.id.singUp_text_container);
        spannableString = new SpannableString(singUpText);

        setUpLogInButton();
        setUpSingUpLink();
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


    private void setUpSingUpLink() {
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Intent intent = new Intent(MainActivity.this, SingUpActivity.class);
                startActivity(intent);
                finish();
            }
        };
        // set clickable string on the TextView
        String clickIndex = "sing up";
        int singUP_startIndex = singUpText.indexOf(clickIndex);
        if (singUP_startIndex != -1) {
            spannableString.setSpan(
                    clickableSpan,
                    singUP_startIndex,
                    singUP_startIndex + clickIndex.length(),
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            );
        }
        tv_singUp.setText(spannableString);
        tv_singUp.setMovementMethod(LinkMovementMethod.getInstance());

    }
}