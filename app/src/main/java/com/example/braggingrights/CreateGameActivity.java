package com.example.braggingrights;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputLayout;

public class CreateGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_game);

    }

    public void clickCreateNewGameTemplate(View view) {
        // Send user to Create Game Activity
        startActivity(new Intent(CreateGameActivity.this, AddNewGameTemplate.class));
    }
}