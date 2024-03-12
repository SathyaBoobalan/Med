package com.example.myapplication6;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity1 extends AppCompatActivity {
    EditText username3, password3;
    Button signup3;
    String emailPattern = "[a-zA-z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;

    FirebaseAuth mAuth;
    FirebaseUser mUser;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        getSupportActionBar().hide();
        getWindow().setNavigationBarColor(getResources().getColor(R.color.black));

        username3 = (EditText) findViewById(R.id.username3);
        password3 = (EditText) findViewById(R.id.password3);
        signup3 = (Button) findViewById(R.id.signup3);
        progressDialog = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();



        String username=null;
        username =getIntent().getStringExtra("keyname");
        if(username!=null){
            mAuth.signOut();
            username=null;
            Intent inte = new Intent(LoginActivity1.this, MainActivity.class);
            startActivity(inte);
            finish();
        }


        signup3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perforLogin();
            }
        });

    }

    private void perforLogin() {
        String email1=username3.getText().toString();
        String password1=password3.getText().toString();

        if(!email1.matches(emailPattern))
        {
            username3.setError("Enter Connext Email");
        }
        else if(password1.isEmpty()||password1.length()<6)
        {
            password3.setError("Enter proper password");
        }
        else {
            progressDialog.setMessage("Please wait till login");
            progressDialog.setTitle("Login");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
            mAuth.signInWithEmailAndPassword(email1,password1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        progressDialog.dismiss();
                        finish();
                        //Intent intent0 = new Intent(LoginActivity1.this, MainActivity.class);
                        //intent0.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        //startActivity(intent0);
                        Toast.makeText(LoginActivity1.this, "Login Successfull ", Toast.LENGTH_SHORT).show();
                    }
                        else
                        {
                            progressDialog.dismiss();
                            Toast.makeText(LoginActivity1.this,"Login Unsucessfull",Toast.LENGTH_SHORT).show();

                        }

                    }
                });
            };
        }
    protected void onStart(){
        super.onStart();
        //overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
        }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
    }
}
