package com.example.music_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LinearLayout SearchBtn = findViewById(R.id.searchBtn);
        final LinearLayout menuBtn = findViewById(R.id.menuBtn);
        final RecyclerView musicRecycleView = findViewById(R.id.musicRecycleView);
        final CardView playPauseCard = findViewById(R.id.playPauseCard);
        final ImageView playPauseImg = findViewById(R.id.playPauseImg);
        final ImageView nextBtn = findViewById(R.id.nextBtn);
        final ImageView prevBnt = findViewById(R.id.previousBnt);

        musicRecycleView.setHasFixedSize(true);
        musicRecycleView.setLayoutManager(new LinearLayoutManager(this));
    }
}