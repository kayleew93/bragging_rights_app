package com.example.braggingrights;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public interface Storage {

    //TODO: Write to cloud; return void
    static void writeToCloud() {
        // [START write_message]
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference firstNameDB = database.getReference("firstName");
        firstNameDB.setValue("value");

        DatabaseReference lastNameDB = database.getReference("lastName");
        lastNameDB.setValue("value");
    }

    //TODO: Retrieve from cloud; return string
    // Read from the database
    /*
    myRef.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            // This method is called once with the initial value and again
            // whenever data at this location is updated.
            String value = dataSnapshot.getValue(String.class);
            Log.d(TAG, "Value is: " + value);
        }

        @Override
        public void onCancelled(DatabaseError error) {
            // Failed to read value
            Log.w(TAG, "Failed to read value.", error.toException());
        }
    }); */
}
