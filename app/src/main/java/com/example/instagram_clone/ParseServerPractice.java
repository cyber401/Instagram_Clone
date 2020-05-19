package com.example.instagram_clone;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

import java.util.List;

public class ParseServerPractice extends AppCompatActivity implements View.OnClickListener {
EditText editText;
Button button, button2;
TextView textView;
ParseObject person_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parse_practice);
        // Save the current Installation to Back4App
        ParseInstallation.getCurrentInstallation().saveInBackground();
        editText=findViewById(R.id.editText);
        button=findViewById(R.id.button);
        button.setOnClickListener(this);
        person_name=new ParseObject("Person_Name");
        textView=findViewById(R.id.textView);
        button2=findViewById(R.id.pull_data);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                person_name.put("name",editText.getText().toString());
                person_name.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if(e==null){
                            FancyToast.makeText(ParseServerPractice.this,"Perfectly Saved...",FancyToast.LENGTH_SHORT,FancyToast.SUCCESS,true).show();
                        }else{
                            FancyToast.makeText(ParseServerPractice.this,e+"",FancyToast.LENGTH_SHORT,FancyToast.ERROR,true).show();
                        }
                    }
                });
                break;
            case R.id.pull_data:
                ParseQuery<ParseObject> lalit= ParseQuery.getQuery("Person_Name");
                lalit.findInBackground(new FindCallback<ParseObject>() {
                    @Override
                    public void done(List<ParseObject> objects, ParseException e) {
                        String collect="";
                        if(objects.size()>0 && e==null){
                            for(ParseObject name:objects){
                                collect=collect+name.get("name")+"\n";
                            }
                            textView.setText(collect);
                        }
                    }
                });
//                lalit.getInBackground("omHufOHHQr", new GetCallback<ParseObject>() {
//                    @Override
//                    public void done(ParseObject object, ParseException e) {
//                        if(object!=null && e==null){
//                            textView.setText(object.get("name").toString());
//                            FancyToast.makeText(MainActivity.this,"Data is sucessfully fetched",FancyToast.LENGTH_SHORT,FancyToast.SUCCESS,false).show();
//                        }else{
//                            FancyToast.makeText(MainActivity.this,e+"",FancyToast.LENGTH_SHORT,FancyToast.ERROR,false).show();
//                        }
//                    }
//                });
                break;
            }

        }


    }
