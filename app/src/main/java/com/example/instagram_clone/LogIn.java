package com.example.instagram_clone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogIn extends AppCompatActivity {
    private FirebaseAuth mAuth;
    TextInputEditText editText_email,editText_password;
    Button button_logIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        editText_email=findViewById(R.id.login_text_email);
        editText_password=findViewById(R.id.login_text_password);
        button_logIn=findViewById(R.id.button_login);
        mAuth = FirebaseAuth.getInstance();
        button_logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginAuthentication();
            }
        });

    }
    private void loginAuthentication(){
        mAuth.signInWithEmailAndPassword(editText_email.getText().
                toString(),editText_password.getText()
                .toString()).addOnCompleteListener(this,
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(LogIn.this, "Login successfull", Toast.LENGTH_SHORT).show();
                            Intent i=new Intent(LogIn.this,ProfileScreen.class);
                            startActivity(i);
                        }else{
                            Toast.makeText(LogIn.this, "Login fail", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
