package com.example.braggingrights;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StatisticsMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics_main);
    }

    public void clickViewStatsByGame(View view) {
        startActivity(new Intent(StatisticsMainActivity.this, ViewStatsByGameActivity.class));
    }

    public void clickViewStatsByPlayer(View view) {
        startActivity(new Intent(StatisticsMainActivity.this, ViewStatsByPlayerActivity.class));
    }
}