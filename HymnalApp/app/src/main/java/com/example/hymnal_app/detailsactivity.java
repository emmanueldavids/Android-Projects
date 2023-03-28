package com.example.hymnal_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class detailsactivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailsactivity);
        textView = findViewById(R.id.textt);

        String details = getIntent().getStringExtra("detail");
        textView.setText(details);
    }
}