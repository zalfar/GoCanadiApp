package com.example.gocanadiapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    EditText username,pass,email;
    Button back, register;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fAuth = FirebaseAuth.getInstance();

        username = findViewById(R.id.r_name);
        pass = findViewById(R.id.r_pass);
        email = findViewById(R.id.r_email);
        register = findViewById(R.id.b_register);
        back = findViewById(R.id.back);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String eMail = email.getText().toString().trim();
                String password = pass.getText().toString().trim();
                String userName = username.getText().toString().trim();

                if(eMail.isEmpty()){
                    email.setError("Isi Email Anda");
                    email.requestFocus();
                }
                if(password.isEmpty()){
                    pass.setError("Isi Password Anda");
                    pass.requestFocus();
                }
                if(userName.isEmpty()){
                    username.setError("Isi Username Anda");
                    username.requestFocus();
                }
                if(password.isEmpty() && eMail.isEmpty() && userName.isEmpty()) {
                    pass.setError("Isi Password Anda");
                    email.setError("Isi Email Anda");
                    username.setError("Isi Username Anda");
                    username.requestFocus();
                    email.requestFocus();
                    pass.requestFocus();
                }
                if(!(eMail.isEmpty() && password.isEmpty() && userName.isEmpty()) ) {
                    fAuth.createUserWithEmailAndPassword(eMail, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(RegisterActivity.this, "Akun Berhasil Dibuat. Kembali ke Login", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(RegisterActivity.this, "Terdapat Kesalahan" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}