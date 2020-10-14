package com.example.registloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText username2;
    private EditText password2;
    private Button btn_login;
    FakeServer fakeServer;
    public  static final String USER_KEY="welcome";

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
                String user = username2.getText().toString();
                String pass = password2.getText().toString();
                boolean checking = fakeServer.isExistingUser(username2.getText().toString(), password2.getText().toString());
                boolean empty =user.isEmpty() && pass.isEmpty();
                if (checking) {


                    Intent goToWelcome = new Intent(LoginActivity.this, WelcomeActivity.class);
                    goToWelcome.putExtra(USER_KEY, username2.getText().toString());
                    startActivity(goToWelcome);


                   // Toast.makeText(LoginActivity.this, "Welcome " + username2.getText(), Toast.LENGTH_LONG).show();

                }
                else if(empty){
                    Toast.makeText(LoginActivity.this, "User or password can't be empty", Toast.LENGTH_LONG).show();
                }
                else  {
                    Toast.makeText(LoginActivity.this, "User or password wrong!", Toast.LENGTH_LONG).show();
                }

            }

        });
    }
}
