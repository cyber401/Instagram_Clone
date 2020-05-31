package com.example.instagram_clone;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView instagram, name;
    private ImageView insta_image;
    private Animation top_anim, bottom_anim, fade;
private static int SPLASH=2500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        instagram = findViewById(R.id.instagram);
        name = findViewById(R.id.name);
        insta_image = findViewById(R.id.insta_image);
        top_anim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottom_anim = AnimationUtils.loadAnimation(this, R.anim.down_animation);
        fade = AnimationUtils.loadAnimation(this, R.anim.fade_animation);
        instagram.setAnimation(top_anim);
        insta_image.setAnimation(bottom_anim);
        name.setAnimation(fade);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, SignUp.class);
                Pair[] pair=new Pair[2];
                pair[0]=new Pair<View,String>(insta_image,"image_transition");
                pair[1]=new Pair<View,String>(instagram,"text_transition");
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pair);
                startActivity(intent, options.toBundle());
            }
        }, SPLASH);
    }
}
