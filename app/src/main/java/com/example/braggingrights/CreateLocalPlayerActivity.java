package com.example.braggingrights;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

public class CreateLocalPlayerActivity extends AppCompatActivity {

    // Variables
    TextView fullName, pNickname, phoneNumber;
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
        phoneNumber = findViewById(R.id.phoneNumber);
    }

    public void selectAvatar(View view) {
        startActivity(new Intent(CreateLocalPlayerActivity.this, SelectAvatar.class));
    }


        public void clickCreatePlayer(View view) {
            //TODO: send info to create a player
            rootNode = FirebaseDatabase.getInstance();
            reference = rootNode.getReference("playerInfo");

            // Get the values
            String playerFullName = fullName.getText().toString();
            String playerNickname = pNickname.getText().toString();
            String playerPhoneNumber = phoneNumber.getText().toString();
            Integer totalGames = 0;
            Integer gamesWon = 0;

            FirebaseStoragePlayer firebaseStorage = new FirebaseStoragePlayer(playerFullName, playerNickname, playerPhoneNumber, totalGames, gamesWon);

            reference.child(playerNickname).setValue(firebaseStorage);

            Toast.makeText(CreateLocalPlayerActivity.this, "Successfully created player", Toast.LENGTH_LONG).show();
        }
}