package com.example.braggingrights;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseUpload {
    private DatabaseReference databaseReference;
    public FirebaseUpload() {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(FirebaseStoragePlayer.class.getSimpleName());
    }

    public Task<Void> add(FirebaseStoragePlayer fbsp) {
        return databaseReference.push().setValue(fbsp);
    }

}
