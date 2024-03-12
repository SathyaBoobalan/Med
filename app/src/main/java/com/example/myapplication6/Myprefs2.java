package com.example.myapplication6;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Myprefs2 extends AppCompatActivity {
    private Button myprefsB,myprefsB6,myprefsB2,myprefsB3,myprefsB4,myprefsB5;
    private Button see,del,see6,del6,see2,del2,see3,del3,see4,del4,see5,del5;
    private TextView fir,fir6,fir2,fir3,fir4,fir5;

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


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myprefs2);
        getSupportActionBar().hide();
        getWindow().setNavigationBarColor(getResources().getColor(R.color.black));

        see=findViewById(R.id.see);
        fir=findViewById(R.id.fir);
        myprefsB=findViewById(R.id.mypredfsB);
        del=findViewById(R.id.del);

        see2=findViewById(R.id.see2);
        fir2=findViewById(R.id.fir2);
        myprefsB2=findViewById(R.id.mypredfsB2);
        del2=findViewById(R.id.del2);

        see3=findViewById(R.id.see3);
        fir3=findViewById(R.id.fir3);
        myprefsB3=findViewById(R.id.mypredfsB3);
        del3=findViewById(R.id.del3);

        see4=findViewById(R.id.see4);
        fir4=findViewById(R.id.fir4);
        myprefsB4=findViewById(R.id.mypredfsB4);
        del4=findViewById(R.id.del4);

        see5=findViewById(R.id.see5);
        fir5=findViewById(R.id.fir5);
        myprefsB5=findViewById(R.id.mypredfsB5);
        del5=findViewById(R.id.del5);

        see6=findViewById(R.id.see7);
        fir6=findViewById(R.id.fir6);
        myprefsB6=findViewById(R.id.mypredfsB6);
        del6=findViewById(R.id.del6);



        sharedPreferences =getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        sharedPreferences2 =getSharedPreferences(SHARED_PREF_NAME2,MODE_PRIVATE);
        sharedPreferences3 =getSharedPreferences(SHARED_PREF_NAME3,MODE_PRIVATE);
        sharedPreferences4 =getSharedPreferences(SHARED_PREF_NAME4,MODE_PRIVATE);
        sharedPreferences5 =getSharedPreferences(SHARED_PREF_NAME5,MODE_PRIVATE);
        sharedPreferences6 =getSharedPreferences(SHARED_PREF_NAME6,MODE_PRIVATE);


        String name = sharedPreferences.getString(KEY_NAME,null);
        String name2 = sharedPreferences2.getString(KEY_NAME2,null);
        String name3 = sharedPreferences3.getString(KEY_NAME3,null);
        String name4 = sharedPreferences4.getString(KEY_NAME4,null);
        String name5 = sharedPreferences5.getString(KEY_NAME5,null);
        String name6 = sharedPreferences6.getString(KEY_NAME6,null);


        if (name!=null) {
            fir.setText("TITLE : "+name);
            myprefsB.setVisibility(View.INVISIBLE);
        }
        if (name2!=null) {
            fir2.setText("TITLE : "+name2);
            myprefsB2.setVisibility(View.INVISIBLE);
        }
        if (name3!=null) {
            fir3.setText("TITLE : "+name3);
            myprefsB3.setVisibility(View.INVISIBLE);
        }
        if (name4!=null) {
            fir4.setText("TITLE : "+name4);
            myprefsB4.setVisibility(View.INVISIBLE);
        }
        if (name5!=null) {
            fir5.setText("TITLE : "+name5);
            myprefsB5.setVisibility(View.INVISIBLE);
        }
        if (name6!=null) {
            fir6.setText("TITLE : "+name6);
            myprefsB6.setVisibility(View.INVISIBLE);
        }

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name==null){
                    Toast.makeText(Myprefs2.this,"Not yet added to delete",Toast.LENGTH_SHORT).show();
                    Intent inte =new Intent(Myprefs2.this,Myprefs2.class);
                    inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(inte);
                    inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                }
                else {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.clear();
                    editor.commit();
                    Intent inte = new Intent(Myprefs2.this, Myprefs2.class);
                    inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(inte);
                    inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                }
            }
        });
        del2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name2==null){
                    Toast.makeText(Myprefs2.this,"Not yet added to delete",Toast.LENGTH_SHORT).show();
                    Intent inte =new Intent(Myprefs2.this,Myprefs2.class);
                    inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(inte);
                    inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                }
                else {
                    SharedPreferences.Editor editor = sharedPreferences2.edit();
                    editor.clear();
                    editor.commit();
                    Intent inte = new Intent(Myprefs2.this, Myprefs2.class);
                    inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(inte);
                    inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                }
            }
        });
        del3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name3==null){
                    Toast.makeText(Myprefs2.this,"Not yet added to delete",Toast.LENGTH_SHORT).show();
                    Intent inte =new Intent(Myprefs2.this,Myprefs2.class);
                    inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(inte);
                    inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                }
                else {
                    SharedPreferences.Editor editor = sharedPreferences3.edit();
                    editor.clear();
                    editor.commit();
                    Intent inte = new Intent(Myprefs2.this, Myprefs2.class);
                    inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(inte);
                    inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                }
            }
        });
        del4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name4==null){
                    Toast.makeText(Myprefs2.this,"Not yet added to delete",Toast.LENGTH_SHORT).show();
                    Intent inte =new Intent(Myprefs2.this,Myprefs2.class);
                    inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(inte);
                    inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                }
                else {
                    SharedPreferences.Editor editor = sharedPreferences4.edit();
                    editor.clear();
                    editor.commit();
                    Intent inte = new Intent(Myprefs2.this, Myprefs2.class);
                    inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(inte);
                    inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                }
            }
        });
        del5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name5==null){
                    Toast.makeText(Myprefs2.this,"Not yet added to delete",Toast.LENGTH_SHORT).show();
                    Intent inte =new Intent(Myprefs2.this,Myprefs2.class);
                    inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(inte);
                    inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                }
                else {
                    SharedPreferences.Editor editor = sharedPreferences5.edit();
                    editor.clear();
                    editor.commit();
                    Intent inte = new Intent(Myprefs2.this, Myprefs2.class);
                    inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(inte);
                    inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                }
            }
        });
        del6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name6==null){
                    Toast.makeText(Myprefs2.this,"Not yet added to delete",Toast.LENGTH_SHORT).show();
                    Intent inte =new Intent(Myprefs2.this,Myprefs2.class);
                    inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(inte);
                    inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                }
                else {
                    SharedPreferences.Editor editor = sharedPreferences6.edit();
                    editor.clear();
                    editor.commit();
                    Intent inte = new Intent(Myprefs2.this, Myprefs2.class);
                    inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(inte);
                    inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                }
            }
        });

        see.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name==null){
                    Toast.makeText(Myprefs2.this,"Not yet added",Toast.LENGTH_SHORT).show();
                    Intent inte =new Intent(Myprefs2.this,Myprefs2.class);
                    inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(inte);
                    inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                }
                else {
                    Intent inte = new Intent(Myprefs2.this, MainActivity4.class);
                    inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(inte);
                    inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                }
            }
        });
        see2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name2==null){
                    Toast.makeText(Myprefs2.this,"Not yet added",Toast.LENGTH_SHORT).show();
                    Intent inte =new Intent(Myprefs2.this,Myprefs2.class);
                    inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(inte);
                    inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                }
                else {
                    Intent inte = new Intent(Myprefs2.this, m411.class);
                    inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(inte);
                    inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                }
            }
        });

        see3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name3==null){
                    Toast.makeText(Myprefs2.this,"Not yet added",Toast.LENGTH_SHORT).show();
                    Intent inte =new Intent(Myprefs2.this,Myprefs2.class);
                    inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(inte);
                    inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                }
                else {
                    Intent inte = new Intent(Myprefs2.this, m422.class);
                    inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(inte);
                    inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                }
            }
        });

        see4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name4==null){
                    Toast.makeText(Myprefs2.this,"Not yet added",Toast.LENGTH_SHORT).show();
                    Intent inte =new Intent(Myprefs2.this,Myprefs2.class);
                    inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(inte);
                    inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                }
                else {
                    Intent inte = new Intent(Myprefs2.this,m433.class);
                    inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(inte);
                    inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                }
            }
        });

        see5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name5==null){
                    Toast.makeText(Myprefs2.this,"Not yet added",Toast.LENGTH_SHORT).show();
                    Intent inte =new Intent(Myprefs2.this,Myprefs2.class);
                    inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(inte);
                    inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                }
                else {
                    Intent inte = new Intent(Myprefs2.this, m444.class);
                    inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(inte);
                    inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                }
            }
        });

        see6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name6==null){
                    Toast.makeText(Myprefs2.this,"Not yet added",Toast.LENGTH_SHORT).show();
                    Intent inte =new Intent(Myprefs2.this,Myprefs2.class);
                    inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(inte);
                    inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                }
                else {
                    Intent inte = new Intent(Myprefs2.this, m455.class);
                    inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(inte);
                    inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                }
            }
        });


        myprefsB.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v) {
                    Intent intent12 = new Intent(Myprefs2.this, MainActivity5.class);
                    intent12.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent12);
                    intent12.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            }
        });
        myprefsB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent12 = new Intent(Myprefs2.this, m511.class);
                intent12.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent12);
                intent12.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            }
        });
        myprefsB3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent12 = new Intent(Myprefs2.this, m522.class);
                intent12.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent12);
                intent12.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            }
        });
        myprefsB4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent12 = new Intent(Myprefs2.this, m533.class);
                intent12.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent12);
                intent12.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            }
        });
        myprefsB5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent12 = new Intent(Myprefs2.this, m544.class);
                intent12.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent12);
                intent12.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            }
        });
        myprefsB6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent12 = new Intent(Myprefs2.this, m555.class);
                intent12.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent12);
                intent12.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            }
        });
    }

    protected void onStart() {
        super.onStart();
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
    }
}