package com.example.regiandlogi;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private TextView emailT;
    private TextView passT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();

    }
    public void register(){
        emailT = findViewById(R.id.emailText);
        passT = findViewById(R.id.passwordText);

        String email = emailT.getText().toString();
        String password = passT.getText().toString();


        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this,"register success",Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(MainActivity.this,"register failed",Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    public void login(){

        emailT = findViewById(R.id.emailText);
        passT = findViewById(R.id.passwordText);

        String email = emailT.getText().toString();
        String password = passT.getText().toString();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this,"login success",Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(MainActivity.this,"login failed",Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}