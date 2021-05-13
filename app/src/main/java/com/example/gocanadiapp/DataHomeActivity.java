package com.example.gocanadiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DataHomeActivity extends AppCompatActivity {
private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_home);

        btn = findViewById(R.id.btn_map);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DataHomeActivity.this, GoogleMaps.class);
                startActivity(i);
            }
        });
    }
}