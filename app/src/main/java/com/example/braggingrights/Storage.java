package com.example.braggingrights;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public interface Storage {

    //TODO: Write to cloud; return void
    public static void writeToCloud() {
        // [START write_message]
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference firstNameDB = database.getReference("firstName");
        firstNameDB.setValue("value");

        DatabaseReference lastNameDB = database.getReference("lastName");
        lastNameDB.setValue("value");
    }

    //TODO: Retrieve from cloud; return string
}
