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

public class m555 extends AppCompatActivity {
    private static final String SHARED_PREF_NAME6 ="mypref6";
    private static final String KEY_NAME6 ="name6";
    private static final String KEY_EMAIL6 ="email6";
    EditText editText_name,editText_email;
    Button save;
    SharedPreferences sharedPreferences6;
    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m555);
        getSupportActionBar().hide();
        getWindow().setNavigationBarColor(getResources().getColor(R.color.black));
        editText_name=findViewById(R.id.editText_name51);
        editText_email=findViewById(R.id.editText_email51);
        save=findViewById(R.id.Save51);

        sharedPreferences6= getSharedPreferences(SHARED_PREF_NAME6,MODE_PRIVATE);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor=sharedPreferences6.edit();
                editor.putString(KEY_NAME6,editText_name.getText().toString());
                editor.putString(KEY_EMAIL6,editText_email.getText().toString());
                editor.apply();
                String name = sharedPreferences6.getString(KEY_NAME6,null);
                String email = sharedPreferences6.getString(KEY_EMAIL6,null);
                if (name.length()<1 && email.length()<1){
                    Toast.makeText(m555.this,"Title and Prescription is not yet filled",Toast.LENGTH_SHORT).show();
                }
                else if (name.length()<1){
                    Toast.makeText(m555.this,"Title is not yet filled",Toast.LENGTH_SHORT).show();
                }
                else if (email.length()<1){
                    Toast.makeText(m555.this,"Prescription is not yet filled",Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent inte = new Intent(m555.this, Myprefs2.class);
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
        SharedPreferences.Editor editor = sharedPreferences6.edit();
        editor.clear();
        editor.commit();
        finish();
    }
}