package com.example.registloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity {
    TextView message;

    FakeServer fakeServer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        message= findViewById(R.id.message);

        Intent intent = getIntent();
        fakeServer =  intent.getParcelableExtra("fakeServer");


    }
}
