package com.example.myapplication6;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class manualActivity1 extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manualactivity1);
        getSupportActionBar().hide();
        getWindow().setNavigationBarColor(getResources().getColor(R.color.black));

        textView = findViewById(R.id.textView);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){

            String topicName = bundle.getString("name");
            showDetails(topicName);

        }

    }

    void showDetails(String topicName){

        if(topicName.equals("p1")){

            textView.setText(R.string.req);

        }
        if(topicName.equals("p2")){

            textView.setText(R.string.fev);

        }
        if(topicName.equals("p3")){

            textView.setText(R.string.cpr);

        }
        if(topicName.equals("p4")){

            textView.setText(R.string.b);

        }
        if(topicName.equals("p5")){

            textView.setText(R.string.ble);

        }
        if(topicName.equals("p6")){

            textView.setText(R.string.s);

        }
        if(topicName.equals("p7")){

            textView.setText(R.string.st);

        }
        if(topicName.equals("p8")){

            textView.setText(R.string.a);

        }
        if(topicName.equals("p9")){

            textView.setText(R.string.i);

        }
        if(topicName.equals("p10")){

            textView.setText(R.string.all);

        }

    }
}