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
import com.google.firebase.auth.FirebaseUser;

public class SignUp extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth mAuth;
    TextInputEditText editText_email,editText_password;
    Button button_signUp,button_alreadyhaveaccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        editText_email=findViewById(R.id.edit_text_email);
        editText_password=findViewById(R.id.edit_text_password);
        button_signUp=findViewById(R.id.button_signup);
        button_alreadyhaveaccount=findViewById(R.id.button_alreadyhaveaccount);
        mAuth = FirebaseAuth.getInstance();
        button_alreadyhaveaccount.setOnClickListener(this);
        button_signUp.setOnClickListener(this);

    }
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();

    }
    private void authentication(){
        mAuth.createUserWithEmailAndPassword(editText_email.getText().
                toString(),editText_password.getText()
                .toString()).addOnCompleteListener(this,
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(SignUp.this, "SignUp complete", Toast.LENGTH_SHORT).show();
                            Intent i=new Intent(SignUp.this,LogIn.class);
                            startActivity(i);
                            finish();
                        }else{
                            Toast.makeText(SignUp.this, "SignUp fail", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_signup:
                authentication();
                break;
            case R.id.button_alreadyhaveaccount:
                Intent i=new Intent(SignUp.this,LogIn.class);
                startActivity(i);
                finish();
                break;

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
         finish();
          }
}
