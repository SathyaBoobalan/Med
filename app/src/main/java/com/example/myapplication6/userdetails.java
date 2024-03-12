package com.example.myapplication6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class userdetails extends AppCompatActivity {
    EditText t1,t2,t3;
    Button b1;
    FirebaseFirestore db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userdetails);

        db= FirebaseFirestore.getInstance();

        t1 = (EditText) findViewById(R.id.editTextText);
        t2 = (EditText) findViewById(R.id.editTextPhone);
        t3 = (EditText) findViewById(R.id.editTextDate);
        b1= (Button) findViewById(R.id.signup2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String,Object> user1 = new HashMap<>();
                user1.put("Name",t1);
                user1.put("Phone Number",t2);
                user1.put("Date Of Birth",t3);
                db.collection("user new").add(user1).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {

                    }
                });
            }
        });

    }
}