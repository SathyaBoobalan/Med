package com.example.myapplication6;

import static com.google.firebase.auth.FirebaseAuth.*;
import static com.google.firebase.auth.FirebaseAuth.getInstance;

import android.content.Context;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class Utility {

    static void showToast(Context context,String message){
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }

    static CollectionReference getCollectionReferenceForNotes(){

        FirebaseUser currentUser = getInstance().getCurrentUser();
        return FirebaseFirestore.getInstance().collection("")
                .document(currentUser.getUid()).collection("");

    }

}
