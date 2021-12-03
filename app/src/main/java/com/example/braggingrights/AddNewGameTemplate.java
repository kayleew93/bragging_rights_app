package com.example.braggingrights;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AddNewGameTemplate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_game_template);
    }
    public void cancelTemplate(View view) {
        startActivity(new Intent(AddNewGameTemplate.this, CreateGameActivity.class));
    }
}

