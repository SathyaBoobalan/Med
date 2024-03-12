package com.example.myapplication6;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class m544 extends AppCompatActivity {
    private static final String SHARED_PREF_NAME5 ="mypref5";
    private static final String KEY_NAME5 ="name5";
    private static final String KEY_EMAIL5 ="email5";
    EditText editText_name,editText_email;
    Button save;
    SharedPreferences sharedPreferences5;
    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m544);
        getSupportActionBar().hide();
        getWindow().setNavigationBarColor(getResources().getColor(R.color.black));
        editText_name=findViewById(R.id.editText_name51);
        editText_email=findViewById(R.id.editText_email51);
        save=findViewById(R.id.Save51);

        sharedPreferences5= getSharedPreferences(SHARED_PREF_NAME5,MODE_PRIVATE);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor=sharedPreferences5.edit();
                editor.putString(KEY_NAME5,editText_name.getText().toString());
                editor.putString(KEY_EMAIL5,editText_email.getText().toString());
                editor.apply();
                String name = sharedPreferences5.getString(KEY_NAME5,null);
                String email = sharedPreferences5.getString(KEY_EMAIL5,null);
                if (name.length()<1 && email.length()<1){
                    Toast.makeText(m544.this,"Title and Prescription is not yet filled",Toast.LENGTH_SHORT).show();
                }
                else if (name.length()<1){
                    Toast.makeText(m544.this,"Title is not yet filled",Toast.LENGTH_SHORT).show();
                }
                else if (email.length()<1){
                    Toast.makeText(m544.this,"Prescription is not yet filled",Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent inte = new Intent(m544.this, Myprefs2.class);
                    inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(inte);
                    inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                }
            }
        });
    }

    protected void onStart() {
        super.onStart();
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        SharedPreferences.Editor editor = sharedPreferences5.edit();
        editor.clear();
        editor.commit();
        finish();
    }
}