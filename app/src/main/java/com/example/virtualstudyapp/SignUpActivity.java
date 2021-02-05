package com.example.virtualstudyapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

        FirebaseAuth auth;
        EditText emailBox, passwordBox, nameBox;
        Button loginBtn, signupBtn;


    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_sign_up);
            auth = FirebaseAuth.getInstance();

            emailBox = findViewById(R.id.emailBox);
            nameBox = findViewById(R.id.nameBox);
            passwordBox = findViewById(R.id.passwordBox);

            loginBtn = findViewById(R.id.signUpBtn);
            signupBtn = findViewById(R.id.signUpBtn);


            signupBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String email, pass, name;
                    email = emailBox.getText().toString();
                    pass = passwordBox.getText().toString();
                    name = nameBox.getText().toString();
                    auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(SignUpActivity.this, "Account created." , Toast.LENGTH_SHORT ).show();

                            } else {
                                Toast.makeText(SignUpActivity.this,task.getException() .getLocalizedMessage(), Toast.LENGTH_SHORT ).show();


                            }
                        }
                    });

                }
            });
        }
    }