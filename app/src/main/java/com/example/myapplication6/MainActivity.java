package com.example.myapplication6;

import static android.provider.Telephony.Mms.Part.TEXT;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication6.Firstaid1;
import com.example.myapplication6.LoginActivity1;
import com.example.myapplication6.Myprefs2;
import com.example.myapplication6.R;
import com.example.myapplication6.RegisterActivity1;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences,sharedPreferences2,sharedPreferences3,sharedPreferences4,sharedPreferences5,sharedPreferences6;

    private static final String SHARED_PREF_NAME ="mypref";
    private static final String KEY_NAME ="name";
    private static final String SHARED_PREF_NAME2 ="mypref2";
    private static final String KEY_NAME2 ="name2";
    private static final String SHARED_PREF_NAME3 ="mypref3";
    private static final String KEY_NAME3 ="name3";
    private static final String SHARED_PREF_NAME4 ="mypref4";
    private static final String KEY_NAME4 ="name4";
    private static final String SHARED_PREF_NAME5 ="mypref5";
    private static final String KEY_NAME5 ="name5";
    private static final String SHARED_PREF_NAME6 ="mypref6";
    private static final String KEY_NAME6 ="name6";


    private Button Exit;
    private Button b1;
    private Button button;
    private Button add;
    private Button button2;
    private Intent inte;
    private Intent intent1;

    boolean doubleTapToExit =false;
    final int duration =2000;
    View view;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        getSupportActionBar().hide();
        getWindow().setNavigationBarColor(getResources().getColor(R.color.black));

        sharedPreferences =getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        sharedPreferences2 =getSharedPreferences(SHARED_PREF_NAME2,MODE_PRIVATE);
        sharedPreferences3 =getSharedPreferences(SHARED_PREF_NAME3,MODE_PRIVATE);
        sharedPreferences4 =getSharedPreferences(SHARED_PREF_NAME4,MODE_PRIVATE);
        sharedPreferences5 =getSharedPreferences(SHARED_PREF_NAME5,MODE_PRIVATE);
        sharedPreferences6 =getSharedPreferences(SHARED_PREF_NAME6,MODE_PRIVATE);

        view = findViewById(android.R.id.content);

        Exit=(Button)findViewById(R.id.Exit);
        button2=(Button)findViewById(R.id.button2);
        add=(Button)findViewById(R.id.add);
        b1= (Button) findViewById(R.id.b1);
        button= (Button)findViewById(R.id.button);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();

                SharedPreferences.Editor editor2 = sharedPreferences2.edit();
                editor2.clear();
                editor2.commit();

                SharedPreferences.Editor editor3 = sharedPreferences3.edit();
                editor3.clear();
                editor3.commit();

                SharedPreferences.Editor editor4 = sharedPreferences4.edit();
                editor4.clear();
                editor4.commit();

                SharedPreferences.Editor editor5 = sharedPreferences5.edit();
                editor5.clear();
                editor5.commit();

                SharedPreferences.Editor editor6 = sharedPreferences6.edit();
                editor6.clear();
                editor6.commit();

                String username ="name";
                inte = new Intent(MainActivity.this, LoginActivity1.class);
                inte.putExtra("keyname",username);
                inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(inte);
                /*moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);*/
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                inte =new Intent(MainActivity.this, Firstaid1.class);
                inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(inte);
                inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inte =new Intent(MainActivity.this, Myprefs2.class);
                inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(inte);
                inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent inte =new Intent(MainActivity.this,MainActivity4.class);
                inte=new Intent(MainActivity.this, RegisterActivity1.class);
                inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(inte);
                inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            }
        });

        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });

    }
    protected void onStart() {
        super.onStart();
        intent1= new Intent(MainActivity.this, RegisterActivity1.class);
        intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent1);
    }

    @Override
    public void onBackPressed(){
        MainActivity.this.finishAffinity();
    }
}

