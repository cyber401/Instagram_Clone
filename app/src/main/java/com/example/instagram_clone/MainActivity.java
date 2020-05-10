package com.example.instagram_clone;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.ParseInstallation;
import com.shashank.sony.fancytoastlib.FancyToast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Save the current Installation to Back4App
        ParseInstallation.getCurrentInstallation().saveInBackground();
        textView=findViewById(R.id.textview);
        textView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        FancyToast.makeText(MainActivity.this,"you clicked TextView",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,true).show();
    }
}
