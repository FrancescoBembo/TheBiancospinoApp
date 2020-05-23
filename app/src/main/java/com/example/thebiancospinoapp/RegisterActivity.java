package com.example.thebiancospinoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegisterActivity extends AppCompatActivity {

    Button RegisterBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        RegisterBtn = findViewById(R.id.RegisterBtn);

        RegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goToMainActivityIntent = new Intent(RegisterActivity.this, IntroActivity.class);

                startActivity(goToMainActivityIntent);

            }
        });


    }
}
