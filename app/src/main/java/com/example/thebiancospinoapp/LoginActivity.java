package com.example.thebiancospinoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    Button loginButton;
    Button goRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton = findViewById(R.id.loginBtn);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goToMainActivityIntent = new Intent(LoginActivity.this, IntroActivity.class);

                startActivity(goToMainActivityIntent);

            }
        });


        //GO TO REGISTER PAGE

        goRegister = findViewById(R.id.goToRegistrationBtn);

        goRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goToRegistrationIntent = new Intent(LoginActivity.this, RegisterActivity.class);

                startActivity(goToRegistrationIntent);

            }
        });


    }
}
