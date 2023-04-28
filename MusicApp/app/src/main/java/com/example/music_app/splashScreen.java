package com.example.music_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.window.SplashScreen;

public class splashScreen extends AppCompatActivity {
    private static int SPLASH_SCREEN = 2500;
    ImageView imageView;
    TextView textView1, textView2;
    Animation top, buttom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        imageView = findViewById(R.id.imageView);
        textView1 = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);

        top = AnimationUtils.loadAnimation(this, R.anim.top);
        buttom = AnimationUtils.loadAnimation(this, R.anim.buttom);

        imageView.setAnimation(top);
        textView1.setAnimation(buttom);
        textView2.setAnimation(buttom);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(splashScreen.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_SCREEN);

        //new Handler().postDelayed(() -> {
        //     startActivity(new Intent(splashScreen.this,MainActivity.class));
        //     finish();
        // },2000);
    }
}