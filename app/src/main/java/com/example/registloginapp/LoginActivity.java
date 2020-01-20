package com.example.registloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText username2;
    EditText password2;
    Button btn_login;
    FakeServer fakeServer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username2 = findViewById(R.id.username2);
        password2 = findViewById(R.id.password2);
        btn_login = findViewById(R.id.btn_login);

        Intent intent = getIntent();
        fakeServer = intent.getParcelableExtra("fakeServer");




        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               boolean checking= fakeServer.isExistingUser(username2.getText().toString(),password2.getText().toString());

               if(checking) {


                   Intent intent = new Intent(LoginActivity.this, WelcomeActivity.class);
                   startActivity(intent);
                   Toast.makeText(LoginActivity.this, "Welcome " + username2.getText(), Toast.LENGTH_LONG).show();

               }
               else{
                   Toast.makeText(LoginActivity.this, "User or password wrong!", Toast.LENGTH_LONG).show();
               }
            }
        });
    }
}
