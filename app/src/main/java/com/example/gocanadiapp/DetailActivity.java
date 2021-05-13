package com.example.gocanadiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.gocanadiapp.R;
import com.example.gocanadiapp.Candi;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_CANDI = "extra_candi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imageView = findViewById(R.id.img_detail);
        TextView name = findViewById(R.id.tv_name_detail);
        TextView description = findViewById(R.id.tv_desc_detail);
        TextView ordo = findViewById(R.id.tv_latitude_detail);
        TextView kelas = findViewById(R.id.tv_longitude_detail);

        Candi candi = getIntent().getParcelableExtra(EXTRA_CANDI);

        Glide.with(this).load(candi.getGambar()).into(imageView);
        name.setText(candi.getNama());
        description.setText(candi.getKeterangan());
        ordo.setText(candi.getLatitude());
        kelas.setText(candi.getLongitude());
    }
}