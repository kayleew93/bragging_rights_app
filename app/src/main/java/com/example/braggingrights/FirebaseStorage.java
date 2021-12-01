package com.example.braggingrights;

import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseStorage {

    String fullName, playerNickname;

    public FirebaseStorage() {
    }

    public FirebaseStorage(String fullName, String playerNickname) {
        this.fullName = fullName;
        this.playerNickname = playerNickname;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPlayerNickname() {
        return playerNickname;
    }

    public void setPlayerNickname(String playerNickname) {
        this.playerNickname = playerNickname;
    }

}
