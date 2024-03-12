package com.example.myapplication6;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity1 extends AppCompatActivity {

    private static final String SHARED_PREF_NAME2 ="mypref2";
    private static final String KEY_NAME2 ="name2";
    private static final String KEY_EMAIL2 ="email2";
    private EditText username, password, repassword;
    private Button signup,signin;
    String emailPattern = "[a-zA-z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;

    FirebaseAuth mAuth;
    FirebaseUser mUser;

    FirebaseFirestore db;

    SharedPreferences sharedPreferences2;

    boolean doubleTapToExit =false;
    final int duration =2000;
    View view;

    EditText t1,t2,t3;
    Button b1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register1);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        getSupportActionBar().hide();
        getWindow().setNavigationBarColor(getResources().getColor(R.color.black));

        db=FirebaseFirestore.getInstance();


        view = findViewById(android.R.id.content);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.repassword);
        signin = (Button) findViewById(R.id.signin);
        signup = (Button) findViewById(R.id.signup);
        progressDialog = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        t1 = (EditText) findViewById(R.id.editTextText2);
        t2 = (EditText) findViewById(R.id.editTextPhone2);
        t3 = (EditText) findViewById(R.id.editTextDate2);
        b1= (Button) findViewById(R.id.signup);

        sharedPreferences2= getSharedPreferences(SHARED_PREF_NAME2,MODE_PRIVATE);


        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PerforAuth();
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(RegisterActivity1.this,LoginActivity1.class);
                intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent1);
            }
        });
    }




    private void PerforAuth()
    {

        String email1=username.getText().toString();
        String password1=password.getText().toString();
        String repassword1=repassword.getText().toString();
        String nam=t1.getText().toString();
        String pno=t2.getText().toString();
        String dat=t3.getText().toString();

        if(!email1.matches(emailPattern))
        {
            username.setError("Enter Context Email");
        }
        else if(password1.isEmpty()||password1.length()<6)
        {
            password.setError("Enter proper password");
        }
        else if(!password1.equals(repassword1))
        {
            repassword.setError("Password not matched");
        }
        else
        {
            progressDialog.setMessage("Please wait till registeration");
            progressDialog.setTitle("Registeration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            Map<String,Object> user = new HashMap<>();
            user.put("Email",email1);
            user.put("Password",password1);
            user.put("Name",nam);
            user.put("Phone Number",pno);
            user.put("Date Of Birth",dat);
            db.collection("User data").add(user).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                @Override
                public void onSuccess(DocumentReference documentReference) {

                }
            });

            SharedPreferences.Editor editor=sharedPreferences2.edit();
            editor.putString(KEY_NAME2,username.getText().toString());
            editor.putString(KEY_EMAIL2,password.getText().toString());
            editor.apply();
            String name = sharedPreferences2.getString(KEY_NAME2,null);
            String email = sharedPreferences2.getString(KEY_EMAIL2,null);

            mAuth.createUserWithEmailAndPassword(email1,password1).addOnCompleteListener(new OnCompleteListener<AuthResult>()
            {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task)
                {
                    if (task.isSuccessful())
                    {
                        progressDialog.dismiss();
                       // sendUserToNextActivity();
                        Intent intent0=new Intent(RegisterActivity1.this,MainActivity.class);
                        startActivity(intent0);
                        Toast.makeText(RegisterActivity1.this, "Registaration Successfull", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        progressDialog.dismiss();
                        Toast.makeText(RegisterActivity1.this,"Registeration Unsuccessfull",Toast.LENGTH_SHORT).show();

                    }

                };
            });
        }
    }
    protected void onStart(){
        super.onStart();
        overridePendingTransition(0,0);
        if(mAuth.getCurrentUser()!=null){
           Intent intent = new Intent(RegisterActivity1.this, RegisterActivity1.class);
           intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
           intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            finish();
        }
        else{
        }
    }

    @Override
    public void onBackPressed(){
        if(doubleTapToExit){
            //super.onBackPressed();
            /*moveTaskToBack(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(0);*/
            RegisterActivity1.this.finishAffinity();
            //RegisterActivity1.this.finishAndRemoveTask();
            return;
        }else{
            doubleTapToExit=true;
            Snackbar.make(view,"Press again to exit...",duration).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubleTapToExit=false;
                }
            },duration);
        }
    }
}