package com.example.braggingrights;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickCreateGame(View view) {
        // Send user to Create Game Activity
        startActivity(new Intent(MainActivity.this, CreateGameActivity.class));
    }

    public void clickCreateLocalPlayer(View view) {
        // Send user to Create Local Player Activity
        startActivity(new Intent(MainActivity.this, CreateLocalPlayerActivity.class));
    }

    public void clickViewStatistics(View view) {
        // Send user to View Statistics Activity
        startActivity(new Intent(MainActivity.this, StatisticsMainActivity.class));
    }
}