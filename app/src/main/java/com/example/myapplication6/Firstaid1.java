package com.example.myapplication6;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Firstaid1 extends AppCompatActivity {
    private Intent intent;

    private Button p1,p2,p3,p4,p5,p6,p7,p8,p9,p10;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstaid1);
        getSupportActionBar().hide();
        getWindow().setNavigationBarColor(getResources().getColor(R.color.black));


        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

        p1 = findViewById(R.id.p1Id);
        p2 = findViewById(R.id.p2Id);
        p3= findViewById(R.id.p3Id);
        p4 = findViewById(R.id.p4Id);
        p5 = findViewById(R.id.p5Id);
        p6 = findViewById(R.id.p6Id);
        p7 = findViewById(R.id.p7Id);
        p8 = findViewById(R.id.p8Id);
        p9 = findViewById(R.id.p9Id);
        p10 = findViewById(R.id.p10Id);

        p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Firstaid1.this, manualActivity1.class);
                intent.putExtra("name", "p1");
                startActivity(intent);

            }
        });
        p2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Firstaid1.this, manualActivity1.class);
                intent.putExtra("name", "p2");
                startActivity(intent);

            }
        });
        p3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Firstaid1.this, manualActivity1.class);
                intent.putExtra("name", "p3");
                startActivity(intent);

            }
        });
        p4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Firstaid1.this, manualActivity1.class);
                intent.putExtra("name", "p4");
                startActivity(intent);

            }
        });
        p5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Firstaid1.this, manualActivity1.class);
                intent.putExtra("name", "p5");
                startActivity(intent);

            }
        });
        p6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Firstaid1.this, manualActivity1.class);
                intent.putExtra("name", "p6");
                startActivity(intent);

            }
        });
        p7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Firstaid1.this, manualActivity1.class);
                intent.putExtra("name", "p7");
                startActivity(intent);

            }
        });
        p8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Firstaid1.this, manualActivity1.class);
                intent.putExtra("name", "p8");
                startActivity(intent);

            }
        });
        p9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Firstaid1.this, manualActivity1.class);
                intent.putExtra("name", "p9");
                startActivity(intent);

            }
        });
        p10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Firstaid1.this, manualActivity1.class);
                intent.putExtra("name", "p10");
                startActivity(intent);

            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
        finish();
    }
}

