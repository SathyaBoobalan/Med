package com.example.myapplication6;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class m433 extends AppCompatActivity {
    EditText titleEditText, contentEditTest;
    Button saveNoteBtn;
    TextView textView_name,textView_email;
    Button button_logout;
    SharedPreferences sharedPreferences4;
    private static final String SHARED_PREF_NAME4 ="mypref4";
    private static final String KEY_NAME4 ="name4";
    private static final String KEY_EMAIL4 ="email4";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m433);
        getSupportActionBar().hide();
        getWindow().setNavigationBarColor(getResources().getColor(R.color.black));

        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

        textView_name=findViewById(R.id.textView_name);
        textView_email=findViewById(R.id.textView_email12);
        button_logout=findViewById(R.id.button_logout12);

        sharedPreferences4 =getSharedPreferences(SHARED_PREF_NAME4,MODE_PRIVATE);

        String name = sharedPreferences4.getString(KEY_NAME4,null);
        String email = sharedPreferences4.getString(KEY_EMAIL4,null);

        if (name!=null|| email!=null){
            textView_name.setText("TITLE :\n"+name);
            textView_email.setText("PRESCRIPTION :\n" +email);
        }

        button_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        /*titleEditText = findViewById(R.id.titleEditText);
        titleEditText = findViewById(R.id.contentEditTest);
        saveNoteBtn = findViewById(R.id.saveNoteBtn);


        saveNoteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNote();
            }
        });*/
    }


    /*private void saveNote() {
        String noteTitle = titleEditText.getText().toString();
        String noteContent = contentEditTest.getText().toString();
        if (noteTitle == null || noteTitle.isEmpty()) {
            titleEditText.setError("Title is required");
            return;
        }
        Note note = new Note();
        note.setTitle(noteTitle);
        note.setContent(noteContent);
        note.setTimestamp(Timestamp.now());

        saveNoteToFirebase(note);
    }

    void saveNoteToFirebase(Note note) {
        DocumentReference documentReference;
        documentReference = Utility.getCollectionReferenceForNotes().document();

        documentReference.set(note).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Utility.showToast(MainActivity4.this, "Note added successfully");
                } else {
                    Utility.showToast(MainActivity4.this, "Failed while adding note");
                }
            }
        });
    }*/

   /* @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();

    }*/

    protected void onStart() {
        super.onStart();
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
    }
}