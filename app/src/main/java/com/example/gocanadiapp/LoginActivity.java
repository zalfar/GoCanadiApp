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

public class LoginActivity extends AppCompatActivity {

    EditText email,pass;
    TextView register;
    Button login;
    FirebaseAuth fAuth;
//    private FirebaseAuth.AuthStateListener fState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        fAuth = FirebaseAuth.getInstance();

        email = findViewById(R.id.l_email);
        pass = findViewById(R.id.l_pass);
        login = findViewById(R.id.b_login);
        register = findViewById(R.id.register);

//        fState = new FirebaseAuth.AuthStateListener() {
//            @Override
//            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//                FirebaseUser fUser = fAuth.getCurrentUser();
//                if(fUser != null){
//                    Toast.makeText(LoginActivity.this, "Anda Berhasil Masuk", Toast.LENGTH_SHORT).show();
//                    Intent i = new Intent(LoginActivity.this, HomeActivity2.class);
//                    startActivity(i);
//                }else{
//                    Toast.makeText(LoginActivity.this, "Akun Anda Belum Terdaftar", Toast.LENGTH_SHORT).show();
//                }
//
//            }
//        };

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String eMail = email.getText().toString().trim();
                String password = pass.getText().toString().trim();

                if(eMail.isEmpty()){
                    email.setError("Isi Email Anda");
                    email.requestFocus();
                }
                if(password.isEmpty()){
                    pass.setError("Isi Password Anda");
                    pass.requestFocus();
                }
                if(password.isEmpty() && eMail.isEmpty()) {
                    pass.setError("Isi Password Anda");
                    email.setError("Isi Email Anda");
                    email.requestFocus();
                    pass.requestFocus();
                }
                if(!(eMail.isEmpty() && password.isEmpty())) {
                    fAuth.signInWithEmailAndPassword(eMail,password).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(LoginActivity.this, "Berhasil Login", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(LoginActivity.this, DataHomeActivity.class);
                                startActivity(i);
                            } else {
                                Toast.makeText(LoginActivity.this, "Terdapat Kesalahan" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }

            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });

    }
}