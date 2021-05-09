package com.example.gocanadiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
private FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        fAuth = FirebaseAuth.getInstance();
    }
        @Override
        protected void onStart() {
            super.onStart();
            FirebaseUser fUser = fAuth.getCurrentUser();
            if (fUser != null) { //login dulu
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                        finish();
                    }
                }, 3000L); //3000 L = 3 detik
            } else {
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                        finish();
                    }
                }, 3000L); //3000 L = 3 detik

            }
        }
}