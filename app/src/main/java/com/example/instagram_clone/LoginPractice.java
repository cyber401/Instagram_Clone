package com.example.instagram_clone;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginPractice extends AppCompatActivity {
EditText userName,password;
Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_practice);
    login=findViewById(R.id.button);
    userName=findViewById(R.id.username);
    password=findViewById(R.id.password);
    }
}
