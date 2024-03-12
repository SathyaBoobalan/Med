package com.example.myapplication6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class newold extends AppCompatActivity {

    private Button old,newer;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newold);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        getSupportActionBar().hide();
        getWindow().setNavigationBarColor(getResources().getColor(R.color.black));

        SharedPreferences preferences = getSharedPreferences("PREFERANCE",MODE_PRIVATE);
        String FirstTime = preferences.getString("FirstTimeInstall","");

        old = (Button) findViewById(R.id.exesisting);
        newer = (Button) findViewById(R.id.neweruser);

        old.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(FirstTime.equals("Yes")){
                    Intent intent =new Intent(newold.this,LoginActivity1.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }
                else {

                }

                SharedPreferences.Editor editor= preferences.edit();
                editor.putString("FirstTimeInstall","Yes");
                editor.apply();
            }
        });

        newer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(FirstTime.equals("Yes")){
                    Intent intent =new Intent(newold.this,RegisterActivity1.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }
                else {

                }

                SharedPreferences.Editor editor= preferences.edit();
                editor.putString("FirstTimeInstall","Yes");
                editor.apply();
            }
        });

    }
    protected void onStart() {
        super.onStart();
        overridePendingTransition(0, 0);
    }
}