package com.example.braggingrights;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class CreateLocalPlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_local_player);
    }

    public void clickCreatePlayer(View view) {
        //TODO: send info to create a player

        Toast.makeText(CreateLocalPlayerActivity.this, "Successfully created player", Toast.LENGTH_LONG).show();
    }
}