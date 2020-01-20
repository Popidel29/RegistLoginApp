package com.example.registloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        btn_register = findViewById(R.id.btn_register);


        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (user.isEmpty() && pass.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "User or password empty", Toast.LENGTH_LONG).show();
                } else {
                    FakeServer fakeServer = new FakeServer();
                    fakeServer.registerUser("username", "password");


                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    intent.putExtra("fakeServer", fakeServer);
                    startActivity(intent);

                }
            }

        });


    }
}
