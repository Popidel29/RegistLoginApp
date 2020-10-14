package com.example.registloginapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {
    TextView message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        message= findViewById(R.id.welcome);

        Intent intent = getIntent();

        String username3=intent.getStringExtra(LoginActivity.USER_KEY);

        message.setText(getString(R.string.welcome_message, username3));
        //preferences.getString(PREFS_PASSWORD,"");

    }
}
