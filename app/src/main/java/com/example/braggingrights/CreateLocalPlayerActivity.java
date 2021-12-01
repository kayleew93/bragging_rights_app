package com.example.braggingrights;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateLocalPlayerActivity extends AppCompatActivity implements Storage {

    // Variables
    TextView fullName, pNickname;
    // male/female; avatar
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_local_player);

        // hooks all xml elements in activity_create_local_player.xml
        fullName = findViewById(R.id.playerName);
        pNickname = findViewById(R.id.playerNickname);
    }

    public void clickCreatePlayer(View view) {
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("playerInfo");

        // Get the values
        String playerFullName = fullName.getText().toString();
        String playerNickname = pNickname.getText().toString();

        FirebaseStorage firebaseStorage = new FirebaseStorage(playerFullName, playerNickname);

        reference.child(playerNickname).setValue(firebaseStorage);


        Toast.makeText(CreateLocalPlayerActivity.this, "Successfully created player", Toast.LENGTH_LONG).show();
    }
}